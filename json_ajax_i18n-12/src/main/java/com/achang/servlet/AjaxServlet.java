package com.achang.servlet;

import com.achang.bean.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/******
 @author 阿昌
 @create 2020-12-03 18:43
 *******
 */
public class AjaxServlet extends BaseServlet {


    protected void javaServletAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AJAX请求过来了");

        Person person = new Person(1, "张飞");

        //json格式的字符串
        Gson gson = new Gson();
        String personJson = gson.toJson(person);

        resp.getWriter().write(personJson);

    }

    protected void jQuerytAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerytAjax   ---   方法调用了");
        Person person = new Person(1, "赵云");

        //json格式的字符串
        Gson gson = new Gson();
        String personJson = gson.toJson(person);

        resp.getWriter().write(personJson);

    }


    protected void jQuerytGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerytGet   ---   方法调用了");
        Person person = new Person(1, "关羽");

        //json格式的字符串
        Gson gson = new Gson();
        String personJson = gson.toJson(person);

        resp.getWriter().write(personJson);

    }


    protected void jQuerytPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerytPost   ---   方法调用了");
        Person person = new Person(1, "黄忠");

        //json格式的字符串
        Gson gson = new Gson();
        String personJson = gson.toJson(person);

        resp.getWriter().write(personJson);

    }


    protected void jQuerytgetJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerytGetJSON   ---   方法调用了");
        Person person = new Person(1, "黄忠");

        //json格式的字符串
        Gson gson = new Gson();
        String personJson = gson.toJson(person);

        resp.getWriter().write(personJson);

    }


    protected void jQuerytSerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerytSerialize   ---   方法调用了");
        System.out.println("用户名： " + req.getParameter("username"));
        System.out.println("密  码： " + req.getParameter("password"));

        Person person = new Person(1, "马超");

        //json格式的字符串
        Gson gson = new Gson();
        String personJson = gson.toJson(person);

        resp.getWriter().write(personJson);

    }


}