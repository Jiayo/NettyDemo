package com.jiayoo.impl;

import com.jiayoo.Dao.FriendDao;
import com.jiayoo.bean.Friend;
import com.jiayoo.bean.User;
import com.jiayoo.jdbc.DBUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FriendDaoImpl implements FriendDao {
    DBUtil db = new DBUtil("/home/jiayoo/WorkData/jiwangHomework/ChatClient/src/main/java/com/jiayoo/jdbc/DBUtil.properties");

    public FriendDaoImpl() throws IOException {
    }

    @Override
    public Long insert(Friend bean) {

        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<>();
        // 组合Sql
        sbSQL.append("insert into friend");
        sbSQL.append("(");
        sbSQL.append(" I_count, Y_count");

        sbSQL.append(") ");
        sbSQL.append(" values(?,?)");

        // 添加参数
        paramsList.add(bean.getI_count());
        paramsList.add(bean.getY_count());


        int num = 0;
        // 转换类型
        String sql = sbSQL.toString();
        Object[] params = paramsList.toArray();

        try {
            db.connectDb();
            num = db.executeUpdate(sql,params);
            if (num > 0){
                System.out.println("插入Friend数据成功！");
            }else {
                System.out.println("Friend数据插入失败");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.closeConnect();
        }
        return null;
    }

    @Override
    public Long delete(String userName, String frienName) {
        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<>();

  /*      3、删除表数据
        delete from 表名 where 查询条件
        若无查询条件，表中所有数据行都会被删除。*/
        // 组合Sql
        sbSQL.append("delete from friend");
        sbSQL.append(" where I_count=? and Y_count=?");
        // 添加参数
        paramsList.add(userName);
        paramsList.add(frienName);


        int num = 0;
        // 转换类型
        String sql = sbSQL.toString();
        Object[] params = paramsList.toArray();

        try {
            db.connectDb();
            num = db.executeUpdate(sql,params);
            if (num > 0){
                System.out.println("删除Friend数据成功！");
            }else {
                System.out.println("删除Friend数据失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.closeConnect();
        }

        return null;
    }

    @Override
    public Long update(Friend bean) {
        return null;
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Friend load(Long id) {
        return null;
    }

    @Override
    public List<Friend> list(String userName) {
        List<Friend> list = new ArrayList<Friend>();
        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<>();
        sbSQL.append("select * from friend where I_count=?");
        paramsList.add(userName);
        // 转换类型
        String sql = sbSQL.toString();
        Object[] params = paramsList.toArray();

        ResultSet rs = null;

        try {
            db.connectDb();
            rs = db.executeQuery(sql, params);
            if (rs == null){
                System.out.println("查询失败！");
            }

            while (rs.next()){
                list.add(new Friend(rs));
            }
        }catch (Exception e){

        }finally {
            db.closeConnect();
        }
        return list;
    }

    @Override
    public Friend loadByName(String name) {
        return null;
    }

    @Override
    public Long countByName(String name) {
        return null;
    }

    @Override
    public List<Friend> pager(Long pageNum, Long pageSize) {
        return null;
    }

    @Override
    public List<Friend> pagerByName(String name, Long pageNum, Long pageSize) {
        return null;
    }
}
