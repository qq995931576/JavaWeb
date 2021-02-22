package com.achang.test;

import com.achang.bean.Cart;
import com.achang.bean.CartItem;
import com.achang.service.OrderService;
import com.achang.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/******
 @author 阿昌
 @create 2020-12-02 13:17
 *******
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"操作系统",1,new BigDecimal(100),new BigDecimal(100)));

        OrderService orderService = new OrderServiceImpl();

        System.out.println("订单号是： "+orderService.createOrder(cart, 1));
    }
}