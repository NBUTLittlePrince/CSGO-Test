package com.csgo.controller;

import com.csgo.po.admin;
import com.csgo.po.weaponfeature;
import com.csgo.service.AdminService;
import com.csgo.service.WeaponFeatureService;
import com.csgo.util.R;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
@Controller
public class FeatureController {

    @Autowired
    private WeaponFeatureService weaponFeatureService;


    @GetMapping("/featureIndex")
    public String featureIndex()
    {
        return "feature/featureIndex";
    }

    /**
     * 添加外观
     */
    @GetMapping("/addFeature")
    public String addAdmin(){return "feature/addFeature";}


    /**
     * 查询所有的管理员信息
     */
    @ResponseBody
    @RequestMapping("/featureAll")
    public R adminAll(weaponfeature weaponfeature, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int limit)
    {
        //查询所以的记录信息
        PageInfo<weaponfeature> pageInfo=weaponFeatureService.queryFeatureInfoAll(weaponfeature,page,limit);
        return R.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }





}
