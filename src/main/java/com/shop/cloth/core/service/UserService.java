package com.shop.cloth.core.service;

import com.shop.cloth.core.dal.domain.User;

/**
 * @Author: silly-billy
 * @Date: 2019/5/13 14:44
 * @Version 1.0
 */
public interface UserService {

    /*注册用户*/
    void addUserInfo(User user);

    /*查询名字重复*/
    int searchName(String name);

    /*登录信息匹配*/
    User matchUserInfo(User user);

    /*地址信息添加*/
    void addAddress(User user);

    /*金钱充值*/
    void addBalance(User user);

    /*根据id查询用户信息*/
    User queryById(int id);

    /*修改用户信息*/
    void UpdateByUserInfo(User user);
}
