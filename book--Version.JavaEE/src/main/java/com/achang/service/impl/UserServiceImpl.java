package com.achang.service.impl;

import com.achang.bean.User;
import com.achang.dao.UserDao;
import com.achang.dao.impl.UserDaoImpl;
import com.achang.service.UserService;

/******
 @author 阿昌
 @create 2020-11-26 10:19
 *******
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username)==null){
            return false;//表示用户名可用
        }else{
            return true;//表示用户名已存在
        }
    }

}
