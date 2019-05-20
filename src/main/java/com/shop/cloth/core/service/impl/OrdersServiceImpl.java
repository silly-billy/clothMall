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


}
