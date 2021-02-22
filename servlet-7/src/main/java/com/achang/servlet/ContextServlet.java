package com.achang.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 阿昌
 * @create 2020-11-03 22:37
 */
public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.获取web.xml中配置的上下文参数context-param
        ServletContext servletContext = getServletConfig().getServletContext();
        String username = servletContext.getInitParameter("username");
        System.out.println("context-param参数username的值是: " + username);
        System.out.println("context-param参数password的值是: " + servletContext.getInitParameter("password"));
//        2.获取当前的工程路径，	格式:/工程路径
        System.out.println("当前工程路径: " + servletContext.getContextPath());
//        3.获取工程部署后在服务器磁盘上的绝对路径
        /*
            / 斜杆被服务器解析地址为:http://ip:port/工程名/     映射到IDEA代码的webapp目录
         */
        System.out.println("工程部署的路径是: " + servletContext.getRealPath("/"));
    }
}
