package com.jiayoo.jdbc;

import com.jiayoo.jdbc.properties.Read_Myprop;

import java.io.IOException;
import java.sql.*;

/**
 * @program: TestProject
 * @description: NULL
 * @author: jiayoo
 * @create: 2018-11-19 00:38
 **/
public class DBUtil {

    private String dri;  // 使用的数据库驱动
    private String url; // 连接所需的链接
    private String userName; // 用户名
    private String password; // ，密码
    private Read_Myprop myprop; // 配置文件
    private Connection conn = null; // 链接
    private  ResultSet set = null;  // 结果集
    private PreparedStatement preparedStatement;

    /**
     * create by: jiayoo
     * description: 构造函数，用来初始化链接的数据
     * create time: 10:41 2018/11/19
     * params : properties 配置文件的路径
     */
    public DBUtil( String path) throws IOException {
        myprop = new Read_Myprop("/home/jiayoo/WorkData/IDEA/ChatServer/src/main/java/com/jiayoo/jdbc/DBUtil.properties");
        this.dri = (String) myprop.getValue("dri");
        this.url = (String) myprop.getValue("url");
        this.userName = (String) myprop.getValue("userName");
        this.password = (String) myprop.getValue("password");
    }

    /**
     * create by: jiayoo
     * description: 连接到数据库
     * create time: 10:43 2018/11/19
     */
    public void  connectDb() throws ClassNotFoundException, SQLException {
        Class.forName(dri);
        conn = DriverManager.getConnection(url,userName,password);
    }

    /**
     * create by: jiayoo
     * description:用来查询的语句
     * create time: 8:33 2018/11/20
     * params : 查询的sql语句
     * @return 结果集
     */
    public ResultSet executeQuery(String sql){
        try {
            preparedStatement = conn.prepareStatement(sql);
             set = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  set;
    }
     /**
      * create by: jiayoo
      * description:用来查询的语句
      * create time: 8:34 2018/11/20
      * params : 查询的sql语句， 和所需要的参数
      * @return 结果集
      */
    public ResultSet executeQuery(String sql, Object[] parms){
        try {
            preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < parms.length ; i++){
                preparedStatement.setObject(i+1, parms[i]);
            }
            set = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  set;
    }

    /**
     * create by: jiayoo
     * description: 用来更新数据的语句
     * create time: 8:36 2018/11/20
     * params :  sql语句
     * @return  更新的结果
     */
    public int executeUpdate(String sql) throws SQLException {
        try {
            preparedStatement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

       return preparedStatement.executeUpdate();
    }

    public int executeUpdate(String sql, Object[] parms) throws SQLException {
        try {
            preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < parms.length ; i++){
                preparedStatement.setObject(i+1, parms[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement.executeUpdate();
    }




    /**
     * create by: jiayoo
     * description:用来关闭数据库
     * create time: 0:32 2018/11/20
     */

    public void closeConnect(){
        if(set != null){
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(preparedStatement !=null ){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
