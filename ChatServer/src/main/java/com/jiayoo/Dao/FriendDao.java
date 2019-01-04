package com.jiayoo.Dao;

import com.jiayoo.bean.Friend;

import java.util.List;

public interface FriendDao {
    Long insert(Friend bean);
    Long delete(String userName, String frienName);
    Long update(Friend bean);
    Long count();
    Friend load(Long id);
    List<Friend> list(String userName);
    Friend loadByName(String name);
    Long countByName(String name);
    List<Friend> pager(Long pageNum, Long pageSize);
    List<Friend> pagerByName(String name, Long pageNum, Long pageSize);
}
