package com.jiayoo.view;

import java.util.Scanner;

public class ChatFriendView {
    private  String userName = null;

    public ChatFriendView(String userName){
        this.userName = userName;
    }
    public String chat(){
        new FriendView(userName).friendList();

        System.out.println("输入您要聊天的用户：");
        Scanner sc = new Scanner(System.in);
        String friendName = sc.nextLine();
        return  friendName;
    }



}
