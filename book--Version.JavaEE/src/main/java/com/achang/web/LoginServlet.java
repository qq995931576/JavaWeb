package com.achang.web;

import com.achang.bean.User;
import com.achang.dao.UserDao;
import com.achang.service.UserService;
import com.achang.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/******
 @author 阿昌
 @create 2020-11-26 14:00
 *******
 */
public class LoginServlet extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.调用 userService.Login()登录处理业务
        User loginUser = userService.login(new User(0, username, password, null));

        //3.根据login()方法返回结果判断登录是否成功
        if (loginUser ==null){
            //4.如果等于null，登入失败
            //把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg","用户名或密码错误!");
            req.setAttribute("username",username);


            //5.转跳login登入页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            System.out.println("登录成功");
            //6.不为null，登入成功，跳转login_success页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

}
