package com.shop.cloth.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.dal.domain.Cart;
import com.shop.cloth.core.dal.domain.User;
import com.shop.cloth.core.service.CartService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @Author: silly-billy
 * @Date: 2019/5/15 23:21
 * @Version 1.0
 */
@Controller
public class CartController {

    @Resource
    private CartService cartService;

    /**
     * @Author sillybilly
     * @Description  0--添加购物车成功 1--失败
     * @Date 2019/5/15 23:48
     * @Param [cart]
     * @return int
     */
    @RequestMapping(method = RequestMethod.POST,value = "/addcheckout")
    @ResponseBody
    public int addcheckout(Cart cart,HttpSession session)
    {
        int message = 0;
        if(session.getAttribute("userInfo")==null||session.getAttribute("userInfo")=="")
            message = 1;
        else
        {
            String str = session.getAttribute("userInfo").toString();
            //System.out.println(session.getAttribute("userInfo").toString().substring(str.indexOf("=")+1,str.indexOf(",")));

            cart.setCartUserid(Integer.parseInt(session.getAttribute("userInfo").toString().substring(str.indexOf("=")+1,str.indexOf(","))));
            cart.setCartSubprice(cart.getCartClothprice()*cart.getCartClothnum());
            cartService.addCartInfo(cart);
        }
        return message;
    }

    /**
     * @Author sillybilly
     * @Description   查询购物车信息--首页显示
     * @Date 2019/5/16 10:57
     * @Param [count]
     * @return com.baomidou.mybatisplus.plugins.Page<com.shop.cloth.core.dal.domain.Cart>
     */
    @RequestMapping(method = RequestMethod.GET,value = "/showCartInfo")
    @ResponseBody
    public Page<Cart> showCartInfo(int count,Model model)
    {
        model.addAttribute("subPrice",cartService.CaculatePrice());
        return cartService.queryCartInfo(count);
    }

    /**
     * @Author sillybilly
     * @Description  购物车页面分页跳转  count当前页，current状态0--上一页  1--下一页
     * @Date 2019/5/16 13:12
     * @Param [count]
     * @return com.baomidou.mybatisplus.plugins.Page<com.shop.cloth.core.dal.domain.Cart>
     */
    @RequestMapping(method = RequestMethod.GET,value = "/GoCart")
    @ResponseBody
    public Page<Cart> GoCart(int count,int current)
    {
        if(current == 2){
            return cartService.queryCartInfo(count);
        }else{
            if(current == 0){
                if(count == 1)
                    return cartService.queryCartInfo(count);
                else
                    return cartService.queryCartInfo(count-1);
            }else
                {if (count == cartService.queryCartInfo(count).getPages())
                    return cartService.queryCartInfo(count);
                else
                    return cartService.queryCartInfo(count + 1);}
        }
    }

    /**
     * @Author sillybilly
     * @Description   移除购物车
     * @Date 2019/5/16 14:23
     * @Param [id]
     * @return java.lang.String
     */
    @RequestMapping(method = RequestMethod.GET,value = "/removeCartInfo")
    public String removeCartInfo(int id,Model model)
    {
        model.addAttribute("subPrice",cartService.CaculatePrice());
        cartService.deleteCartInfo(id);
        return "redirect:checkout";
    }

}
