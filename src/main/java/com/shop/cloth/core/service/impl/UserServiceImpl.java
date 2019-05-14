package com.shop.cloth.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.shop.cloth.core.dal.domain.User;
import com.shop.cloth.core.dal.manager.UserManager;
import com.shop.cloth.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: silly-billy
 * @Date: 2019/5/13 14:47
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;

    @Override
    public void addUserInfo(User user) {
        userManager.insert(user);
    }

    @Override
    public int searchName(String name) {
        Wrapper<User> queryWrapper = new EntityWrapper<>();
        queryWrapper.eq("user_name",name);
        int count = userManager.selectList(queryWrapper).size();
        return count;
    }
}
