package com.achang.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/******
 @author 阿昌
 @create 2020-11-25 15:55
 *******
 */
public class JDBCUtils {

    private static DataSource source;
    private static ThreadLocal<Connection> threadLocalConns = new ThreadLocal<>();

    static{
        try {
            Properties pros = new Properties();
            FileInputStream is = new FileInputStream(new File("D:\\JavaStudy\\JavaWeb\\book\\src\\main\\java\\jdbc.properties"));
            pros.load(is);
            source = DruidDataSourceFactory.createDataSource(pros);
            System.out.println(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取数据库连接池中的连接
    public static Connection getConnection() {

        Connection conn = threadLocalConns.get();

        if (conn == null){
            try {
                conn = source.getConnection();//从数据库连接池中获取连接
                threadLocalConns.set(conn);//保存到ThreadLocal对象中，供后面的JDBC操作使用

                conn.setAutoCommit(false);//设置为手动管理事务

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }


    //提交事务，并关闭释放连接
    public static void commitAndClose(){

        Connection connection = threadLocalConns.get();
        if (connection != null){ //如果不等于null，说明 之前使用过连接，操作过数据库
            try {
                connection.commit(); //提交事务

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close(); //关闭连接，释放资源
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
        //一定要执行remove操作，否则就会出错（因为Tomcat服务器底层使用了线程池技术）---会内存泄漏
        threadLocalConns.remove();
    }

    //回滚事务，并关闭释放连接
    public static void robackAndClose(){
        Connection connection = threadLocalConns.get();

        if (connection != null){//如果不等于null，说明 之前使用过连接，操作过数据库
            try {
                connection.rollback(); //回滚事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close(); //关闭连接，释放资源
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，否则就会出错（因为Tomcat服务器底层使用了线程池技术）---会内存泄漏
        threadLocalConns.remove();
    }





//    //关闭连接，放回数据库连接池
//    public static void closeConnection(Connection conn){
//        if (conn != null){
//            try {
//                conn.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//    }



}
