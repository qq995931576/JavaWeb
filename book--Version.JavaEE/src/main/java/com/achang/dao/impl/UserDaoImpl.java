package com.achang.dao.impl;

import com.achang.bean.User;
import com.achang.dao.UserDao;

/******
 @author 阿昌
 @create 2020-11-25 23:30
 *******
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id,username,password,email from t_user where username = ?";
        return (User) queryForOne(User.class,sql,username);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email)values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email from t_user where username = ? And password = ?";
        return (User) queryForOne(User.class,sql,username,password);
    }
}
