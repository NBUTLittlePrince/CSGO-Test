package com.csgo.service;
import com.csgo.dao.weaponfeatureMapper;
import com.csgo.po.weaponfeature;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("weaponfeatureService")
public class WeaponFeatureServiceImpl implements WeaponFeatureService{
    @Autowired
    private weaponfeatureMapper weaponfeatureMapper;
    @Override
    public PageInfo<weaponfeature> queryFeatureInfoAll(weaponfeature weaponfeature ,int page, int limit) {
        PageHelper.startPage(page,limit);
        List<weaponfeature> list=weaponfeatureMapper.queryFeatureInfoAll(weaponfeature);
        //通过包装获取分页需要的其他值
        PageInfo <weaponfeature> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }


    @Override
    public int addWeaponFeatureSubmit(weaponfeature weaponfeature) {
         return weaponfeatureMapper.insert(weaponfeature);
    }

    @Override
    public weaponfeature queryWeaponfeatureById(Integer id) {
         return weaponfeatureMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateWeaponfeatureSubmit(weaponfeature weaponfeature) {
         return weaponfeatureMapper.updateByPrimaryKey(weaponfeature);
    }

    @Override
    public int deleteWeaponfeatureById(List<String> ids) {
        int num=0;
        for (String id:ids){
            int i=0;
            num+=weaponfeatureMapper.deleteByPrimaryKey(Integer.valueOf(id));
        }
        return num;
    }

}
