package com.jiayoo.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Friend {

    private String i_count;
    private String y_count;

    public Friend(String i_count, String y_count) {
        this.i_count = i_count;
        this.y_count = y_count;
    }


    public Friend(ResultSet resultSet) throws SQLException {
        setI_count(resultSet.getString("I_count"));
        setY_count(resultSet.getString("Y_count"));
    }

    public Friend() {
        super();
    }

    public String getI_count() {
        return i_count;
    }

    public void setI_count(String i_count) {
        this.i_count = i_count;
    }

    public String getY_count() {
        return y_count;
    }

    public void setY_count(String y_count) {
        this.y_count = y_count;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "i_count='" + i_count + '\'' +
                ", y_count='" + y_count + '\'' +
                '}';
    }
}
