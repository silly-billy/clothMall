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
}
