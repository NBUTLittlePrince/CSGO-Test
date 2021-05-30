package com.csgo.service;

import com.csgo.po.Weapontype;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface WeaponTypeService {


    PageInfo<Weapontype> queryWeaponTypeAll(String weapontypename,int page,int limit);

    /**

     *添加武器类型
     */
    void addWeaponTypeSubmit(Weapontype weapontype);


    /**
     *修改武器类型
     * 根据id查询基本信息
     */
    Weapontype queryWeaponTypeById(Integer id);


    /**
     *修改提交
     */
    void updateWeaponTypeSubmit(Weapontype weapontype);

    /**
     *根据ids删除记录
     */
    void deleteWeaponTypeById(List<String> id);
}
