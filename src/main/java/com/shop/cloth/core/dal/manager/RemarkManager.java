package com.shop.cloth.core.dal.manager;

import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.dal.domain.Remark;
import com.shop.cloth.core.common.base.BaseManager;

public interface RemarkManager extends BaseManager<Remark> {

    /*添加留言信息*/
    void addRemarkInfo(Remark remark);

    /*查询留言信息*/
    Page<Remark> showRemarkInfo(int current,int remarkClothid);
}
