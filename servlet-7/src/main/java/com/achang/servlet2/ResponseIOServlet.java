package com.achang.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 阿昌
 * @create 2020-11-05 21:23
 */
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println(resp.getCharacterEncoding());//ISO-8859-1默认

//        //设置服务器的字符集为UTF-8
//        resp.setCharacterEncoding("UTF-8");
//        //通过响应头，设置浏览器也使用UTF-8
//        resp.setHeader("Content-Type","Text/html;charset=UTF-8");

        //同时让服务器和客户端都使用UTF-8，还设置了响应头
        //此方法一定要在获取流对象之前调用
        resp.setContentType("Text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.println("responese's content!!!---1");
        writer.write("阿昌加油");

    }
}
