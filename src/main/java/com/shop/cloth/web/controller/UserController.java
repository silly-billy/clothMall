package com.shop.cloth.web.controller;

import com.shop.cloth.core.dal.domain.User;
import com.shop.cloth.core.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @Author: silly-billy
 * @Date: 2019/5/13 14:06
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService userService;

    /**
     * @Author sillybilly
     * @Description   用户注册 message： 0--成功 1--失败
     * @Date 2019/5/14 11:47
     * @Param [user]
     * @return int
     */
    @RequestMapping(method = RequestMethod.POST,value = "/UserResConfirm")
    @ResponseBody
    public int addConfirm(User user)
    {
        int message = 0;
        int count = userService.searchName(user.getUserName());
        if(count>0){
            message = 1;
        }
        else{
            userService.addUserInfo(user);
        }
        return message;
    }

    /**
     * @Author sillybilly
     * @Description   用户登录 0 --失败  1--成功
     * @Date 2019/5/14 11:55
     * @Param [user]
     * @return int
     */
    @RequestMapping(method = RequestMethod.POST,value = "/UserLogin")
    @ResponseBody
    public int UserLogin(User user,HttpSession session)
    {
        session.setAttribute("userInfo",null);
        int message = 0;
        User userInfo = userService.matchUserInfo(user);
        if(!Objects.isNull(userInfo)) {
            message = 1;
            session.setAttribute("userInfo",userInfo);
        }
        return message;
    }


}
