package com.shop.cloth.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shop.cloth.core.dal.domain.Orders;
import com.shop.cloth.core.dal.manager.OrdersManager;
import com.shop.cloth.core.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import java.util.List;

/**
 * @Author: silly-billy
 * @Date: 2019/5/20 0:35
 * @Version 1.0
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersManager ordersManager;


    @Override
    public void addOrderInfo(Orders order) {
        ordersManager.insert(order);
    }

    @Override
    public List<Orders> showOrders(int userId) {
        Wrapper<Orders> queryWrapper = new EntityWrapper<>();
        queryWrapper.eq("is_delete",0).eq("order_userid",userId);
        return ordersManager.selectList(queryWrapper);
    }

    @Override
    public boolean confirmOrder(String orderNum) {
        Wrapper<Orders> wrapper = new EntityWrapper<>();
        wrapper.eq("order_num",orderNum);
        Orders orders = ordersManager.selectOne(wrapper);
        if(orders.getOrderItemstatus() == 2)
        {
            orders.setOrderItemstatus(3);
            ordersManager.updateById(orders);
            return true;
        }
        else return false;
    }

    @Override
    public int cancelOrder(String orderNum) {
        Wrapper<Orders> wrapper = new EntityWrapper<>();
        wrapper.eq("order_num",orderNum);
        Orders orders = ordersManager.selectOne(wrapper);
        if(orders.getOrderItemstatus() == 3)
            return 0;
        if(orders.getOrderItemstatus() == 4)
            return 1;
        orders.setOrderItemstatus(4);
        ordersManager.updateById(orders);
        return 2;
    }

    @Override
    public int queryByClothId(int clothId,int userId) {
        Wrapper<Orders> wrapper = new EntityWrapper<>();
        wrapper.eq("order_clothid",clothId).eq("order_userid",userId);
        return ordersManager.selectList(wrapper).size();
    }


}
