package com.achang.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 阿昌
 * @create 2020-11-05 20:25
 */
public class ForWardC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("经过了ForWardC程序");

        req.getRequestDispatcher("/a/b/c.html").forward(req, resp);
    }
}
