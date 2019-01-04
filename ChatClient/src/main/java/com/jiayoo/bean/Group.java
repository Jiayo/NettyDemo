package com.jiayoo.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * userName: 用户名
 * dataId :  数据条目
 * groupId ： 用户加入的组名
 * */
public class Group {

    private String userName;
    private Long dataId;
    private Long groupId;

    public Group(String userName, Long groupId) {
        this.userName = userName;
        this.groupId = groupId;
    }

    public Group(ResultSet resultSet) throws SQLException {
        setUserName(resultSet.getString("userName"));
        setGroupId(resultSet.getLong("groupId"));

    }


    public Group() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }


    @Override
    public String toString() {
        return "Group{" +
                "userName='" + userName + '\'' +
                ", dataId=" + dataId +
                ", groupId=" + groupId +
                '}';
    }
}
