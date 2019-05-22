package com.shop.cloth.core.dal.manager.impl;

import com.shop.cloth.core.dal.domain.Superuser;
import com.shop.cloth.core.dal.dao.SuperuserDao;
import com.shop.cloth.core.dal.manager.SuperuserManager;
import com.shop.cloth.core.common.base.BaseManagerImpl;
import org.springframework.stereotype.Component;

@Component
public class SuperuserManagerImpl extends BaseManagerImpl<SuperuserDao, Superuser> implements SuperuserManager{

}
