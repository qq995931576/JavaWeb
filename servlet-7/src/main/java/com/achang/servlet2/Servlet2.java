package com.achang.servlet2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 阿昌
 * @create 2020-11-05 19:34
 */
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数（办事的资料） 查看
        String username = req.getParameter("username");
        System.out.println("在Servlet2（柜台2）中查看参数（材料）+ " + username);

        //查看 柜台1 是否有盖章
        Object key = req.getAttribute("key");
        System.out.println("柜台1是否有盖章 " + key);

        //处理自己的业务
        System.out.println("Servlet2处理自己的业务");

    }
}
