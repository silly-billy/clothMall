package com.shop.cloth.core.dal.manager.impl;

import com.shop.cloth.core.dal.domain.Order;
import com.shop.cloth.core.dal.dao.OrderDao;
import com.shop.cloth.core.dal.manager.OrderManager;
import com.shop.cloth.core.common.base.BaseManagerImpl;
import org.springframework.stereotype.Component;

@Component
public class OrderManagerImpl extends BaseManagerImpl<OrderDao, Order> implements OrderManager{

}
