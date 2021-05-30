package com.csgo.service;
import com.csgo.po.weapon;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface WeaponService {

    /**
     * 分页查询
     */
    PageInfo<weapon> queryWeaponInfoAll(weapon weapon, int page, int limit);

    /**
     * 添加
     */
    int addWeaponSubmit(weapon weapon);

    /**
     * 修改
     */
    int updateWeaponSubmit(weapon weapon);

    /**
     * 删除
     */
    int deleteWeaponByIds(List<String> ids);

    /**
     * 根据id查询详细信息
     */

    weapon queryWeaponById(Integer id);
}
