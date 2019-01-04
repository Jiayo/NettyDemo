package com.jiayoo.impl;

import com.jiayoo.Dao.GroupDao;
import com.jiayoo.bean.Group;
import com.jiayoo.jdbc.DBUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GroupDapImpl implements GroupDao {
    DBUtil db = new DBUtil("/home/jiayoo/WorkData/jiwangHomework/ChatClient/src/main/java/com/jiayoo/jdbc/DBUtil.properties");

    public GroupDapImpl() throws IOException {
    }

    @Override
    public Long insert(Group bean) {


        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<>();

        // 组合Sql
        sbSQL.append("insert into `group`");
        sbSQL.append("(");
        sbSQL.append(" userName,dataId, groupId");
        sbSQL.append(") ");
        sbSQL.append(" values(?,null,?)");

        // 添加参数
        paramsList.add(bean.getUserName());
        paramsList.add(bean.getGroupId());


        int num = 0;
        // 转换类型
        String sql = sbSQL.toString();
        Object[] params = paramsList.toArray();

        try {
            db.connectDb();
            num = db.executeUpdate(sql,params);
            if (num > 0){
                System.out.println("插入数据成功！");
            }else {
                System.out.println("插入数据失败！");
            }

        }catch (Exception e){

        }finally {
            db.closeConnect();
        }

        return null;
    }

    @Override
    public Long delete(String userName, Long id) {
        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<>();

  /*      3、删除表数据
        delete from 表名 where 查询条件
        若无查询条件，表中所有数据行都会被删除。*/
        // 组合Sql
        sbSQL.append("delete from `group` ");
        sbSQL.append(" where userName=? and groupId=?");
        // 添加参数
        paramsList.add(userName);
        paramsList.add(id);


        int num = 0;
        // 转换类型
        String sql = sbSQL.toString();
        Object[] params = paramsList.toArray();

        try {
            db.connectDb();
            num = db.executeUpdate(sql,params);
            if (num > 0){
                System.out.println("数据group成功！");
            }else {
                System.out.println("删除group数据失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.closeConnect();
        }

        return null;
    }

    @Override
    public Long update(Group bean) {
        return null;
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public List<Group> loadById(Long id) {
        List<Group> list = new ArrayList<Group>();
        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<>();
        sbSQL.append("select * from `group` where groupId=?");
        Group group = null;
        paramsList.add(id);
        // 转换类型
        String sql = sbSQL.toString();
        Object[] params = paramsList.toArray();

        ResultSet rs = null;

        try {
            db.connectDb();
            rs = db.executeQuery(sql, params);


            while (rs.next()){
                group = new Group(rs);
                list.add(group);
            }

        }catch (Exception e){

        }finally {
            db.closeConnect();
        }
        return list;
    }

    @Override
    public List<Group> list() {

        return null;
    }

    @Override
    public List<Group> listByUserName(String userName) {
        List<Group> list = new ArrayList<Group>();
        StringBuffer sbSQL = new StringBuffer();
        List<Object> paramsList = new ArrayList<>();
        sbSQL.append("select * from `group` where userName=? ");

        paramsList.add(userName);
        // 转换类型
        String sql = sbSQL.toString();
        Object[] params = paramsList.toArray();

        ResultSet rs = null;

        try {
            db.connectDb();
            rs = db.executeQuery(sql, params);
            if (rs == null){
                System.out.println("查询组别失败！");
            }

            while (rs.next()){
                list.add(new Group(rs));
            }

        }catch (Exception e){

        }finally {
            db.closeConnect();
        }
        return list;
    }

    @Override
    public Group loadByName(String name) {
        return null;
    }

    @Override
    public Long countByName(String name) {
        return null;
    }

    @Override
    public List<Group> pager(Long pageNum, Long pageSize) {
        return null;
    }

    @Override
    public List<Group> pagerByName(String name, Long pageNum, Long pageSize) {
        return null;
    }
}
