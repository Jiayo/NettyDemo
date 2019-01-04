package com.jiayoo.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Dialog {

    private String userName;

    public Dialog(ResultSet resultSet) throws SQLException {
         userName = resultSet.getString("userName");
    }

    @Override
    public String toString() {
        return "Dialog{" +
                "userName='" + userName + '\'' +
                '}';
    }

    public Dialog(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
