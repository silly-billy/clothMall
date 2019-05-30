package com.shop.cloth.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.common.util.DateSyncUtil;
import com.shop.cloth.core.dal.domain.Remark;
import com.shop.cloth.core.dal.domain.User;
import com.shop.cloth.core.dal.manager.RemarkManager;
import com.shop.cloth.core.service.OrdersService;
import com.shop.cloth.core.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author: silly-billy
 * @Date: 2019/5/29 21:49
 * @Version 1.0
 */
@Service
public class RemarkServiceImpl implements RemarkService {
    @Autowired
    private RemarkManager remarkManager;
    @Autowired
    private OrdersService ordersService;

    @Override
    public int addRemarkInfo(Remark remark, HttpSession session) {
        int message = 0;
        if(session.getAttribute("userInfo")==null||session.getAttribute("userInfo")==""){
            message = 1;
        }
        else{
            User user = (User)session.getAttribute("userInfo");
            int size = ordersService.queryByClothId(remark.getRemarkClothid(),user.getId());
            if(size < 1)
            {return 2;}
            remark.setRemarkUserid(user.getId());
            remark.setRemarkUsername(user.getUserName());
            remark.setRemarkTime(DateSyncUtil.format(new Date()));
            remarkManager.addRemarkInfo(remark);
        }
        return message;
    }

    @Override
    public Page<Remark> showRemarkInfo(int current,int remarkClothid) {
        return remarkManager.showRemarkInfo(current,remarkClothid);
    }

    @Override
    public int caculateClothCount(int clothId) {
        Wrapper<Remark> wrapper = new EntityWrapper<>();
        wrapper.eq("remark_clothId",clothId);
        return remarkManager.selectCount(wrapper);
    }
}
