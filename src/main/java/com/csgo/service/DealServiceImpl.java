package com.csgo.service;

import com.csgo.dao.dealMapper;
import com.csgo.dao.weaponMapper;
import com.csgo.po.deal;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("dealService")
public class DealServiceImpl implements DealService{
    @Autowired
    private dealMapper dealMapper;
    @Autowired
     private weaponMapper weaponMapper;

    @Override
    public PageInfo<deal> queryDealInfoAll(deal deal, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<deal> list=dealMapper.queryDealInfoAll(deal);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int addDealSubmit(deal deal) {
        return dealMapper.insert(deal);
    }

    @Override
    public int updateDealSubmit(deal deal) {
        return dealMapper.updateByPrimaryKey(deal);
    }

    @Override
    public int deleteDealByIds(List<String> ids) {
        int num=0;
        for (String id:ids){
            int i=0;
            num+=dealMapper.deleteByPrimaryKey(Integer.valueOf(id));
        }
        return num;
    }

    @Override
    public deal queryDealById(Integer id) {
        return dealMapper.selectByPrimaryKey(id);
    }

    @Override
    public int buyWeaponById(List<String> ids) {

        return 0;
    }
}
