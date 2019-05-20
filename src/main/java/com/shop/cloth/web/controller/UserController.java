package com.shop.cloth.web.controller;

import com.shop.cloth.core.dal.domain.User;
import com.shop.cloth.core.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
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

    @RequestMapping(method = RequestMethod.GET,value = "/UserExit")
    public String UserExit(HttpSession session)
    {
        session.setAttribute("userInfo",null);
        return "redirect:/";
    }

    /**
     * @Author sillybilly
     * @Description   用户地址填写
     * @Date 2019/5/19 16:36
     * @Param [province, city, area, detail, session]
     * @return int
     */
    @RequestMapping(method = RequestMethod.POST,value = "/conformAddress")
    @ResponseBody
    public int UserConformAddress(String province,String city,String area,String detail,HttpSession session)
    {

        int message = 0;
        StringBuffer address =new StringBuffer();
        User user = new User();
        String str = session.getAttribute("userInfo").toString();
        user.setId(Integer.parseInt(str.substring(str.indexOf("=") + 1, str.indexOf(","))));
        user.setUserAddress(address.append(province).append(area).append(detail).toString());
        userService.addAddress(user);
        return message;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/addMoney")
    @ResponseBody
    public int UserConformAddress(String money,HttpSession session)
    {
        int message = 0;
        String exchange = money.substring(0,money.indexOf("元"));
        String exchangeInt = exchange.substring(0,exchange.indexOf("."));
        //System.out.println(money.split("\\.").length);
        if(money.split("\\.").length > 2 || Integer.parseInt(exchangeInt) > 10000 || Integer.parseInt(exchangeInt) < 10){
            message = 1;
        }else {
            double balance = Double.parseDouble(exchange);
            String str = session.getAttribute("userInfo").toString();
            int id = Integer.parseInt(str.substring(str.indexOf("=") + 1, str.indexOf(",")));
            User user = userService.queryById(id);
            BigDecimal bd1 = new BigDecimal(Double.toString(balance));
            BigDecimal bd2 = new BigDecimal(Double.toString(user.getUserBalance()));
            balance = bd1.add(bd2).doubleValue();
            user.setUserBalance(balance);
            userService.addBalance(user);
            session.setAttribute("userInfo",user);
        }
        return message;
    }

}
