package com.jiayoo.bean;

public class LoginUser {

    private static String userName;

    public LoginUser(String userName){
        setUserName(userName);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
