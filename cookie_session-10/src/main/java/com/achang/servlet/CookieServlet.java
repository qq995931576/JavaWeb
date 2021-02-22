package com.achang.servlet;

import com.achang.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/******
 @author 阿昌
 @create 2020-11-30 19:37
 *******
 */
public class CookieServlet extends BaseServlet {


    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、创建Cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        Cookie cookie1 = new Cookie("key2", "value2");
        //2、通知客户端保存cookie
        resp.addCookie(cookie);
        resp.addCookie(cookie1);

        resp.getWriter().write("cookie创建成功");

    }


    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        for (Cookie cookie : cookies) {
//            //getName()：返回cookie的key（名）
//            //getValue(): 返回cookie的value（值）
//            resp.getWriter().write("cookie【"+ cookie.getName() +"=" + cookie.getValue() + "】<br/>");
//        }
        Cookie[] cookies = req.getCookies();
        Cookie iwantCookie = CookieUtils.findCookie("key1", cookies);


    }


    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //方案1：
//             //1、先创建一个要修改的同名的cookie对象
//             //2、在构造器，同时赋予新的cookie值
//                Cookie cookie = new Cookie("key1","newValue1");
//             //3、调用response.addCookie(cookie);
//                resp.addCookie(cookie); //通知 客户端 保存修改
//
//            resp.getWriter().write("key1的cookie已经修改好");

//        方案二：
//        1、先查找到需要修改的 Cookie 对象
        Cookie cookie1 = CookieUtils.findCookie("key2", req.getCookies());
        if (cookie1 != null) {
//         2、调用 setValue()方法赋于新的 Cookie 值。
            cookie1.setValue("newValue2");
//        3、调用 response.addCookie()通知客户端保存修改
            resp.addCookie(cookie1);
        }


    }


    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("default", "defaultLife");
        cookie.setMaxAge(-1);//设置存活时间
        resp.addCookie(cookie);


    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie key1 = CookieUtils.findCookie("key1", req.getCookies());
        if (key1 != null) {
            key1.setMaxAge(0);//表示马上删除
            resp.addCookie(key1);

            resp.getWriter().write("key1删除");
        }
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("key3", "value3");
        cookie.setMaxAge(60 * 60);//设置cookie一小时后删除
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建一个存活1小时的cookie");
    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        //getContextPath()--->得到工程路径
        cookie.setPath(req.getContextPath() + "/abc");    //--->/工程路径/abc
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有path路径的cookie对象");
    }


}
