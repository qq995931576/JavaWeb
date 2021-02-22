package com.achang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 阿昌
 * @create 2020-11-03 19:44
 */
public class HelloServlet2 extends HttpServlet {

    //doGET()方法 在GET请求的时候调用
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2的doGet()方法");
    }


    //doPost()方法 在Post请求的时候调用
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2的doPOST()方法");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("你好");
    }
}
