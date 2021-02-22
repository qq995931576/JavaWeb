package com.achang.dao.impl;

import com.achang.bean.Order;
import com.achang.dao.OrderDao;

/******
 @author 阿昌
 @create 2020-12-02 12:00
 *******
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {
        String sql ="insert into t_order(order_id,create_time,price,status,user_id) value(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }



}
