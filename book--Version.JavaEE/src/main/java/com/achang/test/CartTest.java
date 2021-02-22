package com.achang.test;

import com.achang.bean.Cart;
import com.achang.bean.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/******
 @author 阿昌
 @create 2020-12-01 19:58
 *******
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"操作系统",1,new BigDecimal(100),new BigDecimal(100)));

        System.out.println(cart);



    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"操作系统",1,new BigDecimal(100),new BigDecimal(100)));

        cart.deleteItem(1);

        System.out.println(cart);


    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"操作系统",1,new BigDecimal(100),new BigDecimal(100)));

        cart.clear();

        System.out.println(cart);

    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"操作系统",1,new BigDecimal(100),new BigDecimal(100)));

        cart.updateCount(1,3);

        System.out.println(cart);



    }
}