package com.achang.test;

import com.achang.bean.Order;
import com.achang.dao.OrderDao;
import com.achang.dao.impl.OrderDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/******
 @author 阿昌
 @create 2020-12-02 12:20
 *******
 */
public class OrderDaoImplTest {
    private OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("1234567890",new Date(),new BigDecimal(100),0,1));

    }

}