package com.shop.cloth.core.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.dal.domain.Remark;

import javax.servlet.http.HttpSession;

/**
 * @Author: silly-billy
 * @Date: 2019/5/29 21:37
 * @Version 1.0
 */
public interface RemarkService {


   /*添加评价信息*/
    int addRemarkInfo(Remark remark, HttpSession session);

    /*查询留言信息*/
    Page<Remark> showRemarkInfo(int current,int remarkClothid);

    /*查询当前服装得留言信息数*/
    int caculateClothCount(int clothId);
}
