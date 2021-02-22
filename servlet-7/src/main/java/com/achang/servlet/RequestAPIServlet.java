package com.achang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 阿昌
 * @create 2020-11-04 22:27
 */

public class RequestAPIServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //       ①getRequestURI()				获取请求的URI资源路径地址
        System.out.println("URI => " + request.getRequestURI()); ///servlet_7/requestAPIServlet

//        ②getRequstURL()					获取请求的统一资源定位符（绝对路径）
        System.out.println("UIL => " + request.getRequestURL()); //http://localhost:8080/servlet_7/requestAPIServlet

//        ③getRemoteHost()				获取客户端的ip地址
        /*
        在IDEA中，使用 localhost 访问时，得到的客户端ip地址是 --->>>  127.0.0.1 <br/>
        在IDEA中，使用 127.0.0.1 访问时，得到的客户端ip地址是 --->>>  127.0.0.1 <br/>
        在IDEA中，使用 真实ip 访问时，得到的客户端ip地址是 --->>>  真实的ip地址
         */
        System.out.println("客户端ip地址 => " + request.getRemoteHost());//127.0.0.1

//        ④getHeader()					获取请求头
        System.out.println("请求头User-Agent =>>> " + request.getHeader("User-Agent"));

//        ⑤getMethod()					获取请求的方式GET或POST
        System.out.println("请求的方式 ->>> " + request.getMethod());
    }
}
