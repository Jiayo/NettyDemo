package com.jiayoo.view;


import com.jiayoo.bean.Friend;
import com.jiayoo.bean.User;
import com.jiayoo.test.thrift.ThriftClient;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FriendView {
    private  String userName;

    public FriendView(String userName) {
        this.userName = userName;
    }

    public static void main(String[] args){
        FriendView addFriend = new FriendView("123");
        try {
//           addFriend.addFriendView();
            addFriend.deleteFrien();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addFriendView() throws IOException {

        Scanner sc = new Scanner(System.in);
        friendList();

        System.out.println("输入您要添加的好友的账号：");
        String friendName = sc.nextLine();

        User user = new ThriftClient().loadUserByName(friendName);

        if (friendName.equals(userName)){
            System.out.println("账号为自己的请重新输入");
            addFriendView();
        }

        if (user== null){
            System.out.println("查无此人！");
            addFriendView();
        }

        new ThriftClient().insertFriend(new Friend(userName, friendName));
    }


    public void friendList(){
        System.out.println("您当前的好友有：");
        List<Friend> friendList = new ThriftClient().friendList(userName);
        friendList.forEach(friend -> {

            System.out.println("好友: "+friend.getY_count());
        });
    }


    public void  deleteFrien() throws IOException {

        friendList();
        System.out.println("输入您要删除的好友的账号： ");
        Scanner sc = new Scanner(System.in);
        String friendName = sc.nextLine();
        new ThriftClient().deleteFriend(userName, friendName);
        System.out.println("删除成功！");

    }
}
