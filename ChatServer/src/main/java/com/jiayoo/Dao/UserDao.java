package com.jiayoo.Dao;

import com.jiayoo.bean.User;

import java.util.List;

public interface UserDao {

    Long insert(User bean);
    User loadByName(String name);
    Long update(User bean);
    Long delete(Long id);

    Long count();
    User load(Long id);
    List<User> list();

    Long countByName(String name);
    List<User> pager(Long pageNum, Long pageSize);
    List<User> pagerByName(String name, Long pageNum, Long pageSize);
}
