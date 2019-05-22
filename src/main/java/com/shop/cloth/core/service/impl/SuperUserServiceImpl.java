package com.shop.cloth.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.dal.domain.Cloth;
import com.shop.cloth.core.dal.domain.Orders;
import com.shop.cloth.core.dal.domain.Superuser;
import com.shop.cloth.core.dal.domain.User;
import com.shop.cloth.core.dal.manager.ClothManager;
import com.shop.cloth.core.dal.manager.OrdersManager;
import com.shop.cloth.core.dal.manager.SuperuserManager;
import com.shop.cloth.core.dal.manager.UserManager;
import com.shop.cloth.core.service.SuperUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


/**
 * @Author: silly-billy
 * @Date: 2019/5/21 12:32
 * @Version 1.0
 */
@Service
public class SuperUserServiceImpl implements SuperUserService {

    @Autowired
    private SuperuserManager superuserManager;

    @Autowired
    private UserManager userManager;

    @Autowired
    private ClothManager clothManager;

    @Autowired
    private OrdersManager ordersManager;

    @Override
    public int confirmSuperUserInfo(Superuser superuser) {
        Wrapper<Superuser> confirmSuperUserInfo = new EntityWrapper<>();
        confirmSuperUserInfo.eq("is_delete",0)
                .eq("super_name",superuser.getSuperName())
                .eq("super_password",superuser.getSuperPassword());
        return superuserManager.selectCount(confirmSuperUserInfo);
    }

    @Override
    public int caculateUserCount() {
        Wrapper<User> queryUserInfo = new EntityWrapper<>();
        return userManager.selectCount(queryUserInfo);
    }

    @Override
    public List<User> caculateUserInvest() {
        Wrapper<User> queryUserInfo = new EntityWrapper<>();
        queryUserInfo.eq("is_delete",0);
        return userManager.selectList(queryUserInfo);
    }

    @Override
    public int caculateClothCount() {
        Wrapper<Cloth> wrapper = new EntityWrapper<>();
        wrapper.eq("is_delete",0);
        return clothManager.selectCount(wrapper);
    }

    @Override
    public List<Cloth> caculateClothSold() {
        Wrapper<Cloth> wrapper = new EntityWrapper<>();
        wrapper.eq("is_delete",0);
        return clothManager.selectList(wrapper);
    }

    @Override
    public List<Orders> queryAllOrders() {
        Wrapper<Orders> wrapper = new EntityWrapper<>();
        wrapper.eq("is_delete",0);
        return ordersManager.selectList(wrapper);
    }

    @Override
    public List<Orders> queryByOrdersNum(String OrderNum) {
        Wrapper<Orders> wrapper = new EntityWrapper<>();
        wrapper.eq("is_delete",0).like("order_num",OrderNum);
        return ordersManager.selectList(wrapper);
    }

    @Override
    public Page<Cloth> queryByClothName(Cloth cloth) {
        Wrapper<Cloth> queryCloth = new EntityWrapper<>();
        if(Objects.isNull(cloth))
            return clothManager.selectPage(new Page<>(1,100));
        queryCloth.eq("is_delete",0)
                .like("cloth_name",cloth.getClothName());
        return clothManager.selectPage(new Page(1,100),queryCloth);
    }

    @Override
    public boolean sendCloth(String orderNum) {
        Wrapper<Orders> wrapper = new EntityWrapper<>();
        wrapper.eq("order_num",orderNum);
        Orders orders = ordersManager.selectOne(wrapper);
        if(orders.getOrderItemstatus() == 0)
        {
            orders.setOrderItemstatus(1);
            ordersManager.updateById(orders);
            return true;
        }
        else return false;
    }

    @Override
    public boolean completeOrder(String orderNum) {
        Wrapper<Orders> wrapper = new EntityWrapper<>();
        wrapper.eq("order_num",orderNum);
        Orders orders = ordersManager.selectOne(wrapper);
        if(orders.getOrderItemstatus() == 1)
        {
            orders.setOrderItemstatus(2);
            ordersManager.updateById(orders);
            return true;
        }
        else return false;
    }

    @Override
    public boolean setHot(int id) {
        Cloth cloth = clothManager.selectById(id);
        if(cloth.getClothIshotsell() == 0){
            cloth.setClothIshotsell(1);
            clothManager.updateById(cloth);
            return true;
        }
        else return false;
    }

    @Override
    public boolean cancelHot(int id) {
        Cloth cloth = clothManager.selectById(id);
        if(cloth.getClothIshotsell() == 1){
            cloth.setClothIshotsell(0);
            clothManager.updateById(cloth);
            return true;
        }
        else return false;
    }
}
