package com.shop.cloth.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.dal.domain.Cloth;
import com.shop.cloth.core.dal.manager.ClothManager;
import com.shop.cloth.core.service.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @Author: silly-billy
 * @Date: 2019/5/7 16:39
 * @Version 1.0
 */
@Service
public class ClothServiceImpl implements ClothService{


    @Autowired
    private ClothManager clothManager;


    @Override
    public Page<Cloth> findAllCloth(int count) {
        Wrapper<Cloth> queryWrapper = new EntityWrapper<>();
        queryWrapper.eq("is_delete",0);
        Page page = new Page(count,6);
        Page<Cloth> clothList = clothManager.selectPage(page,queryWrapper);
        return clothList;
    }

    @Override
    public Page<Cloth> findAllMale(int count) {
        Wrapper<Cloth> queryWrapper = new EntityWrapper<>();
        queryWrapper.eq("cloth_sex",0)
                .eq("is_delete",0);
        Page page = new Page(count,6);
        Page<Cloth> maleClothList = clothManager.selectPage(page,queryWrapper);
        return maleClothList;
    }

    @Override
    public Page<Cloth> findAllFemale(int count) {
        Wrapper<Cloth> queryWrapper = new EntityWrapper<>();
        queryWrapper.eq("cloth_sex",1)
                .eq("is_delete",0);
        Page page = new Page(count,6);
        Page<Cloth> femaleClothList = clothManager.selectPage(page,queryWrapper);
        return femaleClothList;
    }

    @Override
    public Page<Cloth> findAllChild(int count) {
        Wrapper<Cloth> queryWrapper = new EntityWrapper<>();
        queryWrapper.eq("cloth_sex",2)
                .eq("is_delete",0);
        Page page = new Page(count,6);
        Page<Cloth> childClothList = clothManager.selectPage(page,queryWrapper);
        return childClothList;
    }

    @Override
    public Page<Cloth> findAllHot(int count) {
        Wrapper<Cloth> queryWrapper = new EntityWrapper<>();
        queryWrapper.eq("cloth_ishotsell",1)
                .eq("is_delete",0);
        Page page = new Page(count,6);
        Page<Cloth> HotClothList = clothManager.selectPage(page,queryWrapper);
        return HotClothList;
    }

    @Override
    public Cloth queryClothInfo(int id) {
        return clothManager.selectById(id);
    }


}
