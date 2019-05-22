package com.shop.cloth.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.dal.domain.User;
import com.shop.cloth.core.dal.manager.UserManager;
import com.shop.cloth.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    @Override
    public User matchUserInfo(User user) {
        Wrapper<User> queryWrapper = new EntityWrapper<>();
        queryWrapper.eq("is_delete","0")
                .eq("user_name",user.getUserName())
                .eq("user_password",user.getUserPassword());
        return userManager.selectOne(queryWrapper);
    }

    @Override
    public void addAddress(User user) {
        userManager.updateById(user);
    }

    @Override
    public void addBalance(User user) {
        userManager.updateById(user);
    }

    @Override
    public User queryById(int id) {
        return userManager.selectById(id);
    }

    @Override
    public void UpdateByUserInfo(User user) {
        userManager.updateById(user);
    }

    @Override
    public Page<User> SearchAllUserInfo(int current) {
        Wrapper<User> queryWrapper = new EntityWrapper<>();
        return userManager.selectPage(new Page<>(current,10),queryWrapper);

    }

    @Override
    public Page<User> queryAllUser(User user) {
        Wrapper<User> queryAllUser = new EntityWrapper<>();
        if(Objects.isNull(user))
            return userManager.selectPage(new Page<>(1,10));
        queryAllUser.like("user_name",user.getUserName());
        return userManager.selectPage(new Page(1,100),queryAllUser);
    }

    @Override
    public boolean delUserInfo(int id) {
        User user = userManager.selectById(id);
        if(user.getIsDelete().equals("1"))
            return false;
        user.setIsDelete("1");
        userManager.updateById(user);
        return true;
    }

    @Override
    public boolean openUserInfo(int id) {
        User user = userManager.selectById(id);
        if(user.getIsDelete().equals("0"))
            return false;
        user.setIsDelete("0");
        userManager.updateById(user);
        return true;
    }
}
