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
public class Cloth extends BaseModel {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 男士-0
女士-1
儿童-2
     */
    @TableField("cloth_sex")
    private Integer clothSex;
    /**
     * 衣服品牌
     */
    @TableField("cloth_brand")
    private String clothBrand;
    /**
     * 衣服尺码：XXL XL L 
     */
    @TableField("cloth_size")
    private String clothSize;
    /**
     * 衣服颜色
     */
    @TableField("cloth_color")
    private String clothColor;
    /**
     * 衣服价格
     */
    @TableField("cloth_price")
    private Double clothPrice;
    /**
     * 衣服图片url地址
     */
    @TableField("cloth_picurl")
    private String clothPicurl;
    /**
     * 衣服名称
     */
    @TableField("cloth_name")
    private String clothName;
    /**
     * 库存
     */
    @TableField("cloth_stock")
    private Integer clothStock;
    /**
     * 判断是否热卖 0不是 1是
     */
    @TableField("cloth_ishotsell")
    private Integer clothIshotsell;
    /**
     * 逻辑删除标志
     */
    @TableField("is_delete")
    private String isDelete;
    /**
     * 大图地址
     */
    @TableField("cloth_bigpicurl")
    private String clothBigpicurl;
    /**
     * 小图
     */
    @TableField("cloth_smallpicurl")
    private String clothSmallpicurl;

}
