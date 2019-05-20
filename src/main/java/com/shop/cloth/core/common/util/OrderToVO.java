package com.shop.cloth.core.common.util;

import com.shop.cloth.core.common.VO.OrderVO;
import com.shop.cloth.core.dal.domain.Orders;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: silly-billy
 * @Date: 2019/5/20 16:53
 * @Version 1.0
 */
public class OrderToVO {

    public static OrderVO orderToOrderVo(Orders orders){
        if(StringUtils.isEmpty(String.valueOf(orders)))
        {
            return null;
        }
        OrderVO orderVO = new OrderVO();
        orderVO.setOrderCartid(orders.getOrderCartid());
        orderVO.setOrderClothid(orders.getOrderClothid());
        orderVO.setOrderCurtime(orders.getOrderCurtime());
        orderVO.setOrderItemstatus(orders.getOrderItemstatus());
        orderVO.setOrderNum(orders.getOrderNum());
        orderVO.setOrderUserid(orders.getOrderUserid());
        return orderVO;
    }
}
