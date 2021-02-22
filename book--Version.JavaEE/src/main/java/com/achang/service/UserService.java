package com.achang.service;

import com.achang.bean.User;

/******
 @author 阿昌
 @create 2020-11-26 0:03
 *******
 */
public interface UserService {

    //注册用户
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return 返回null登录失败，返回有值则登录成功
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);

}
