package com.csgo.dao;

import com.csgo.po.Weapontype;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("WeaponTypeDao")
public interface WeaponTypeDao {


    List<Weapontype> queryWeaponTypeInfoAll(@Param(value ="weapontypename") String weapontypename);


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
    void deleteWeaponTypeById(List<Integer> id);

}
