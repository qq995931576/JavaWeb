package com.achang.test;

import com.achang.bean.User;
import com.achang.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/******
 @author 阿昌
 @create 2020-11-25 23:48
 *******
 */
public class UserDaoTest {
    UserDaoImpl userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin")==null){
            System.out.println("用户名可用");
        }else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(1,"achang999","915456","achang999@qq.com")));

    }

    @Test
    public void queryUserByUsernameAndPassword() {
      if (userDao.queryUserByUsernameAndPassword("admin","admin")==null){
          System.out.println("用户名或密码错误，登入失败");
      }else {
          System.out.println("登入成功");
      }
    }
}