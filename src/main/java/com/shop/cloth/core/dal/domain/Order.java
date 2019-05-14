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
public class Order extends BaseModel {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 服装id
     */
    @TableField("cloth_id")
    private Integer clothId;
    /**
     * 订单数量
     */
    @TableField("order_num")
    private String orderNum;
    /**
     * 订单总价值
     */
    @TableField("order_price")
    private String orderPrice;
    /**
     * 寄向地
     */
    @TableField("order_address")
    private String orderAddress;
    /**
     * 逻辑删除
     */
    @TableField("is_delete")
    private String isDelete;

}
