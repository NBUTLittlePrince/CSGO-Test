package com.csgo.controller;

import com.csgo.po.notice;
import com.csgo.po.weapon;
import com.csgo.service.NoticeService;
import com.csgo.service.WeaponService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BaseController {
    @Autowired
    private NoticeService noticeService;

    @Autowired
    private WeaponService weaponService;

    @GetMapping("/index")
    public String index()
    {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome(Model model)
    {
        //公告信息
       PageInfo<notice> pageInfo=noticeService.queryNoticeAll(null,1,1);
       if(pageInfo!=null)
       {
           if(pageInfo.getList().size()>0)
           {
               notice notice=pageInfo.getList().get(0);
               model.addAttribute("info",notice);

           }
       }

        List<weapon> list=weaponService.getWeaponCountByType();
        model.addAttribute("list",list);
        return "welcome";

    }

}
