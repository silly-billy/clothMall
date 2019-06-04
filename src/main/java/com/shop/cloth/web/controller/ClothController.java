package com.shop.cloth.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.dal.domain.Cloth;
import com.shop.cloth.core.dal.domain.User;
import com.shop.cloth.core.service.CartService;
import com.shop.cloth.core.service.ClothService;
import com.shop.cloth.core.service.RemarkService;
import com.shop.cloth.core.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @Author: silly-billy
 * @Date: 2019/5/7 16:56
 * @Version 1.0
 */
@Controller
public class ClothController {

    @Resource
    private ClothService clothService;
    @Resource
    private CartService cartService;
    @Resource
    private UserService userService;
    @Resource
    private RemarkService remarkService;

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
        model.addAttribute("soldWell",clothService.SortBySoldAmount().getRecords());
        if(detailId.equals("1")){
            model.addAttribute("agori","热卖服装");
        }else if(detailId.equals("2")){
            model.addAttribute("agori","男士服装");
            } else if(detailId.equals("3")){
            model.addAttribute("agori","女士服装");
        }else if(detailId.equals("4")){
            model.addAttribute("agori","儿童服装");
        }
        else if(detailId.equals("0")){
            model.addAttribute("agori","全部服装");
        }
        return "product";

    }

    /**
     * @Author sillybilly
     * @Description  clothlist显示
     * @Date 2019/5/15 10:15
     * @Param [categoryid]
     * @return java.util.List<com.shop.cloth.core.dal.domain.Cloth>
     */
    @RequestMapping(method = RequestMethod.GET,value = "/detailClothList")
    @ResponseBody
    public Page<Cloth> getDetailClothList(String categoryid,HttpSession session)
    {
        System.out.println(categoryid);
        if(categoryid.equals("热卖服装"))
        {
           return clothService.findAllHot(1,session);
        }
        else if(categoryid.equals("男士服装")){
            return clothService.findAllMale(1);
        }else if(categoryid.equals("女士服装"))
        {
            return clothService.findAllFemale(1);
        }else if(categoryid.equals("全部服装")){
            return clothService.findAllCloth(1);
        }
        else return clothService.findAllChild(1);
    }


    /**
     * @Author sillybilly
     * @Description  商品详情页跳转
     * @Date 2019/5/12 16:00
     * @Param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/single")
    public String getClothInfo(Model model,Integer clothId)
    {
            System.out.println(clothId.getClass());
            model.addAttribute("clothInfo",clothService.queryClothInfo(clothId));
            model.addAttribute("remarkCount",remarkService.caculateClothCount(clothId));
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
    public String getCheckOut(Model model, HttpSession session)
    {
        if(session.getAttribute("userInfo")==null||session.getAttribute("userInfo")=="")
            return "index";
        String str = session.getAttribute("userInfo").toString();
        int userId = Integer.parseInt(str.substring(str.indexOf("=")+1,str.indexOf(",")));
        model.addAttribute("subPrice",cartService.CaculatePrice(userId));
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

    @RequestMapping(method = RequestMethod.GET,value = "/contact")
    public String getContact()
    {
        return "contact";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/money")
    public String getMoney(HttpSession session)
    {
        if(session.getAttribute("userInfo")==null||session.getAttribute("userInfo")=="")
            return "index";
        return "money";
    }

    /**
     * @Author sillybilly
     * @Description  服装分页判断
     * @Date 2019/5/18 11:31
     * @Param [count, current, categoryid]
     * @return com.baomidou.mybatisplus.plugins.Page<com.shop.cloth.core.dal.domain.Cloth>
     */
    @RequestMapping(method = RequestMethod.GET,value = "/GoCloth")
    @ResponseBody
    public Page<Cloth> getGoClothList(int count,int current,String categoryid,HttpSession session)
    {
        System.out.println(categoryid);
        if(categoryid.equals("热卖服装"))
        {
            if(current == 2)
            return clothService.findAllHot(count,session);
            else {
                if(current == 0)
                    if(count == 1)
                        return clothService.findAllHot(count,session);
                    else return clothService.findAllHot(count-1,session);
                    else {
                        if(count == clothService.findAllHot(count,session).getPages())
                            return clothService.findAllHot(count,session);
                        else return clothService.findAllHot(count+1,session);
                }
            }
        }
        else if(categoryid.equals("男士服装")){
            if(current == 2)
                return clothService.findAllMale(count);
            else {
                if(current == 0)
                    if(count == 1)
                        return clothService.findAllMale(count);
                    else return clothService.findAllMale(count-1);
                else {
                    if(count == clothService.findAllMale(count).getPages())
                        return clothService.findAllMale(count);
                    else return clothService.findAllMale(count+1);
                }
            }
        }
        else if(categoryid.equals("女士服装"))
        {
            if(current == 2)
                return clothService.findAllFemale(count);
            else {
                if(current == 0)
                    if(count == 1)
                        return clothService.findAllFemale(count);
                    else return clothService.findAllFemale(count-1);
                else {
                    if(count == clothService.findAllFemale(count).getPages())
                        return clothService.findAllFemale(count);
                    else return clothService.findAllFemale(count+1);
                }
            }
        }
        else if(categoryid.equals("全部服装"))
        {
            if(current == 2)
                return clothService.findAllCloth(count);
            else {
                if(current == 0)
                    if(count == 1)
                        return clothService.findAllCloth(count);
                    else return clothService.findAllCloth(count-1);
                else {
                    if(count == clothService.findAllCloth(count).getPages())
                        return clothService.findAllCloth(count);
                    else return clothService.findAllCloth(count+1);
                }
            }
        }
        else {
            if(current == 2)
                return clothService.findAllChild(count);
            else {
                if(current == 0)
                    if(count == 1)
                        return clothService.findAllChild(count);
                    else return clothService.findAllChild(count-1);
                else {
                    if(count == clothService.findAllChild(count).getPages())
                        return clothService.findAllChild(count);
                    else return clothService.findAllChild(count+1);
                }
            }
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/userInfo")
    public String userInfo(HttpSession session)
    {
        if(session.getAttribute("userInfo")==null||session.getAttribute("userInfo")=="")
            return "index";
        String str = session.getAttribute("userInfo").toString();
        int userId = Integer.parseInt(str.substring(str.indexOf("=")+1,str.indexOf(",")));
        User user = userService.queryById(userId);
        session.setAttribute("userInfo",user);
        return "userInfo";
    }

}
