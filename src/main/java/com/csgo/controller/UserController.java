package com.csgo.controller;

import com.csgo.po.user;
import com.csgo.service.UserService;
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
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/userIndex")
    public String userIndex()
    {
        return "user/userIndex";
    }

    /**
     * 查询所有的用户信息
     */
    @ResponseBody
    @RequestMapping("/userAll")
    public R adminAll(user user, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int limit)
    {
        //查询所以的记录信息
        PageInfo<user> pageInfo=userService.queryUserInfoAll(user,page,limit);
        return R.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }


    /**
     * 添加用户
     */
    @GetMapping("/addUser")
    public String addUser(){return "user/addUser";}

    /**
     * 提交用户添加功能
     */
    @ResponseBody
    @RequestMapping("/addUserSubmit")
    public R addUserSubmit(user user)
    {
        int num=userService.addUserSubmit(user);
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
    @RequestMapping("/deleteUser")
    public R deleteUser(String ids)
    {
        List<String> list= Arrays.asList(ids.split(","));
        int num=userService.deleteUserByIds(list);
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
     * 根据id查询用户信息
     */
    @GetMapping("queryUserById")
    public String queryUserById(Integer id, Model model)
    {
        model.addAttribute("id",id);
        return  "user/updateUser";
    }

    /**
     * 密码修改
     */

    @ResponseBody
    @RequestMapping ("updateUserSubmit")
    public R updateUserSubmit(Integer id,String oldPwd,String newPwd)
    {
        user info=userService.queryUserById(id);
        if(!oldPwd.equals(info.getPassword()))
        {
            return R.fail("输入的旧密码和原来不一致");
        }
        else
        {
            info.setPassword(newPwd);
            userService.updateUserSubmit(info);
            return R.ok();
        }
    }
}
