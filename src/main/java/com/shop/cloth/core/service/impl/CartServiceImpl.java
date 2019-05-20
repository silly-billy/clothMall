package com.shop.cloth.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.dal.domain.Cart;
import com.shop.cloth.core.dal.manager.CartManager;
import com.shop.cloth.core.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: silly-billy
 * @Date: 2019/5/15 23:17
 * @Version 1.0
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartManager cartManager;

    @Override
    public void addCartInfo(Cart cart) {
        cartManager.insert(cart);
    }

    @Override
    public Page<Cart> queryCartInfo(int count,int userId) {
        Wrapper<Cart> queryWrapper = new EntityWrapper<>();
        queryWrapper.eq("is_delete",0).eq("cart_userid",userId);
        Page page = new Page(count,3);
        return cartManager.selectPage(page,queryWrapper);
    }

    @Override
    public void deleteCartInfo(int id) {
        Cart cart = cartManager.selectById(id);
        cart.setIsDelete(1);
        cartManager.updateById(cart);
    }

    @Override
    public Double CaculatePrice(int userId) {
        Wrapper<Cart> queryWrapper = new EntityWrapper<>();
        queryWrapper.eq("is_delete",0).eq("cart_userid",userId);
        double sumPrice = 0;
        List<Cart> cartList =  cartManager.selectList(queryWrapper);
        for (Cart index:cartList){
            sumPrice += index.getCartSubprice();
        }
        return sumPrice;
    }

    @Override
    public Cart queryCartInfoById(int id) {
        return cartManager.selectById(id);
    }

}
