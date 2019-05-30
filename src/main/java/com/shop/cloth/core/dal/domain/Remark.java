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
public class Remark extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 键主id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    @TableField("remark_userId")
    private Integer remarkUserid;
    /**
     * 装服id
     */
    @TableField("remark_clothId")
    private Integer remarkClothid;
    /**
     * 用户姓名
     */
    @TableField("remark_username")
    private String remarkUsername;
    /**
     * 论评时间
     */
    @TableField("remark_time")
    private String remarkTime;
    /**
     * 评论内容
     */
    @TableField("remark_body")
    private String remarkBody;
    /**
     * 辑逻删除位
     */
    @TableField("is_delete")
    private Integer isDelete;

}
