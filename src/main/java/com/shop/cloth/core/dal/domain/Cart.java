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
public class Cart extends BaseModel {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 品商小图
     */
    @TableField("cart_smallpicurl")
    private String cartSmallpicurl;
    /**
     * 装服名称
     */
    @TableField("cart_clothname")
    private String cartClothname;
    /**
     * 装服品牌
     */
    @TableField("cart_clothbrand")
    private String cartClothbrand;
    /**
     * 品商价格
     */
    @TableField("cart_clothprice")
    private Double cartClothprice;
    /**
     * 装服总价
     */
    @TableField("cart_subprice")
    private Double cartSubprice;
    /**
     * 辑逻删除位
     */
    @TableField("is_delete")
    private Integer isDelete;
    /**
     * 用户id
     */
    @TableField("cart_userid")
    private Integer cartUserid;
    /**
     * 物车购服装数
     */
    @TableField("cart_clothnum")
    private Integer cartClothnum;
    /**
     * 装服id
     */
    @TableField("cart_clothid")
    private Integer cartClothid;

}
