package com.csgo.controller;

import com.csgo.po.Weapontype;
import com.csgo.po.weaponfeature;
import com.csgo.po.weaponquality;
import com.csgo.service.WeaponQualityService;
import com.csgo.util.R;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class QualityController {
    @Autowired
    private WeaponQualityService weaponQualityService;


    @GetMapping("/qualityIndex")
    public String qualityIndex()
    {
        return "quality/qualityIndex";
    }


    /**
     * 查询所有的质量信息
     */
    @ResponseBody
    @RequestMapping("/qualityAll")
    public R qualityAll(weaponquality weaponquality, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int limit)
    {
        //查询所以的记录信息
        PageInfo<weaponquality> pageInfo=weaponQualityService.queryQualityInfoAll(weaponquality,page,limit);
        return R.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }


    /**
     * 添加质量
     */
    @GetMapping("/addQuality")
    public String addQuality(){return "quality/addQuality";}




    /**
     * 提交管理员添加功能
     */
    @ResponseBody
    @RequestMapping("/addQualitySubmit")
    public R addQualitySubmit(weaponquality weaponquality)
    {
        int num=weaponQualityService.addWeaponQualitySubmit(weaponquality);
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
    @RequestMapping("/deleteQuality")
    public R deleteQuality(String ids)
    {
        List<String> list= Arrays.asList(ids.split(","));
        int num=weaponQualityService.deleteWeaponQualityById(list);
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
     * 根据id查询质量信息
     */
    @GetMapping("queryQualityById")
    public String queryQualityById(Integer id, Model model)
    {
        weaponquality weaponquality=weaponQualityService.queryWeaponqualityById(id);
        model.addAttribute("weaponquality",weaponquality);
        return  "quality/updateQuality";
    }


    /**
     * 获取武器质量列表
     */
    @ResponseBody
    @RequestMapping("/findQualityList")
    public List<weaponquality> findQualityAll(){
        PageInfo<weaponquality> pageInfo=weaponQualityService.queryQualityInfoAll(null,1,100);
        List<weaponquality> lists=pageInfo.getList();
        return lists;
    }

    /**
     * 修改提交功能
     */
    @ResponseBody
    @RequestMapping("/updateWeaponQualitySubmit")
    public R updateWeaponQualitySubmit(weaponquality weaponquality)
    {
        weaponQualityService.updateWeaponqualitySubmit(weaponquality);
        return R.ok();
    }
}
