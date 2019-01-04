package com.jiayoo.view;
import java.io.IOException;
import java.util.Scanner;

public class WelcomeView {
    private String userName;

    public  String choice;
    public static void main(String[] args) throws IOException {
        new WelcomeView().WelcomeView("123");
    }


    public void WelcomeView(String userName) throws IOException {
        this.userName = userName;
        System.out.println("-----------------------------------");
        System.out.println("------------Welcome----------------");
        System.out.println("-----------------------------------");
        System.out.println("-----------1.修改密码---------------");
        System.out.println("-----------2.添加好友---------------");
        System.out.println("-----------3.添加群组---------------");
        System.out.println("-----------4.删除好友---------------");
        System.out.println("-----------5.删除群组---------------");
        System.out.println("-----------6.好友聊天---------------");
        System.out.println("-----------7.群组聊天---------------");
        System.out.println("-----------8.退出-------------------");

        System.out.println("请输入-----------：");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()){
            int n = sc.nextInt();
            WelcomeViewDeal(n);

        }else {
            System.out.println("输入有误！");
            WelcomeView(userName);
        }

    }




    private void WelcomeViewDeal(int n) throws IOException {

        switch (n){
            case 1: // 修改密码
                new ChangePass().changePassDeal(userName);
                WelcomeView(userName);
                break;
            case 2:
                // 添加好友
                new FriendView(userName).addFriendView();
                System.out.println("添加成功");
                WelcomeView(userName);
                break;

            case 3:// 添加群组
                new GroupView(userName).addGroup();
                WelcomeView(userName);
                break;

            case 4:// 删除好友
                new FriendView(userName).deleteFrien();
                WelcomeView(userName);
                break;
            case 5://删除群组
               new GroupView(userName).deleteGroup();
                WelcomeView(userName);
                break;
            case 6:// 好友聊天
                choice = "friendchat";
                break;
            case 7://群组聊天

                choice = "allchat";
                break;
            case 8://退出
                System.out.println("再见！");
                System.exit(0);
                break;
                default:
                    System.out.println("输入有误，重新输入！");
                    WelcomeView(userName);
                    break;
        }
    }




}
