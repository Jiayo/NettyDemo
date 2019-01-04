package com.jiayoo.Dao;

import com.jiayoo.bean.Dialog;

import java.util.List;

public interface DialogDao {
    Long insert(Dialog bean);
    Long delete(Long id);
    Long update(Dialog bean);
    Long count();
    Dialog load(Long id);
    List<Dialog> list();
    Dialog loadByName(String name);
    Long countByName(String name);
    List<Dialog> pager(Long pageNum, Long pageSize);
    List<Dialog> pagerByName(String name, Long pageNum, Long pageSize);

}
