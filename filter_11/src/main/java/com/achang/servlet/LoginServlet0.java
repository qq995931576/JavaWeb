//package com.achang.servlet;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///******
// @author 阿昌
// @create 2020-12-02 16:16
// *******
// */
//public class LoginServlet0 extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("123123");
//        resp.setContentType("text/html;charset=UTF-8");
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        if ("achang168".equals(username) && "915945".equals(password)){
//            req.getSession().setAttribute("user",username);
//            resp.getWriter().write("登录 成功");
//        }else {
//            req.getRequestDispatcher("/login.jsp").forward(req,resp);
//        }
//    }
//}
