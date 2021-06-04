package com.csgo.service;

import com.csgo.po.weaponfeature;
import com.csgo.po.weaponquality;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("weaponqualityService")
public class WeaponQualityServiceImpl implements WeaponQualityService{
    @Autowired
    private com.csgo.dao.weaponqualityMapper weaponqualityMapper;


    @Override
    public int addWeaponQualitySubmit(weaponquality weaponquality) {
        return weaponqualityMapper.insert(weaponquality);
    }

    @Override
    public weaponquality queryWeaponqualityById(Integer id) {
        return weaponqualityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateWeaponqualitySubmit(weaponquality weaponquality) {
        return weaponqualityMapper.updateByPrimaryKey(weaponquality);
    }

    @Override
    public int deleteWeaponQualityById(List<String> ids) {
        int num=0;
        for (String id:ids){
            int i=0;
            num+=weaponqualityMapper.deleteByPrimaryKey(Integer.valueOf(id));
        }
        return num;
    }

    @Override
    public PageInfo<weaponquality> queryQualityInfoAll(weaponquality weaponquality, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<weaponquality> list=weaponqualityMapper.queryQualityInfoAll(weaponquality);
        //通过包装获取分页需要的其他值
        PageInfo <weaponquality> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

}
