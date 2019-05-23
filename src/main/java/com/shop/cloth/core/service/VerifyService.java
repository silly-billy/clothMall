package com.shop.cloth.core.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.dal.domain.Verify;

/**
 * @Author: silly-billy
 * @Date: 2019/5/23 23:55
 * @Version 1.0
 */
public interface VerifyService {

    /*用户待审核金额信息添加*/
    void addVerifyMoney(Verify verify);

    /*查询金额审核数*/
    int verifyCount();

    /*显示所有待审核充值单*/
    Page<Verify> showVerifyList(int current);

    /*逻辑删除待审金额*/
    boolean delVerifyById(int id);

    /*根据id查询充值订单*/
    Verify queryVerifyById(int id);
}
