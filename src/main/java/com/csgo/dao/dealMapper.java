package com.csgo.dao;

import com.csgo.po.deal;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface dealMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbggenerated Tue Jun 01 21:18:15 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbggenerated Tue Jun 01 21:18:15 CST 2021
     */
    int insert(deal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbggenerated Tue Jun 01 21:18:15 CST 2021
     */
    int insertSelective(deal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbggenerated Tue Jun 01 21:18:15 CST 2021
     */
    deal selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbggenerated Tue Jun 01 21:18:15 CST 2021
     */
    int updateByPrimaryKeySelective(deal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbggenerated Tue Jun 01 21:18:15 CST 2021
     */
    int updateByPrimaryKey(deal record);

    List<deal> queryDealInfoAll(deal deal) ;
}