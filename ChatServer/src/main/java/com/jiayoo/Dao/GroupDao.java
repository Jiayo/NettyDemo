package com.jiayoo.Dao;

import com.jiayoo.bean.Group;

import java.util.List;

public interface GroupDao {
    Long insert(Group bean);
    Long delete(String userName, Long id);
    Group loadByName(String name);
    List<Group> listByUserName(String userName);
    Long update(Group bean);
    Long count();
    public List<Group> loadById(Long id);
    List<Group> list();
    Long countByName(String name);
    List<Group> pager(Long pageNum, Long pageSize);
    List<Group> pagerByName(String name, Long pageNum, Long pageSize);

}
