package com.shop.cloth.web.controller;

import com.shop.cloth.core.dal.domain.User;
import com.shop.cloth.core.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
     * @Description  注册成功--跳转登录界面
     * @Date 2019/5/13 14:42
     * @Param []
     * @return java.lang.String
     */
    @RequestMapping(method = RequestMethod.GET,value = "/UserRegister")
    public String addUserInfo(User user)
    {
        userService.addUserInfo(user);
        return "redirect:/login";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/UserResConfirm")
    @ResponseBody
    public int addConfirm(User user)
    {
        int message = 0;
        int count = userService.searchName(user.getUserName());
        System.out.println(count);
        if(count>0){
            message = 1;
        }
        else{
            userService.addUserInfo(user);
        }
        return message;
    }
}
