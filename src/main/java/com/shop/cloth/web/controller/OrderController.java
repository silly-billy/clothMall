package com.shop.cloth.web.controller;

import com.shop.cloth.core.common.VO.OrderVO;
import com.shop.cloth.core.common.util.DateSyncUtil;
import com.shop.cloth.core.common.util.OrderToVO;
import com.shop.cloth.core.dal.domain.Cart;
import com.shop.cloth.core.dal.domain.Cloth;
import com.shop.cloth.core.dal.domain.Orders;
import com.shop.cloth.core.dal.domain.User;
import com.shop.cloth.core.service.CartService;
import com.shop.cloth.core.service.ClothService;
import com.shop.cloth.core.service.OrdersService;
import com.shop.cloth.core.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: silly-billy
 * @Date: 2019/5/20 0:36
 * @Version 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrdersService ordersService;
    @Resource
    private CartService cartService;
    @Resource
    private UserService userService;
    @Resource
    private ClothService clothService;

    /**
     * @Author sillybilly
     * @Description   msg->0 购物成功  msg->1 余额不足 购物失败  msg->2 地址信息不完整
     * @Date 2019/5/20 1:00
     * @Param [id]
     * @return int
     */
    @RequestMapping(method = RequestMethod.GET,value = "/buySimpleCart")
    @ResponseBody
    public int buySimpleCart(int id)
    {
        int message = 0;
        Cart cart = cartService.queryCartInfoById(id);
        int userId = cart.getCartUserid();
        User user = userService.queryById(userId);
        String address = user.getUserAddress();
        /*使用long类型比较double数值类型*/
        if(Double.doubleToLongBits(user.getUserBalance()) < Double.doubleToLongBits(cart.getCartSubprice()))
        {
            message = 1;  //余额不足
        }else if(user.getUserAddress().equals("")){
            message = 2;   //未设置收获地址
        }else {
            Orders order = new Orders();
            order.setOrderCartid(id);
            order.setOrderClothid(cart.getCartClothid());
            order.setOrderUserid(userId);
            order.setOrderNum(String.valueOf(System.currentTimeMillis()));
            order.setOrderCurtime(DateSyncUtil.format(new Date()));
            BigDecimal bd1 = new BigDecimal(Double.toString(user.getUserBalance()));
            BigDecimal bd2 = new BigDecimal(Double.toString(cart.getCartSubprice()));
            user.setUserBalance(bd1.subtract(bd2).doubleValue());
            userService.UpdateByUserInfo(user);   //用户减去对应金额
            Cloth cloth = clothService.queryClothInfo(cart.getCartClothid());
            cloth.setClothSellamount(cloth.getClothSellamount()+cart.getCartClothnum());
            clothService.updateClothInfo(cloth);
            ordersService.addOrderInfo(order);   //加入订单
            cartService.deleteCartInfo(cart.getId());
        }
        return message;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/showOrderInfo")
    @ResponseBody
    public List<OrderVO> showOrderInfo(HttpSession session)
    {
        if(session.getAttribute("userInfo")==null||session.getAttribute("userInfo")=="")
           return null;
        else{
            String str = session.getAttribute("userInfo").toString();
            int userId = Integer.parseInt(str.substring(str.indexOf("=")+1,str.indexOf(",")));
            List<Orders> orderslist =  ordersService.showOrders(userId);
            List<OrderVO> orderVOS = new ArrayList<>();
            for (Orders orders:orderslist) {
                OrderVO orderVO = OrderToVO.orderToOrderVo(orders);
                orderVO.setClothName(clothService.queryClothInfo(orders.getOrderClothid()).getClothName());
                orderVO.setCartSubprice(cartService.queryCartInfoById(orders.getOrderCartid()).getCartSubprice());
                orderVOS.add(orderVO);
            }
            return orderVOS;
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/confirmOrder")
    @ResponseBody
    public int confirmOrder(String orderNum)
    {
        if(ordersService.confirmOrder(orderNum)){
            return 1;
        }
        else return 0;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/cancelOrder")
    @ResponseBody
    public int cancelOrder(String orderNum)
    {
        return ordersService.cancelOrder(orderNum);
    }

}
