package com.csgo.controller;


import com.csgo.po.deal;
import com.csgo.po.user;
import com.csgo.po.weapon;
import com.csgo.service.DealService;
import com.csgo.service.WeaponService;
import com.csgo.util.R;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class DealController {
    @Autowired
    private DealService dealService;



    @GetMapping("/dealIndex")
    public String dealIndex()
    {
        return "deal/dealIndex";
    }


    /**
     * 查询所有的交易信息
     */
    @ResponseBody
    @RequestMapping("/dealAll")
    public R dealAll(deal deal, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int limit)
    {
        //查询所以的记录信息
        PageInfo<deal> pageInfo=dealService.queryDealInfoAll(deal,page,limit);
        return R.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }
    /**
     *删除功能实现
     */
    @ResponseBody
    @RequestMapping("/deleteDeal")
    public R deleteDeal(String ids)
    {
        List<String> list= Arrays.asList(ids.split(","));
        int num=dealService.deleteDealByIds(list);
        if(num>0)
        {
            return R.ok();
        }
        else
        {
            return R.fail("删除失败");
        }
    }


    /**
     * 查询所有的交易信息
     */
    @ResponseBody
    @RequestMapping("/dealForUser")
    public R dealForUser(HttpSession session ,deal deal, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int limit)
    {
        //查询所以的记录信息
        user user= (com.csgo.po.user) session.getAttribute("user");
        deal.setUserid(user.getId());
        PageInfo<deal> pageInfo=dealService.queryDealInfoAll(deal,page,limit);
        return R.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }


}
