package com.shop.cloth.core.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.dal.domain.Cloth;

import java.util.List;


/**
 * @Author: silly-billy
 * @Date: 2019/5/7 16:31
 * @Version 1.0
 */

public interface ClothService {

    /*查询所有服装*/
    Page<Cloth> findAllCloth(int count);

    /*查询男士服装*/
    Page<Cloth> findAllMale(int count);

    /*查询女士服装*/
    Page<Cloth> findAllFemale(int count);

    /*查询儿童服装*/
    Page<Cloth> findAllChild(int count);

    /*查询热卖服装*/
    Page<Cloth> findAllHot(int count);

    /*根据ID查询衣服信息*/
    Cloth queryClothInfo(int id);

    /*跟新服装--库存量*/
    void updateClothInfo(Cloth cloth);

    /*按照服装出售量排序*/
    Page<Cloth> SortBySoldAmount();
}
