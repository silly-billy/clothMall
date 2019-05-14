package com.shop.cloth.core.dal.manager.impl;

import com.shop.cloth.core.dal.domain.User;
import com.shop.cloth.core.dal.dao.UserDao;
import com.shop.cloth.core.dal.manager.UserManager;
import com.shop.cloth.core.common.base.BaseManagerImpl;
import org.springframework.stereotype.Component;

@Component
public class UserManagerImpl extends BaseManagerImpl<UserDao, User> implements UserManager{

}
