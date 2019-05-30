package com.shop.cloth.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.shop.cloth.core.dal.domain.Remark;
import com.shop.cloth.core.service.RemarkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author: silly-billy
 * @Date: 2019/5/29 21:38
 * @Version 1.0
 */
@Controller
@RequestMapping("/remark")
public class RemarkController {

    @Resource
    private RemarkService remarkService;

    @RequestMapping(method = RequestMethod.POST,value = "/clothRemark")
    @ResponseBody
    public int addRemarkInfo(Remark remark,HttpSession session){
        return remarkService.addRemarkInfo(remark,session);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/showRemarkInfo")
    @ResponseBody
    public Page<Remark> showRemarkInfo(int remarkClothid){
        return remarkService.showRemarkInfo(1,remarkClothid);
    }


    @RequestMapping(method = RequestMethod.GET,value = "/showRemarkInfoPage")
    @ResponseBody
    public Page<Remark> showRemarkInfoPage(int remarkClothid,int current,int sign){
        if(sign == 1){
            return remarkService.showRemarkInfo(current,remarkClothid);
        }else{
            if(sign == 0){
                if(current == 1)
                    return remarkService.showRemarkInfo(current,remarkClothid);
                else
                    return remarkService.showRemarkInfo(current-1,remarkClothid);
            }else {
                if (current == remarkService.showRemarkInfo(current,remarkClothid).getPages())
                    return remarkService.showRemarkInfo(current,remarkClothid);
                else
                    return remarkService.showRemarkInfo(current+1,remarkClothid);
            }
        }

    }

}
