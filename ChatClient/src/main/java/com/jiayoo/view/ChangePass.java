package com.jiayoo.view;

import com.jiayoo.test.thrift.ThriftClient;
import java.util.Scanner;

public class ChangePass {
    String userName ;
    Scanner sc = new Scanner(System.in);


    public static void main(String[] args){
        new ChangePass().changePassDeal("123");
    }

    public void  changePassDeal(String userName){
        this.userName = userName;
        String newPass = null;
        System.out.println("输入您的旧密码：");

        if (sc.hasNextLine()){
            String oldPass = sc.nextLine();
        }else {
            System.out.println("输入有误！");
            changePassDeal(this.userName);
        }

        System.out.println("输入您的新密码：");

        if (sc.hasNextLine()){
             newPass = sc.nextLine();
        }else {
            System.out.println("输入有误！");
            changePassDeal(this.userName);
        }
        /*
        * 调用远程方法
        * */

            new ThriftClient().updateUser(userName, newPass);

            System.out.println("修改密码成功！");
    }

}
