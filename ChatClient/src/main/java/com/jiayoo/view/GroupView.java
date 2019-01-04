package com.jiayoo.view;


import com.jiayoo.bean.Group;
import com.jiayoo.test.thrift.ThriftClient;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class GroupView {
    private String userName;
    public static void main(String[] args) throws IOException {
        GroupView groupView = new GroupView("123");
//        groupView.groupList();
//        groupView.addGroup();
//        groupView.deleteGroup();
    }
    public GroupView(String userName) throws IOException {
        this.userName = userName;
    }

    public void groupView() throws IOException {

    }

    public void addGroup() throws IOException {
        groupList();
        System.out.println("输入您要加入的组号：");
        Scanner sc = new Scanner(System.in);
        Long groupNum = sc.nextLong();
        new ThriftClient().insertGroup(new Group(userName, groupNum));
        System.out.println("加入组成功！");
        new WelcomeView().WelcomeView(userName);

    }

    public void  deleteGroup() throws IOException {
        groupList();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入您要删除的组ID: ");
        Long groupId = sc.nextLong();
        new ThriftClient().deleteGroup(userName, groupId);
    }



    private void groupList() throws IOException {
        System.out.println("您当前加入的所有组有： ");

        List<Group> groupList = new ThriftClient().groupListByUserName(userName);
        if (groupList.isEmpty()){
            System.out.println("您还没加入任何组");
        }else {
            groupList.forEach(group -> {
                System.out.println("ID:"+ group.getGroupId());
            });
        }

    }

    private void groupUserList(){
        System.out.println("输入您要查询的组的ID：");

    }

}
