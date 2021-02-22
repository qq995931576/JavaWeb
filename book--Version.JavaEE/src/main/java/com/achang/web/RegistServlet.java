package com.achang.web;

import com.achang.bean.User;
import com.achang.service.UserService;
import com.achang.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/******
 @author 阿昌
 @create 2020-11-26 11:32
 *******
 */
public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2.检查验证码是否正确，先写死，要求，验证码为:abcde
        if ("abcde".equalsIgnoreCase(code)){
            //检查用户名是否可用
            if (userService.existsUsername(username)){
                //把错误信息，和回显的表单项信息，保存到Request域中
                req.setAttribute("errorMsg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

                //跳转到注册页面
                req.getRequestDispatcher("pages/user/regist.jsp").forward(req,resp);
            }else {
                //调用Service保存到数据库
                userService.registUser(new User(0,username,password,email));
                //跳转到注册成功页面
                req.getRequestDispatcher("pages/user/regist_success.jsp").forward(req,resp);
            }

        }else {
            //把回显信息，保存到Request域中
            req.setAttribute("errorMsg","验证码错误!!!");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            //跳转到注册页面
            System.out.println("验证码 ["+code+"] 错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

}
