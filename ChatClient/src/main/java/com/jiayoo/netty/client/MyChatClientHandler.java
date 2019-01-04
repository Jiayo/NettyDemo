package com.jiayoo.netty.client;


import com.jiayoo.proto.MyDataInfo;
import com.jiayoo.view.ChangePass;
import com.jiayoo.view.ChatFriendView;
import com.jiayoo.view.Login;
import com.jiayoo.view.WelcomeView;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class MyChatClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage>{
    String passName = null;
    String choice = null;
    MyDataInfo.MyMessage myMessage = null;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {
        MyDataInfo.MyMessage.ResponseType responseType = msg.getResponseType();
        MyDataInfo.MyMessage.DataType dataType =msg.getDataType();

        if (responseType == MyDataInfo.MyMessage.ResponseType.LoginSuccess){
            System.out.println("测试输入成功");
            chatSupport(ctx, msg);

        }else if (responseType == MyDataInfo.MyMessage.ResponseType.AddFriendTypeSuccess){
            String resMsg = msg.getMessage();
            if (resMsg.equals("ex000")){
                System.out.println("发送失败，对方不在线");
                chatSupport(ctx, msg);
            }else if (resMsg.equals("sc000")){
                Scanner sc = new Scanner(System.in);
                System.out.println("输入你要发送的信息");
                String message = sc.nextLine();
                message += passName + "说： " + message;
                myMessage = MyDataInfo.MyMessage.newBuilder().setMessage(message).setDataType(
                        MyDataInfo.MyMessage.DataType.DeleteFriendType).build();
                ctx.channel().writeAndFlush(myMessage);
            }

        }else if (responseType == MyDataInfo.MyMessage.ResponseType.ChangePassSuccess){
            System.out.println(msg.getMessage());
            chatSupport(ctx, msg);
        }else if (dataType == MyDataInfo.MyMessage.DataType.ChangePassType){
            System.out.println("xxxxxxxx");
        }
    }

    private void chatSupport(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws IOException {
        WelcomeView welcomeView = new WelcomeView();
        welcomeView.WelcomeView(passName );
        System.out.println(passName+ "------------------------");
        this.choice = welcomeView.choice;
        if (choice.equals("friendchat")){
            String friendName =   new ChatFriendView(passName).chat();
            myMessage = MyDataInfo.MyMessage.newBuilder().setMessage(friendName).setDataType(
                    MyDataInfo.MyMessage.DataType.AddFriendType).build();
            ctx.channel().writeAndFlush(myMessage);

        }else {

            System.out.println("下面输入您要广播的话:(q 退出)");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for (; ;) {
                String message = br.readLine();
                if (message.equals("q")){
                    break;
                }
                myMessage = MyDataInfo.MyMessage.newBuilder().setMessage(passName + "说：" +message).setDataType(
                        MyDataInfo.MyMessage.DataType.ChangePassType).build();
                ctx.channel().writeAndFlush(myMessage);
            }

        }

    }




    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 向服务端发送写请求
        MyDataInfo.MyMessage myMessage = null;
        Login login = new Login();
        login.start();
        passName = login.passName;
        if (passName==null){
            channelActive(ctx);
        }
        myMessage = MyDataInfo.MyMessage.newBuilder().setMessage(passName).setDataType(
                MyDataInfo.MyMessage.DataType.LoginType).build();

        ctx.channel().writeAndFlush(myMessage);

    }
}
