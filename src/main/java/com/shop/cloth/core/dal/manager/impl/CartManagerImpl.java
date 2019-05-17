package com.shop.cloth.core.dal.manager.impl;

import com.shop.cloth.core.dal.domain.Cart;
import com.shop.cloth.core.dal.dao.CartDao;
import com.shop.cloth.core.dal.manager.CartManager;
import com.shop.cloth.core.common.base.BaseManagerImpl;
import org.springframework.stereotype.Component;

@Component
public class CartManagerImpl extends BaseManagerImpl<CartDao, Cart> implements CartManager{

}
