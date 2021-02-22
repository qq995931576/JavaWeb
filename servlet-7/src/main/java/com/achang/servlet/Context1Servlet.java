package com.achang.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 阿昌
 * @create 2020-11-03 23:29
 */

public class Context1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext context = getServletContext();
        System.out.println(context);//org.apache.catalina.core.ApplicationContextFacade@11f32f19
        System.out.println("保存之前: context中获取数据key1的value值是: " + context.getAttribute("key1"));//null

        context.setAttribute("key1", "value1");

        System.out.println("Context1Servlet中获取数据key1的value值是: " + context.getAttribute("key1"));//key1
    }
}
