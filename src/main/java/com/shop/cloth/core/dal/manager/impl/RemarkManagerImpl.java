package com.shop.cloth.core.dal.manager.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.dal.domain.Remark;
import com.shop.cloth.core.dal.dao.RemarkDao;
import com.shop.cloth.core.dal.manager.RemarkManager;
import com.shop.cloth.core.common.base.BaseManagerImpl;
import org.springframework.stereotype.Component;

@Component
public class RemarkManagerImpl extends BaseManagerImpl<RemarkDao, Remark> implements RemarkManager{

    @Override
    public void addRemarkInfo(Remark remark) {
        insert(remark);
    }

    @Override
    public Page<Remark> showRemarkInfo(int current,int remarkClothid) {
        Wrapper<Remark> wrapper = new EntityWrapper<>();
        wrapper.eq("is_delete",0).eq("remark_clothId",remarkClothid).orderBy("remark_time",false);
        Page page = new Page(current,3);
        return selectPage(page,wrapper);
    }
}
