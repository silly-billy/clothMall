package com.shop.cloth.core.dal.manager.impl;

import com.shop.cloth.core.dal.domain.Cloth;
import com.shop.cloth.core.dal.dao.ClothDao;
import com.shop.cloth.core.dal.manager.ClothManager;
import com.shop.cloth.core.common.base.BaseManagerImpl;
import org.springframework.stereotype.Component;

@Component
public class ClothManagerImpl extends BaseManagerImpl<ClothDao, Cloth> implements ClothManager{

}
