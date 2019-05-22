package com.shop.cloth.core.common.util;

import com.shop.cloth.core.common.VO.OrderItemVO;
import com.shop.cloth.core.dal.domain.Orders;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: silly-billy
 * @Date: 2019/5/22 13:25
 * @Version 1.0
 */
public class OrderItemToVO {

    public static OrderItemVO OrderItemUtil(Orders orders){
        if(StringUtils.isEmpty(String.valueOf(orders)))
        {
            return null;
        }
        OrderItemVO orderItemVO = new OrderItemVO();
        orderItemVO.setOrderCartid(orders.getOrderCartid());
        orderItemVO.setOrderClothid(orders.getOrderClothid());
        orderItemVO.setOrderCurtime(orders.getOrderCurtime());
        orderItemVO.setOrderItemstatus(orders.getOrderItemstatus());
        orderItemVO.setOrderNum(orders.getOrderNum());
        orderItemVO.setOrderUserid(orders.getOrderUserid());
        return orderItemVO;
    }
}
