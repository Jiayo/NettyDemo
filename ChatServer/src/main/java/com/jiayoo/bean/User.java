package com.jiayoo.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private  String userName;
    private Long userId;
    private String userPass;

    public User(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    public User() {
        super();
    }

    public User(ResultSet resultSet) throws SQLException {
        setUserId(resultSet.getLong("userId"));
        setUserName(resultSet.getString("userName"));
        setUserPass(resultSet.getString("userPass"));

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }
}
