package com.shop.cloth.core.dal.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.shop.cloth.core.common.base.BaseModel;
import com.baomidou.mybatisplus.annotations.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
public class Orders extends BaseModel {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 单订状态 0-已付款  1-已发货 2-待确认 3-已完成 4-已取消
     */
    @TableField("order_itemstatus")
    private Integer orderItemstatus;
    /**
     * 用户id
     */
    @TableField("order_userid")
    private Integer orderUserid;
    /**
     * 装服id
     */
    @TableField("order_clothid")
    private Integer orderClothid;
    /**
     * 订单编号
     */
    @TableField("order_num")
    private String orderNum;
    /**
     * 购物车id
     */
    @TableField("order_cartid")
    private Integer orderCartid;
    /**
     * 逻辑删除位
     */
    @TableField("is_delete")
    private Integer isDelete;
    /**
     * 下单时间
     */
    @TableField("order_curtime")
    private String orderCurtime;

}
