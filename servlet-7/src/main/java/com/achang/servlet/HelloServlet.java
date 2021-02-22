package com.achang.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 阿昌
 * @create 2020-11-02 21:18
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1 构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init初始化方法");


//        1. 可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名是: " + servletConfig.getServletName());
//        2. 获取初始化参数init-param
        System.out.println("初始化参数username的值是: " + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数username的值是: " + servletConfig.getInitParameter("url"));
//        3. 获取ServletContext对象
        System.out.println(servletConfig.getServletContext());


    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /*
    service()方法是专门用来处理请求和响应的
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service == Hello Servlet 被访问了");
        //类型转换
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取请求方式
        String method = httpServletRequest.getMethod();

        if ("GET".equals(method)) {
            getmethod();

        } else if ("POST".equals(method)) {
            postmethod();
        }
    }

    public void getmethod() {
        System.out.println("get请求");
        System.out.println("get请求");
        System.out.println("get请求");
    }

    public void postmethod() {
        System.out.println("post请求");
        System.out.println("post请求");
        System.out.println("post请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 destroy销毁方法");
    }

}
