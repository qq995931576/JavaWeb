package com.achang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/******
 @author 阿昌
 @create 2020-11-30 23:08
 *******
 */
public class LoginServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("achang168".equals(username) && "915945".equals(password)) {
            //登录成功
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 24);//当前cookie对象一天有效
            resp.addCookie(cookie);
            System.out.println("登录成功");

        } else {
            //登录失败
            System.out.println("登录失败");
        }

    }
}
