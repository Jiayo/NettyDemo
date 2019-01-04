package com.jiayoo.netty.client;


import com.jiayoo.proto.MyDataInfo;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.HashMap;
import java.util.Map;

public class MyChatServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage>{
//    private Map<String, Channel> mapChannels = new HashMap<>();
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {



//        Channel channelFriend = null;

        MyDataInfo.MyMessage.DataType dataType = msg.getDataType();
        MyDataInfo.MyMessage myMessage = null;
        if (dataType == MyDataInfo.MyMessage.DataType.LoginType){
            System.out.println("测试输入成功");
            String passName = msg.getMessage();
            System.out.println(passName);
//            Channel channel = ctx.channel();
//            mapChannels.put(passName, channel);
//            System.out.println(mapChannels.size());
//            System.out.println(mapChannels.get(passName));
            System.out.println(channelGroup.size());


//            System.out.println(passName + " " + channel.remoteAddress() );

            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setResponseType(MyDataInfo.MyMessage.ResponseType.LoginSuccess).build();
            ctx.channel().writeAndFlush(myMessage);
        }else if (dataType == MyDataInfo.MyMessage.DataType.AddFriendType){
            System.out.println("服务端开始检测朋友状态");
            String friendName = msg.getMessage();
//            System.out.println();
//            channelFriend = mapChannels.get(friendName);
//            String friendMsg = null;
            /*if (channelFriend == null){
                friendMsg = "ex000";
                System.out.println("目标用户不在线");
                myMessage[0] = MyDataInfo.MyMessage.newBuilder().setMessage(friendMsg)
                        .setResponseType(MyDataInfo.MyMessage.ResponseType.AddFriendTypeSuccess).build();
                ctx.channel().writeAndFlush(myMessage[0]);
            }else {
                String onLine = "sc000";
                myMessage[0] = MyDataInfo.MyMessage.newBuilder().setMessage(onLine)
                        .setResponseType(MyDataInfo.MyMessage.ResponseType.AddFriendTypeSuccess).build();
                ctx.channel().writeAndFlush(myMessage[0]);
            }*/
        }else if (dataType == MyDataInfo.MyMessage.DataType.ChangePassType){

            Channel channel = ctx.channel();
            System.out.println(msg.getMessage());
  /*          channelGroup.forEach(ch -> {
                if(channel != ch) {

                    ch.writeAndFlush(msg);

                }
            });*/
        }

    }



    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("【服务器】- " + channel.remoteAddress() + " 加入\n");
        channelGroup.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        ChannelId id = channel.id();
        channelGroup.writeAndFlush("【服务器】- " + channel.remoteAddress() + " 离开\n");

        System.out.println(channelGroup.size());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + " 上线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + " 下线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
