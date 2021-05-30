package com.csgo.controller;

import com.csgo.po.admin;
import com.csgo.service.AdminService;
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
public class AdminController {

    @Autowired
    private AdminService adminService;
    @GetMapping("/adminIndex")
    public String adminIndex()
    {
        return "admin/adminIndex";
    }


    /**
     * 查询所有的管理员信息
     */
    @ResponseBody
    @RequestMapping("/adminAll")
    public R adminAll(admin admin,@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "5")int limit)
    {
       //查询所以的记录信息
        PageInfo<admin> pageInfo=adminService.queryAdminInfoAll(admin,page,limit);
        return R.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加管理员
     */
    @GetMapping("/addAdmin")
    public String addAdmin(){return "admin/addAdmin";}

    /**
     * 提交管理员添加功能
     */
    @ResponseBody
    @RequestMapping("/addAdminSubmit")
    public R addAdminSubmit(admin admin)
    {
       int num=adminService.addAdminSubmit(admin);
        if(num>0)
        {
            return R.ok();
        }
        else
        {
            return R.fail("添加失败");
        }

    }
    /**
     *删除功能实现
     */
    @ResponseBody
    @RequestMapping("/deleteAdmin")
    public R deleteAdmin(String ids)
    {
        List<String> list=Arrays.asList(ids.split(","));
        int num=adminService.deleteAdminByIds(list);
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
     * 根据id查询管理员信息
     */
    @GetMapping("queryAdminById")
    public String queryAdminById(Integer id, Model model)
    {
        model.addAttribute("id",id);
        return  "admin/updateAdmin";
    }

    /**
     * 密码修改
     */

    @ResponseBody
    @RequestMapping ("updateAdminSubmit")
    public R updateAdminSubmit(Integer id,String oldPwd,String newPwd)
    {
        admin info=adminService.queryAdminById(id);
        if(!oldPwd.equals(info.getPassword()))
        {
            return R.fail("输入的旧密码和原来不一致");
        }
        else
        {
            info.setPassword(newPwd);
            adminService.updateAdminSubmit(info);
            return R.ok();
        }
    }
}
