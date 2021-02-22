package com.achang.web;

import com.achang.bean.Book;
import com.achang.bean.Cart;
import com.achang.bean.CartItem;
import com.achang.service.BookService;
import com.achang.service.impl.BookServiceImpl;
import com.achang.utils.WebUtils;
import com.google.gson.Gson;
import sun.awt.windows.WEmbeddedFrame;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/******
 @author 阿昌
 @create 2020-12-01 20:38
 *******
 */
public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();


    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //调用bookService.queryBookId(id); --->得到对应id的图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息转换为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用Cart.addItem(CartItem)添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }

        cart.addItem(cartItem);

        System.out.println(cart);

        //重定回原来商品所在的地址页面 --->通过请求头上的Referer值
        resp.sendRedirect(req.getHeader("referer"));

        //最后一个添加的商品名称
        req.getSession().setAttribute("lastName",cartItem.getName());

    }


    /**
     * 删除商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号id
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart !=null){
            //删除购物车商品项
            cart.deleteItem(id);
            //重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("referer"));
        }

    }


    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null ){
            //清空购物车
            cart.clear();
            //重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("referer"));
        }
    }


    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数商品编号id、商品数量
        int id =WebUtils.parseInt(req.getParameter("id"),0);
        int count =WebUtils.parseInt(req.getParameter("count"),1);
        //获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            //修改商品数量
            cart.updateCount(id,count);
            //重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("referer"));
        }
    }




    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //调用bookService.queryBookId(id); --->得到对应id的图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息转换为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用Cart.addItem(CartItem)添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }

        cart.addItem(cartItem);


        //最后一个添加的商品名称，响应给前端AJAX程序
        Map<String,Object> resultMap = new HashMap<>();

        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);


    }





    }
