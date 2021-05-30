package com.csgo.controller;

import com.csgo.service.WeaponTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {


    @Autowired
    private WeaponTypeService weaponTypeService;

/*
    @RequestMapping("/test")
    public String testindex()
    {
        weaponTypeService.queryWeaponTypeAll();
        System.out.println("测试springmvc的内容");
        return "/test";
    }

 */
}


