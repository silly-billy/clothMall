package com.shop.cloth.core.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.dal.domain.Cloth;
import com.shop.cloth.core.dal.domain.Orders;
import com.shop.cloth.core.dal.domain.Superuser;
import com.shop.cloth.core.dal.domain.User;

import java.util.List;

/**
 * @Author: silly-billy
 * @Date: 2019/5/21 12:30
 * @Version 1.0
 */
public interface SuperUserService {

    /*验证用户登录*/
    int confirmSuperUserInfo(Superuser superuser);

    /*查询用户数*/
    int caculateUserCount();

    /*查询用户已充金额*/
    List<User> caculateUserInvest();

    /*查询服装数*/
    int caculateClothCount();

    /*计算已卖服装数*/
    List<Cloth> caculateClothSold();

    /*查询所有订单列表*/
    List<Orders> queryAllOrders();

    /*根据订单编号查询订单*/
    List<Orders> queryByOrdersNum(String OrderNum);

    /*根据服装名模糊查询*/
    Page<Cloth> queryByClothName(Cloth cloth);

    /*管理员进行发货*/
    boolean sendCloth(String orderNum);

    /*管理员确认订单完成派送*/
    boolean completeOrder(String orderNum);

    /*置服装为热卖*/
    boolean setHot(int id);

    /*取消热卖*/
    boolean cancelHot(int id);
}
