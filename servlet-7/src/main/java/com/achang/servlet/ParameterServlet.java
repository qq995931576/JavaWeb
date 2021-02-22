package com.achang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author 阿昌
 * @create 2020-11-04 22:50
 */
public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------------------doGet--------------------");
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");

        System.out.println("用户名: " + username + " 密 码: " + password + " 兴趣爱好: " + Arrays.asList(hobby));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------------------doPost--------------------");
        //设置请求体的字符集为UTF-8，从而解决POST请求中文乱码问题
        //也要在获取参数之前调用才有效
        req.setCharacterEncoding("UTF-8");
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");

        System.out.println("用户名: " + username + " 密 码: " + password + " 兴趣爱好: " + Arrays.asList(hobby));

    }
}
