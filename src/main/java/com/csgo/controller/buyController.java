package com.csgo.controller;

import com.csgo.po.deal;
import com.csgo.po.moneycharge;
import com.csgo.po.user;
import com.csgo.po.weapon;
import com.csgo.service.DealService;
import com.csgo.service.MoneyChargeService;
import com.csgo.service.UserService;
import com.csgo.service.WeaponService;
import com.csgo.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
public class buyController {

    @Autowired
    private DealService dealService;
    @Autowired
    private WeaponService weaponService;
    @Autowired
    private  HttpServletRequest request;
    @Autowired
    private UserService userService;
    @Autowired
    private MoneyChargeService moneyChargeService;

    @GetMapping("/queryGoodById")
    public String queryGoodById(Integer id, Model model)
    {


        weapon good=weaponService.queryWeaponById(id);
        model.addAttribute("good",good);
        return  "buy/buyWeapon";
    }


    @ResponseBody
    @RequestMapping("/buyWeapon")
    public R buyWeapon(HttpSession session , @RequestBody weapon weapon)
    {
        user user= (com.csgo.po.user) session.getAttribute("user");

        deal deal = new deal();
        float account= (float) (user.getAccount()-weapon.getWeaponprice());
        double total=weapon.getWeaponprice();
        System.out.println(total);
        int store=weapon.getWeaponstore()-1;
        if(account>0) {
            if(store>0) {
                weapon.setWeaponstore(store);
                user.setAccount(account);
                weaponService.updateWeaponSubmit(weapon);
                userService.updateUserSubmit(user);
                deal.setCreatedate(new Date());
                deal.setTotal((float) total);
                deal.setUserid(user.getId());
                deal.setIspay((byte) 1);
                deal.setWeaponid(weapon.getWeaponid());
                dealService.addDealSubmit(deal);
                return R.ok();
            }
            else
            {
                return R.fail("库存不足");
            }
        }
        else
        {
            return R.fail("购买失败");
        }
    }
    @GetMapping("/buyIndex")
    public String buyIndex()
    {
        return "buy/buyIndex";
    }

    @GetMapping("/recordIndex")
    public String recordIndex()
    {
        return "buy/recordIndex";
    }


    @GetMapping("/moneyUpdate")
    public String moneyUpdate()
    {
        return "buy/moneyUpdate";
    }

    @ResponseBody
    @RequestMapping("/moneyCharge")
    public R moneyCharge(HttpSession session ,moneycharge moneycharge) {

        user user= (com.csgo.po.user) session.getAttribute("user");
        float account= (float) (user.getAccount()+moneycharge.getMoney());
        user.setAccount(account);
        if (moneyChargeService.updateMoneyCharge(moneycharge)==1)
        {
            userService.updateUserSubmit(user);
            return R.ok("兑换成功");
        }
        else
        {
            return R.fail("兑换失败");
        }

    }



}
