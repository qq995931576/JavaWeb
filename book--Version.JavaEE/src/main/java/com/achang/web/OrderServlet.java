package com.achang.web;

import com.achang.bean.Cart;
import com.achang.bean.User;
import com.achang.service.OrderService;
import com.achang.service.impl.OrderServiceImpl;
import com.achang.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.JdbcRowSet;
import java.io.IOException;

/******
 @author 阿昌
 @create 2020-12-02 13:22
 *******
 */
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    //生成订单
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取UserId
        User loginUser = (User) req.getSession().getAttribute("user");

        if (loginUser ==null){
            req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);
            return;
        }
        int userId = loginUser.getId();

        String orderId = orderService.createOrder(cart, userId);

        req.setAttribute("orderId",orderId);

//        //请求转发到pages/cart/checkout.jsp
//        req.getRequestDispatcher("pages/cart/checkout.jsp").forward(req,resp);

        req.getSession().setAttribute("orderId",orderId);

        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");

    }
}
