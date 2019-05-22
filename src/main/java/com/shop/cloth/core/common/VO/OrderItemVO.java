package com.shop.cloth.core.common.VO;

import lombok.Data;

/**
 * @Author: silly-billy
 * @Date: 2019/5/22 13:09
 * @Version 1.0
 */
@Data
public class OrderItemVO {


    /**
     * 购物车id
     */
    private Integer orderCartid;
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
    private String orderNum;

    /**
     * 衣服名称
     */
    private String clothName;

    /**
     * 装服总价
     */
    private Double cartSubprice;
    /**
     * 下单时间
     */
    private String orderCurtime;
    /**
     * 单订状态 0-已付款  1-已发货 2-待确认 3-已完成 4-已取消
     */
    private Integer orderItemstatus;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户号码
     */
    private String userPhone;
    /**
     * 用户收货地址
     */
    private String userAddress;
    /**
     * 物车购服装数
     */
    private Integer cartClothnum;
    /**
     * 小图
     */
    private String clothSmallpicurl;
}
