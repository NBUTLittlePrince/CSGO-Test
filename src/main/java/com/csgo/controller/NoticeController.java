package com.csgo.controller;

import com.csgo.po.admin;
import com.csgo.po.notice;
import com.csgo.service.NoticeService;
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
import java.util.Date;
import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/noticeIndex")
    public String noticeIndex()
    {
        return "notice/noticeIndex";
    }

    /**
     * 查询所有公告信息
     */
    @ResponseBody
    @RequestMapping("/noticeAll")
    public R noticeAll(String content, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer limit)
    {
        PageInfo<notice> pageInfo=noticeService.queryNoticeAll(content,page,limit);
        return R.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }


    /**
     * 添加公告
     */
    @GetMapping("/addNotice")
    public String addNotice(){return "notice/addNotice";}

    /**
     * 提交公告添加功能
     */
    @ResponseBody
    @RequestMapping("/addNoticeSubmit")
    public R addNoticeSubmit(notice notice)
    {
        notice.setAuthor(1);
        notice.setCreatedate(new Date());
        noticeService.insertNoticeInfo(notice);
        return  R.ok();
    }
    /**
     *删除功能实现
     */
    @ResponseBody
    @RequestMapping("/deleteNoticeByIds")
    public R deleteNoticeByIds(String ids)
    {
        List<String> list= Arrays.asList(ids.split(","));
        noticeService.deleteNoticeByIds(list);
       return  R.ok();
    }

    /**
     * 详情跳转
     */
    @GetMapping("queryNoticeById")
    public String queryNoticeById(Integer id,Model model)
    {
        notice notice=noticeService.queryNoticeById(id);
        model.addAttribute("info",notice);
        return  "notice/queryNotice";
    }


}
