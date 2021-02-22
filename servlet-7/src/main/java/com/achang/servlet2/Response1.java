package com.achang.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 阿昌
 * @create 2020-11-05 22:14
 */
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("曾到此一游 Response1 ");

        //设置响应状态码302，表示重定向（已搬迁）
        resp.setStatus(302);
        //设置响应头，说明 新的地址在哪里
        resp.setHeader("Location", "http://localhost:8080/servlet_7/response2");

        //因为响应状态码302是固定的，就直接省略了
        resp.sendRedirect("http://localhost:8080/servlet_7/response2");
    }
}
