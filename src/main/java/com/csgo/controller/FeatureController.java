package com.csgo.controller;

import com.csgo.po.Weapontype;
import com.csgo.po.admin;
import com.csgo.po.weaponfeature;
import com.csgo.po.weaponquality;
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
     * 查询所有的外观信息
     */
    @ResponseBody
    @RequestMapping("/featureAll")
    public R featureAll(weaponfeature weaponfeature, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int limit)
    {
        //查询所以的记录信息
        PageInfo<weaponfeature> pageInfo=weaponFeatureService.queryFeatureInfoAll(weaponfeature,page,limit);
        return R.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }


    /**
     * 添加外观
     */
    @GetMapping("/addFeature")
    public String addFeature(){return "feature/addFeature";}


    /**
     * 提交管理员添加功能
     */
    @ResponseBody
    @RequestMapping("/addFeatureSubmit")
    public R addFeatureSubmit(weaponfeature weaponfeature)
    {
        int num=weaponFeatureService.addWeaponFeatureSubmit(weaponfeature);
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
    @RequestMapping("/deleteFeature")
    public R deleteFeature(String ids)
    {
        List<String> list=Arrays.asList(ids.split(","));
        int num=weaponFeatureService.deleteWeaponfeatureById(list);
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
     * 根据id查询外观信息
     */
    @GetMapping("/queryFeatureById")
    public String queryFeatureById(Integer id, Model model)
    {
        weaponfeature weaponfeature=weaponFeatureService.queryWeaponfeatureById(id);
        model.addAttribute("weaponfeature",weaponfeature);
        return  "feature/updateFeature";
    }


    /**
     * 获取武器外观列表
     */
    @ResponseBody
    @RequestMapping("/findFeatureList")
    public List<weaponfeature> findFeatureAll(){
        PageInfo<weaponfeature> pageInfo=weaponFeatureService.queryFeatureInfoAll(null,1,100);
        List<weaponfeature> lists=pageInfo.getList();
        return lists;
    }


    /**
     * 修改提交功能
     */
    @ResponseBody
    @RequestMapping("/updateWeaponFeatureSubmit")
    public R updateWeaponFeatureSubmit(weaponfeature weaponfeature)
    {
        weaponFeatureService.updateWeaponfeatureSubmit(weaponfeature);
        return R.ok();
    }
}
