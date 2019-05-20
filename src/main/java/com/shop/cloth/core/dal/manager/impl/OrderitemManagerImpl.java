package com.shop.cloth.core.dal.manager.impl;


import com.shop.cloth.core.dal.domain.Orderitem;
import com.shop.cloth.core.dal.dao.OrderitemDao;
import com.shop.cloth.core.dal.manager.OrderitemManager;
import com.shop.cloth.core.common.base.BaseManagerImpl;
import org.springframework.stereotype.Component;

@Component
public class OrderitemManagerImpl extends BaseManagerImpl<OrderitemDao, Orderitem> implements OrderitemManager{


}
