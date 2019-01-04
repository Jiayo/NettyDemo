package com.jiayoo.impl;

import com.jiayoo.Dao.UserDao;
import com.jiayoo.bean.User;
import com.jiayoo.jdbc.DBUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    DBUtil db = new DBUtil("/home/jiayoo/WorkData/jiwangHomework/ChatClient/src/main/java/com/jiayoo/jdbc/DBUtil.properties");

    public UserDaoImpl() throws IOException {
    }

    @Override
    public Long insert(User bean) {
        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<>();
        // 组合Sql
        sbSQL.append("insert into user");
        sbSQL.append("(");
        sbSQL.append(" userName, userId, userPass");

        sbSQL.append(") ");
        sbSQL.append(" values(?,null,?)");

        // 添加参数
        paramsList.add(bean.getUserName());
        paramsList.add(bean.getUserPass());


        int num = 0;
        // 转换类型
        String sql = sbSQL.toString();
        Object[] params = paramsList.toArray();

        try {
            db.connectDb();
            num = db.executeUpdate(sql,params);
            if (num > 0){
                System.out.println("插入User数据成功！");
            }else {
                System.out.println("User数据插入失败");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.closeConnect();
        }

        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public Long update(User bean) {
        Long result = 0L;

        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<>();

        // 组合
        sbSQL.append("update user set");
        sbSQL.append("  userPass=?");
        sbSQL.append(" where userName=?");

        // 添加参数
        paramsList.add(bean.getUserPass());
        paramsList.add(bean.getUserName());

        // 转换类型
        String sql = sbSQL.toString();
        Object[] params = paramsList.toArray();

        int num;

        try {
            db.connectDb();
            num = db.executeUpdate(sql,params);
            if (num > 0){
                System.out.println("修改数据成功！");
            }

        }catch (Exception e){

        }finally {
            db.closeConnect();
        }

        return null;
    }

    @Override
    public Long count() {
        ResultSet result = null;

        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<>();

        sbSQL.append("select count(1) from user");

        // 2添加参数

        // 3
        String sql = sbSQL.toString();
        Object[] params = paramsList.toArray();

        Long count = 0L;

        try {
            db.connectDb();
            result = db.executeQuery(sql);
            if (result.next()){
                System.out.println("查询数据成功！");
                count = result.getLong(1);
                return  count;
            }else {
                System.out.println("查询失败！");
            }
        }catch (Exception e){

        }finally {
            db.closeConnect();
        }

        return count;
    }

    @Override
    public User load(Long id) {
        return null;
    }

    @Override
    public List<User> list() {
        List<User> list = new ArrayList<User>();
        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<>();
        sbSQL.append("select * from user");
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
                list.add(new User(rs));
            }
        }catch (Exception e){

        }finally {
            db.closeConnect();
        }


        return list;
    }

    @Override
    public User loadByName(String name) {

        User bean = null;

        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<>();

        sbSQL.append("select * from user");
        sbSQL.append("  where userName like ? ");
        sbSQL.append("order by userId asc ");

        // 2添加参数
        name = "%" + name + "%";
        paramsList.add(name);

        // 3转换类型
        String sql = sbSQL.toString();
        Object[] params = paramsList.toArray();


        ResultSet rs = null;


        try {
            db.connectDb();
            rs = db.executeQuery(sql, params);
            if (rs.next()){
                bean = new User(rs);
                return  bean;
            }else {
                System.out.println("查询失败！");
            }

        }catch (Exception e){

        }finally {
            db.closeConnect();
        }

        return bean;
    }

    @Override
    public Long countByName(String name) {
        return null;
    }

    @Override
    public List<User> pager(Long pageNum, Long pageSize) {
        return null;
    }

    @Override
    public List<User> pagerByName(String name, Long pageNum, Long pageSize) {
        return null;
    }
}
