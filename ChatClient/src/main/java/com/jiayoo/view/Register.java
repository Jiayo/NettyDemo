package com.jiayoo.view;


import com.jiayoo.bean.User;
import com.jiayoo.test.thrift.ThriftClient;


import java.io.IOException;
import java.util.Scanner;

public class Register {

    public void register() throws InterruptedException, IOException {
        String userName;
        String userPass;
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎来到注册界面！");
        System.out.println("输入用户名：");
        userName = sc.nextLine();
        System.out.println("输入密码：");
        userPass = sc.nextLine();

        System.out.println("您的用户名和密码是： " +userName +  userPass);
        new ThriftClient().insertUser(userName, userPass);
        System.out.println("注册成功！ 2 秒后返回登录界面！");
//        Thread.sleep(2000);
        new Login().start();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new Register().register();
    }

}
