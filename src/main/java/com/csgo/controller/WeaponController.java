package com.csgo.controller;


import com.csgo.po.admin;
import com.csgo.po.weapon;
import com.csgo.service.WeaponService;
import com.csgo.util.R;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class WeaponController {

    @Autowired
    private WeaponService weaponService;
    @GetMapping("/weaponIndex")
    public String weaponIndex()
    {
        return "weapon/weaponIndex";
    }




    /**
     * 查询所有的武器信息
     */
    @ResponseBody
    @RequestMapping("/weaponAll")
    public R weaponAll(weapon weapon, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int limit)
    {
        //查询所以的记录信息
        PageInfo<weapon> pageInfo=weaponService.queryWeaponInfoAll(weapon,page,limit);
        return R.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加武器
     */
    @GetMapping("/addWeapon")
    public String addWeapon(){return "weapon/addWeapon";}

    /**
     * 提交武器添加功能
     */
    @ResponseBody
    @RequestMapping("/addWeaponSubmit")
    public R addWeaponSubmit(weapon weapon)
    {
        int num=weaponService.addWeaponSubmit(weapon);
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
    @RequestMapping("/deleteWeapon")
    public R deleteWeapon(String ids)
    {
        List<String> list= Arrays.asList(ids.split(","));
        int num=weaponService.deleteWeaponByIds(list);
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
     * 根据id查询武器信息
     */
    @GetMapping("/queryWeaponById")
    public String queryWeaponById(Integer id, Model model)
    {
        weapon weapon=weaponService.queryWeaponById(id);
        model.addAttribute("weapon",weapon);
        return  "weapon/updateWeapon";
    }


    /**
     * 修改实现功能
     */
    @ResponseBody
    @RequestMapping("/updateWeaponInfoSubmit")
    public R updateWeaponInfoSubmit(@RequestBody weapon weapon){
        weaponService.updateWeaponSubmit(weapon);
        return R.ok();
    }

}
