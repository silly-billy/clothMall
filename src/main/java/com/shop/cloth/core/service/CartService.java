package com.shop.cloth.core.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.dal.domain.Cart;

/**
 * @Author: silly-billy
 * @Date: 2019/5/15 23:14
 * @Version 1.0
 */
public interface CartService {

    /*添加购物车信息*/
    void addCartInfo(Cart cart);

    /*遍历购物车信息*/
    Page<Cart> queryCartInfo(int count);

    /*移除购物车信息*/
    void deleteCartInfo(int id);

    /*购物车总价查询*/
    Double CaculatePrice();
}
