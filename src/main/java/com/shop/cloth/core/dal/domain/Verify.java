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
public class Verify extends BaseModel {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    @TableField("verify_username")
    private String verifyUsername;
    /**
     * 用户id
     */
    @TableField("verify_userid")
    private Integer verifyUserid;
    /**
     * 待审核金额
     */
    @TableField("verify_amount")
    private Double verifyAmount;
    /**
     * 交提审核时间
     */
    @TableField("verify_time")
    private String verifyTime;
    /**
     * 辑逻删除
     */
    @TableField("is_delete")
    private Integer isDelete;
    /**
     * 用户电话
     */
    @TableField("verify_userphone")
    private String verifyUserphone;

}
