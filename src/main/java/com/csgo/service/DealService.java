package com.csgo.service;

import com.csgo.po.deal;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DealService {

        /**
         * 分页查询
         */
        PageInfo<deal> queryDealInfoAll(deal deal, int page, int limit);

        /**
         * 添加
         */
        int addDealSubmit(deal deal);

        /**
         * 修改
         */
        int updateDealSubmit(deal deal);

        /**
         * 删除
         */
        int deleteDealByIds(List<String> ids);

        /**
         * 根据id查询详细信息
         */

        deal queryDealById(Integer id);

        int buyWeaponById(List<String> ids);



}
