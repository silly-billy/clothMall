package com.shop.cloth.core.service;

import com.shop.cloth.core.dal.domain.Orders;

import javax.servlet.http.HttpSession;
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
    int cancelOrder(String orderNum);
    /*查询订单表中用户是否已经购买此商品*/
    int queryByClothId(int clothId,int userId);
    /*特定用户的最新订单*/
    Orders queryOrderByTime(HttpSession session);
}
