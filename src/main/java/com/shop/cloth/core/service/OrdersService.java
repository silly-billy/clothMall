package com.shop.cloth.core.service;

import com.shop.cloth.core.dal.domain.Orders;

import java.util.List;

/**
 * @Author: silly-billy
 * @Date: 2019/5/20 0:35
 * @Version 1.0
 */
public interface OrdersService {


    /*添加订单信息*/
    void addOrderInfo(Orders order);
    /*查询订单信息*/
    List<Orders> showOrders(int userId);
    /*确认订单*/
    boolean confirmOrder(String orderNum);
    /*取消订单*/
    boolean cancelOrder(String orderNum);
}
