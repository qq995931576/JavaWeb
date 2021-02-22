package com.achang.dao.impl;

import com.achang.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/******
 @author 阿昌
 @create 2020-11-25 22:49
 *******
 */
public class BaseDao {
    //使用DBUtils操作数据库
    //创建dbutils的QueryRunner实例对象
    private QueryRunner runner = new QueryRunner();


    //增删改语句
    //返回-1，说明执行失败，返回其他值为影响的行数
    public int update(String sql,Object...param){
        Connection conn = JDBCUtils.getConnection();
        try {
            return runner.update(conn,sql,param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    //查询语句，返回一个对象
    public <T>Object queryForOne(Class<T> type,String sql,Object...args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return runner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }


    //查询语句，返回多个对象
    public <T> List<T> queryForList(Class<T> type, String sql, Object...args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return runner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    //查询语句，返回单个一行一列的值
    public Object queryForSingleVaule(String sql,Object...args){
        Connection conn = JDBCUtils.getConnection();
        try {
            Object query = runner.query(conn,sql,new ScalarHandler(),args);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

}
