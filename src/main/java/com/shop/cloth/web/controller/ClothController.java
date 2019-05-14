package com.shop.cloth.web.controller;

import com.shop.cloth.core.dal.domain.User;
import com.shop.cloth.core.service.ClothService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;


/**
 * @Author: silly-billy
 * @Date: 2019/5/7 16:56
 * @Version 1.0
 */
@Controller
//@ResponseBody
//@RequestMapping
//@RestController
public class ClothController {

    @Resource
    private ClothService clothService;


    /**
     * @Author sillybilly
     * @Description 首页显示
     * @Date 2019/5/10 16:48
     * @Param [model]
     * @return java.lang.String
     */
    @RequestMapping(method = RequestMethod.GET,value = "/")
    public String getAllClothInfo()
    {
        return "index";
    }

    /**
     * @Author sillybilly
     * @Description 服装列表--分类男士，女士，儿童，热卖
     * @Date 2019/5/10 17:04
     * @Param [model, request]
     * @return java.lang.String
     */
    @RequestMapping(method = RequestMethod.GET,value = "/details")
    public String getClothList(Model model, HttpServletRequest request)
    {
        String detailId = request.getParameter("detailId");
        if(StringUtils.isEmpty(detailId)){
            return "index";
        }
        if(detailId.equals("1")){
            //model.addAttribute("ClothList",clothService.findAllHot(1).getRecords());
            model.addAttribute("agori","热卖服装");
        }else if(detailId.equals("2")){
            //model.addAttribute("ClothList",clothService.findAllMale(1).getRecords());
            model.addAttribute("agori","男士服装");
            } else if(detailId.equals("3")){
           //model.addAttribute("ClothList",clothService.findAllFemale(1).getRecords());
            model.addAttribute("agori","女士服装");
        }else if(detailId.equals("4")){
           //model.addAttribute("ClothList",clothService.findAllChild(1).getRecords());
            model.addAttribute("agori","儿童服装");
        }
        return "product";

    }


    /**
     * @Author sillybilly
     * @Description  商品详情页跳转
     * @Date 2019/5/12 16:00
     * @Param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/single")
    public String getClothInfo()
    {
        return "single";

    }

    /**
     * @Author sillybilly
     * @Description  购物车页面跳转
     * @Date 2019/5/12 16:00
     * @Param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/checkout")
    public String getCheckOut()
    {
        return "checkout";

    }

    /**
     * @Author sillybilly
     * @Description 心愿单跳转
     * @Date 2019/5/12 16:00
     * @Param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/wishlist")
    public String getWishlist()
    {
        return "wishlist";

    }

    /**
     * @Author sillybilly
     * @Description  登录界面跳转
     * @Date 2019/5/13 10:12
     * @Param []
     * @return java.lang.String
     */
    @RequestMapping(method = RequestMethod.GET,value = "/login")
    public String getLogin()
    {
        return "login";

    }

    /**
     * @Author sillybilly
     * @Description 注册界面跳转
     * @Date 2019/5/13 15:28
     * @Param []
     * @return java.lang.String
     */
    @RequestMapping(method = RequestMethod.GET,value = "/register")
    public String getRegister()
    {
        return "register";

    }









}
