package com.csgo.service;

import com.csgo.dao.WeaponTypeDao;
import com.csgo.po.Weapontype;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("WeaponTypeService")
public class WeaponTypeServiceImpl implements  WeaponTypeService{
@Autowired
private WeaponTypeDao weapontypedao;

    @Override
    public PageInfo<Weapontype> queryWeaponTypeAll(String weapontypename,int page,int limit) {

        PageHelper.startPage(page,limit);
        List<Weapontype> list=weapontypedao.queryWeaponTypeInfoAll(weapontypename);
        //通过包装获取分页需要的其他值
      PageInfo <Weapontype> pageInfo=new PageInfo<>(list);
      return pageInfo;
    }

    @Override
    public void addWeaponTypeSubmit(Weapontype weapontype) {
        weapontypedao.addWeaponTypeSubmit(weapontype);
    }

    @Override
    public Weapontype queryWeaponTypeById(Integer id) {
        return weapontypedao.queryWeaponTypeById(id);
    }

    @Override
    public void updateWeaponTypeSubmit(Weapontype weapontype) {
        weapontypedao.updateWeaponTypeSubmit(weapontype);
    }

    @Override
    public void deleteWeaponTypeById(List<String> id) {

        List<Integer> list=new ArrayList<>();
        for (String cid:id)
        {
            int id2=Integer.valueOf(cid);
            list.add(id2);
        }
          weapontypedao.deleteWeaponTypeById(list);
    }


}
