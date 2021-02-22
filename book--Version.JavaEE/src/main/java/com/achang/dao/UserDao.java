package com.achang.dao;

import com.achang.bean.User;

/******
 @author 阿昌
 @create 2020-11-25 23:22
 *******
 */
public interface UserDao {

    //根据用户名查询用户信息
    public Object queryUserByUsername(String username);

    //保存用户信息到数据库
    public int saveUser(User user);

    //根据用户名和密码，查询数据库是否匹配
    public User queryUserByUsernameAndPassword(String username,String password);
}
