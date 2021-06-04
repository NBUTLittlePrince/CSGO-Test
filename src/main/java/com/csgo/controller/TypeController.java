package com.csgo.controller;

import com.csgo.po.Weapontype;
import com.csgo.po.weaponfeature;
import com.csgo.service.WeaponTypeService;
import com.csgo.util.R;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class TypeController {


    @Autowired
    private WeaponTypeService weaponTypeService;




    @GetMapping("/typeIndex")
    public String typeIndex()
    {
        return "type/typeIndex";
    }

    /**
    *添加页面
     */
    @GetMapping("/typeAdd")
     public String typeAdd() {
        return "type/typeAdd";
    }

    /**
    *获取信息分页
     */
    @RequestMapping("/typeAll")
    @ResponseBody
    public R typeAll(String weapontypename, @RequestParam(defaultValue ="1" ) Integer page, @RequestParam(defaultValue ="5" )  Integer limit)
    {
     PageInfo<Weapontype> pageInfo= weaponTypeService.queryWeaponTypeAll(weapontypename,page,limit);

        return R.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }


    /**
     * 类型添加
     */
    @ResponseBody
    @RequestMapping("/addWeaponTypeSubmit")
   public R addWeaponTypeSubmit(Weapontype weapontype)
   {
       weaponTypeService.addWeaponTypeSubmit(weapontype);
       return R.ok();
   }

    /**
     * 根据id查询
     */
    @GetMapping("queryWeaponTypeById")
    public String queryWeaponTypeById(Integer id, Model model)
    {
       Weapontype weapontype=weaponTypeService.queryWeaponTypeById(id);
       model.addAttribute("weapontype",weapontype);
       return "type/updateType";
    }

    /**
     * 修改提交功能
     */
    @ResponseBody
    @RequestMapping("/updateWeaponTypeSubmit")
    public R updateWeaponTypeSubmit(@RequestBody Weapontype weapontype)
    {
        weaponTypeService.updateWeaponTypeSubmit(weapontype);
        return R.ok();
    }
    /**
     * 类型删除
     */
    @ResponseBody
    @RequestMapping("deleteWeaponType")
    public R deleteWeaponType(String ids)
    {
 List list= Arrays.asList(ids.split(","));
       weaponTypeService.deleteWeaponTypeById(list);
       return  R.ok();
    }
    /**
     * 获取武器类型列表
     */
    @ResponseBody
    @RequestMapping("/findTypeList")
    public List<Weapontype> findTypeAll(){
        PageInfo<Weapontype> pageInfo=weaponTypeService.queryWeaponTypeAll(null,1,100);
        List<Weapontype> lists=pageInfo.getList();
        return lists;
    }

}
