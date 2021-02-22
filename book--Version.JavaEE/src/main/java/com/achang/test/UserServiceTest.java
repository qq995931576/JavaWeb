package com.achang.test;

import com.achang.bean.User;
import com.achang.service.UserService;
import com.achang.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/******
 @author 阿昌
 @create 2020-11-26 10:27
 *******
 */
public class UserServiceTest {

    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(0,"achang001","achang00000","achang001@qq.com"));
        userService.registUser(new User(0,"achang002","achang0000","achang002@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(4,"achang999","915456",null)));//User{id=4, username='achang999', password='915456', email='achang999@qq.com'}
        System.out.println(userService.login(new User(0,"asd","123",null)));//null
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("achang02201")){
            System.out.println("用户名已存在");
        }else {
            System.out.println("用户名可用");
        }
    }

}