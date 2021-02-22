package com.achang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/******
 @author 阿昌
 @create 2020-12-01 12:59
 *******
 */
public class SessionServlet extends BaseServlet {

    protected void createOrGetSeesion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取Session会话对象
        HttpSession session = req.getSession();
        //判断session对象是否是新建的
        boolean isNew = session.isNew();
        //获取session对象的唯一标识id
        String id = session.getId();

        resp.getWriter().write("得到的session，它的id是： " + id + "<br>");
        resp.getWriter().write("这个session是否是新建的： " + isNew + "<br>");
    }


    /**
     * 往Session中保存数据
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("已经往session中保存了数据");

    }

    /**
     * 获取Session域中的数据
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("从Session中获取key1的数据是：" + attribute);

    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //获取了Session的默认超时时长
        int maxInactiveInterval = session.getMaxInactiveInterval();
        resp.getWriter().write("session的默认超时时长为: " + maxInactiveInterval + "秒");   //1800秒
    }

    protected void setLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("session的超时时长已修改为： " + session.getMaxInactiveInterval());
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //让Session会话 立即超时
        session.invalidate();
        resp.getWriter().write("session已被设置为立刻销毁");
    }


}
