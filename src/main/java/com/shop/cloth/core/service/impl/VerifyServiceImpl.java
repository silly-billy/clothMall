package com.shop.cloth.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.dal.domain.Verify;
import com.shop.cloth.core.dal.manager.VerifyManager;
import com.shop.cloth.core.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: silly-billy
 * @Date: 2019/5/23 23:58
 * @Version 1.0
 */
@Service
public class VerifyServiceImpl implements VerifyService {

    @Autowired
    private VerifyManager verifyManager;

    @Override
    public void addVerifyMoney(Verify verify) {
        verifyManager.insert(verify);
    }

    @Override
    public int verifyCount() {
        Wrapper<Verify> wrapper = new EntityWrapper<>();
        wrapper.eq("is_delete",0);
        return verifyManager.selectCount(wrapper);
    }

    @Override
    public Page<Verify> showVerifyList(int current) {
        Wrapper<Verify> wrapper = new EntityWrapper<>();
        wrapper.eq("is_delete",0);
        Page page = new Page(current,10);
        return verifyManager.selectPage(page,wrapper);
    }

    @Override
    public boolean delVerifyById(int id) {
        Verify verify = verifyManager.selectById(id);
        verify.setIsDelete(1);
        verifyManager.updateById(verify);
        return true;
    }

    @Override
    public Verify queryVerifyById(int id) {
        return verifyManager.selectById(id);
    }
}
