package com.shop.cloth.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.common.VO.OrderItemVO;
import com.shop.cloth.core.common.util.OrderItemToVO;
import com.shop.cloth.core.dal.domain.*;
import com.shop.cloth.core.service.CartService;
import com.shop.cloth.core.service.ClothService;
import com.shop.cloth.core.service.SuperUserService;
import com.shop.cloth.core.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author: silly-billy
 * @Date: 2019/5/21 11:53
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private SuperUserService superUserService;
    @Resource
    private UserService userService;
    @Resource
    private ClothService clothService;
    @Resource
    private CartService cartService;

    @RequestMapping(method = RequestMethod.GET,value = "")
    public String getAdminLogin()
    {
        return "admin/index";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/home")
    public String getHome(Model model){
        model.addAttribute("userCount",superUserService.caculateUserCount());
        List<User> users = superUserService.caculateUserInvest();
        int userInvest = 0;
        for (User user:users){
            userInvest += user.getUserInvest();
        }
        model.addAttribute("userInvest",userInvest);
        model.addAttribute("clothcount",superUserService.caculateClothCount());
        List<Cloth> cloths = superUserService.caculateClothSold();
        int soldcount = 0;
        for (Cloth cloth:cloths){
            soldcount += cloth.getClothSellamount();
        }
        model.addAttribute("soldcount",soldcount);
        return "admin/home";
    }

    /**
     * @Author sillybilly
     * @Description  验证登录 count != 0 成功
     * @Date 2019/5/21 13:33
     * @Param [superuser, session]
     * @return int
     */
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    @ResponseBody
    public int ConfirmSuperInfo(Superuser superuser, HttpSession session){
        int count = superUserService.confirmSuperUserInfo(superuser);
        if(count > 0)
        {
            session.setAttribute("superuser",superuser);
        }
        return count;
    }

    /**
     * @Author sillybilly
     * @Description 登出
     * @Date 2019/5/22 15:59
     * @Param []
     * @return java.lang.String
     */
    @RequestMapping(method = RequestMethod.GET,value = "/logout")
    public String getLogOut(HttpSession session)
    {
        session.setAttribute("superuser",null);
        return "redirect:admin/index";
    }
    /**
     * @Author sillybilly
     * @Description 用户信息列表
     * @Date 2019/5/21 16:02
     * @Param [model]
     * @return java.lang.String
     */
    @RequestMapping(method = RequestMethod.GET,value = "/UserManage")
    public String getUserManage(){
        return "admin/UserManage";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/showUserManage")
    @ResponseBody
    public Page<User> getshowUserManage(){
        return userService.SearchAllUserInfo(1);
    }
    /**
     * @Author sillybilly
     * @Description   用户分页
     * @Date 2019/5/21 16:59
     * @Param [current, sign, model]
     * @return java.lang.String
     */
    @RequestMapping(method = RequestMethod.GET,value = "/UserManagePage")
    @ResponseBody
    public Page<User> getUserManagePage(int current,int sign){
        if(sign == 1){
           return userService.SearchAllUserInfo(current);
        }else{
            if(sign == 0){
                if(current == 1)
                    return userService.SearchAllUserInfo(current);
                else
                    return userService.SearchAllUserInfo(current-1);
            }else {
                if (current == userService.SearchAllUserInfo(current).getPages())
                    return userService.SearchAllUserInfo(current);
                else
                   return userService.SearchAllUserInfo(current + 1);
            }
        }
    }


    /**
     * @Author sillybilly
     * @Description   用户信息模糊查询
     * @Date 2019/5/21 16:57
     * @Param [userName, model]
     * @return java.lang.String
     */
    @RequestMapping(method = RequestMethod.GET,value = "/UserSearch")
    @ResponseBody
    public Page<User> getUserSearch(String userName){
        User user = new User();
        user.setUserName(userName);
        return userService.queryAllUser(user);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/OrderManage")
    public String getOrderManage(Model model)
    {
        return "admin/OrderManage";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/showOrderManage")
    @ResponseBody
    public List<OrderItemVO> getshowOrderManage()
    {
        List<Orders> orders = superUserService.queryAllOrders();
        List<OrderItemVO> orderItemVOS = new ArrayList<>();
        for (Orders order:orders) {
            OrderItemVO orderItemVO = OrderItemToVO.OrderItemUtil(order);
            Cart cart = cartService.queryCartInfoById(order.getOrderCartid());
            orderItemVO.setCartSubprice(cart.getCartSubprice());
            orderItemVO.setCartClothnum(cart.getCartClothnum());
            Cloth cloth = clothService.queryClothInfo(order.getOrderClothid());
            orderItemVO.setClothName(cloth.getClothName());
            orderItemVO.setClothSmallpicurl(cloth.getClothSmallpicurl());
            User user = userService.queryById(order.getOrderUserid());
            orderItemVO.setUserName(user.getUserName());
            orderItemVO.setUserAddress(user.getUserAddress());
            orderItemVO.setUserPhone(user.getUserPhone());
            orderItemVOS.add(orderItemVO);
        }
        return orderItemVOS;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/queryByOrderNum")
    @ResponseBody
    public List<OrderItemVO> getOrderInfoByOrderNum(String orderNum)
    {
        List<Orders> orders = superUserService.queryByOrdersNum(orderNum.trim());
        List<OrderItemVO> orderItemVOS = new ArrayList<>();
        for (Orders order:orders) {
            OrderItemVO orderItemVO = OrderItemToVO.OrderItemUtil(order);
            Cart cart = cartService.queryCartInfoById(order.getOrderCartid());
            orderItemVO.setCartSubprice(cart.getCartSubprice());
            orderItemVO.setCartClothnum(cart.getCartClothnum());
            Cloth cloth = clothService.queryClothInfo(order.getOrderClothid());
            orderItemVO.setClothName(cloth.getClothName());
            orderItemVO.setClothSmallpicurl(cloth.getClothSmallpicurl());
            User user = userService.queryById(order.getOrderUserid());
            orderItemVO.setUserName(user.getUserName());
            orderItemVO.setUserAddress(user.getUserAddress());
            orderItemVO.setUserPhone(user.getUserPhone());
            orderItemVOS.add(orderItemVO);
        }
        return orderItemVOS;
    }

    /**
     * @Author sillybilly
     * @Description   服装管理
     * @Date 2019/5/22 16:16
     * @Param []
     * @return java.lang.String
     */
    @RequestMapping(method = RequestMethod.GET,value = "/ClothManage")
    public String getClothManage(Model model){
        model.addAttribute("clothList",clothService.findAllCloth(1));
        return "admin/ClothManage";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/showClothManage")
    @ResponseBody
    public Page<Cloth> getshowClothManage(){
        return clothService.findAllCloth(1);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/ClothManagePage")
    @ResponseBody
    public Page<Cloth> getClothManagePage(int current,int sign){
        if(sign == 1){
            return clothService.findAllCloth(current);
        }else{
            if(sign == 0){
                if(current == 1)
                    return clothService.findAllCloth(current);
                else
                    return clothService.findAllCloth(current-1);
            }else {
                if (current == clothService.findAllCloth(current).getPages())
                    return clothService.findAllCloth(current);
                else
                    return clothService.findAllCloth(current+1);
            }
        }
    }

    @RequestMapping(method = RequestMethod.POST,value = "/queryByClothName")
    public String getClothInfoByName(String clothName,Model model){
        Cloth cloth = new Cloth();
        cloth.setClothName(clothName);
        model.addAttribute("clothList",superUserService.queryByClothName(cloth));
        return "admin/ClothManage";
    }

    /**
     * @Author sillybilly
     * @Description  冻结用户账号 msg:1->成功，0失败
     * @Date 2019/5/22 20:25
     * @Param [id]
     * @return int
     */
    @RequestMapping(method = RequestMethod.GET,value = "/close")
    @ResponseBody
    public int closeUserInfo(int id)
    {
        int message = 0;
        if(userService.delUserInfo(id)){
            message = 1;
        }
        return message;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/open")
    @ResponseBody
    public int openUserInfo(int id)
    {
        int message = 0;
        if(userService.openUserInfo(id))
        {
            message = 1;
        }

        return message;
    }

    /**
     * @Author sillybilly
     * @Description     发货状态处理
     * @Date 2019/5/22 21:46
     * @Param [orderNum]
     * @return int
     */
    @RequestMapping(method = RequestMethod.GET,value = "/sendCloth")
    @ResponseBody
    public int sendCloth(String orderNum)
    {
        if(superUserService.sendCloth(orderNum))
            return 0;
        else return 1;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/completeOrder")
    @ResponseBody
    public int completeOrder(String orderNum)
    {
        if(superUserService.completeOrder(orderNum))
            return 0;
        else return 1;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/setHot")
    @ResponseBody
    public int setHot(int id)
    {
        if(superUserService.setHot(id))
            return 0;
        else return 1;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/cancelHot")
    @ResponseBody
    public int cancelHot(int id)
    {
        if(superUserService.cancelHot(id))
            return 0;
        else return 1;
    }
}
