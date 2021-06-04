package com.csgo.service;
import com.csgo.po.weaponquality;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface WeaponQualityService {


    /**

     *添加武器外观
     */
    int addWeaponQualitySubmit(weaponquality weaponquality);


    /**
     *修改武器外观类型
     * 根据id查询基本信息
     */
    weaponquality queryWeaponqualityById(Integer id);


    /**
     *修改提交
     */
    int updateWeaponqualitySubmit(weaponquality weaponquality);

    /**
     *根据ids删除记录
     */
    int deleteWeaponQualityById(List<String> ids);

    PageInfo<weaponquality> queryQualityInfoAll(weaponquality weaponquality, int page, int limit);
}
