package com.achang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/******
 @author 阿昌
 @create 2020-11-26 15:54
 *******
 */
public class PrintHtml extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过响应的回传流 回传html页面数据

        //设置浏览器与服务器端的字符集
        resp.setContentType("text/html; charset=UTF-8");
        //得到响应流
        PrintWriter writer = resp.getWriter();

        writer.write("<!DOCTYPE html >\r\n");
        writer.write("  <html lang = \"en\" >\r\n");
        writer.write("      <head >\r\n");
        writer.write("          <meta charset = \"UTF-8\" >\r\n");
        writer.write("          <title > Title </title >\r\n");
        writer.write("      </head >\r\n");
        writer.write("       <body >\r\n");
        writer.write("              这是html页面数据\r\n");
        writer.write("       </body >\r\n");
        writer.write("  </html >\r\n");
        writer.write("\r\n");

    }

}
