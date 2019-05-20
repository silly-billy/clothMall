package com.shop.cloth.core.common.VO;

import lombok.Data;

/**
 * @Author: silly-billy
 * @Date: 2019/5/20 16:43
 * @Version 1.0
 */
@Data
public class OrderVO {
    /**
     * 单订状态 0-已付款  1-已发货 2-待确认 3-已完成 4-已取消
     */
    private Integer orderItemstatus;
    /**
     * 用户id
     */
    private Integer orderUserid;
    /**
     * 装服id
     */
    private Integer orderClothid;
    /**
     * 订单编号
     */
    private Long orderNum;
    /**
     * 购物车id
     */
    private Integer orderCartid;
    /**
     * 下单时间
     */
    private String orderCurtime;
    /**
     * 服装名称
     */
    private String clothName;
    /**
     * 装服总价
     */
    private Double cartSubprice;
}
