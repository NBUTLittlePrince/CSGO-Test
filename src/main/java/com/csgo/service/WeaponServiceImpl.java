package com.csgo.service;

import com.csgo.dao.weaponMapper;
import com.csgo.po.admin;
import com.csgo.po.weapon;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("weaponService")
public class WeaponServiceImpl implements WeaponService{
    @Autowired
    private weaponMapper weaponDao;
    @Override
    public PageInfo<weapon> queryWeaponInfoAll(weapon weapon, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<weapon> list= weaponDao.queryWeaponInfoAll(weapon);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int addWeaponSubmit(weapon weapon) {
        return weaponDao.insert(weapon);
    }

    @Override
    public int updateWeaponSubmit(weapon weapon) {
        return weaponDao.updateByPrimaryKey(weapon);
    }

    @Override
    public int deleteWeaponByIds(List<String> ids) {
        int num=0;
        for (String id:ids){
            int i=0;
            num+=weaponDao.deleteByPrimaryKey(Integer.valueOf(id));
        }
        return num;
    }

    @Override
    public weapon queryWeaponById(Integer id) {
        return weaponDao.selectByPrimaryKey(id);
    }
}
