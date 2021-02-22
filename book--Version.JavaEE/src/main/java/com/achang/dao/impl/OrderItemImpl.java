package com.achang.dao.impl;

import com.achang.bean.Order;
import com.achang.bean.OrderItem;
import com.achang.dao.OrderItemDao;

/******
 @author 阿昌
 @create 2020-12-02 12:06
 *******
 */
public class OrderItemImpl extends BaseDao implements OrderItemDao {


    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(name,count,price,total_price,order_id) value(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

}
