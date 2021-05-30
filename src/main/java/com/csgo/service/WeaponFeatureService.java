package com.csgo.service;

import com.csgo.po.admin;
import com.csgo.po.weaponfeature;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface WeaponFeatureService {


    /**

     *添加武器外观
     */
    int addWeaponFeatureSubmit(weaponfeature weaponfeature);


    /**
     *修改武器外观类型
     * 根据id查询基本信息
     */
    weaponfeature queryWeaponfeatureById(Integer id);


    /**
     *修改提交
     */
    int updateWeaponfeatureSubmit(weaponfeature weaponfeature);

    /**
     *根据ids删除记录
     */
    int deleteWeaponfeatureById(List<String> id);

    PageInfo<weaponfeature> queryFeatureInfoAll(weaponfeature weaponfeature, int page, int limit);
}
