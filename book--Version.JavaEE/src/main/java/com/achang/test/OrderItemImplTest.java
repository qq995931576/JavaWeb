package com.achang.test;

import com.achang.bean.OrderItem;
import com.achang.dao.OrderItemDao;
import com.achang.dao.impl.OrderItemImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/******
 @author 阿昌
 @create 2020-12-02 12:26
 *******
 */
public class OrderItemImplTest {
    private OrderItemDao orderItemDao = new OrderItemImpl();
    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(1,"javascript从入门到精通",2,new BigDecimal(200),new BigDecimal(100),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(1,"Netty入门",1,new BigDecimal(100),new BigDecimal(100),"1234567890"));
    }
}