package com.jiayoo.view;



import com.jiayoo.bean.User;
import com.jiayoo.test.thrift.ThriftClient;


import java.io.IOException;
import java.util.Scanner;

public class Login {

    public String passName = null;

    public  void  start() throws IOException, InterruptedException {

        System.out.println("-----------------------------------------");
        System.out.println("|--------------Welcome------------------|");
        System.out.println("|---------------------------------------|");
        System.out.println("|------------1.Sign in------------------|");
        System.out.println("|------------2.Sign up------------------|");
        System.out.println("|---------------------------------------|");
        System.out.println("|---------------------------------------|");
        System.out.println("-----------------------------------------");

        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个数字！");
        if (sc.hasNextInt()){
            int n = sc.nextInt();
            sc.nextLine();
            switch (n){
                case 1:
                    System.out.println("输入用户名！");
                    String userName = sc.nextLine();
                    System.out.println("输入密码!");
                    String  userPass = sc.nextLine();
                    System.out.println(userName + " " + userPass);
                    verification(userName, userPass);
                    break;
                case 2 :
                    new Register().register();
                    break;
                default:
                    System.out.println("输入有误！重新输入！");
                    start();
                    break;
        }

        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Login login = new Login();
        login.start();
        System.out.println(login.passName);
    }

    private boolean verification(String userName, String userPass){
        try {

            User user = new ThriftClient().loadUserByName(userName);
            if (user == null){
                System.out.println("查无此人！");
                start();
            }

            if (user.getUserName().equals(userName) && userPass.equals(user.getUserPass())){
                // 用户名且密码正确
                System.out.println("可以登录了");
                this.passName = userName;

//                new WelcomeView().WelcomeView(userName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }


}
