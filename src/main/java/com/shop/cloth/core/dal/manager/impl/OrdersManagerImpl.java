package com.shop.cloth.core.dal.manager.impl;

import com.shop.cloth.core.dal.domain.Orders;
import com.shop.cloth.core.dal.dao.OrdersDao;
import com.shop.cloth.core.dal.manager.OrdersManager;
import com.shop.cloth.core.common.base.BaseManagerImpl;
import org.springframework.stereotype.Component;

@Component
public class OrdersManagerImpl extends BaseManagerImpl<OrdersDao, Orders> implements OrdersManager{

}
