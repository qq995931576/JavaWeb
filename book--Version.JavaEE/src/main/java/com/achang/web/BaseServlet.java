package com.achang.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

/******
 @author 阿昌
 @create 2020-11-28 15:01
 *******
 */
public abstract class BaseServlet extends HttpServlet {

    //子类模块继承此类，不重写doPost()方法,因此调用的是父类BaseServlet的doPost()方法，
    //然后通过下面的方法反射出子类this的方法名，并且调用方法。完成业务请求。
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        //解决响应的中文乱码问题
        resp.setContentType("text/html;charset=UTF-8");
        //解决post请求中文乱码问题
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        //处理登录请求
        try {
            //获取action业务，鉴别字符串，获取相应的业务方法，反射对象
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            //调用目标业务方法
            method.invoke(this,req,resp);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e); //把异常抛给Filter过滤器
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
