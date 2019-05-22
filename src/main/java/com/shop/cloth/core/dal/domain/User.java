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
public class User extends BaseModel {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户姓名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 用户密码
     */
    @TableField("user_password")
    private String userPassword;
    /**
     * 用户性别
     */
    @TableField("user_sex")
    private String userSex;
    /**
     * 用户余额
     */
    @TableField("user_balance")
    private Double userBalance;
    /**
     * 用户收货地址
     */
    @TableField("user_address")
    private String userAddress;
    /**
     * 逻辑删除
     */
    @TableField("is_delete")
    private String isDelete;
    /**
     * 用户号码
     */
    @TableField("user_phone")
    private String userPhone;
    /**
     * 用户历史充值金额
     */
    @TableField("user_invest")
    private Double userInvest;

}
