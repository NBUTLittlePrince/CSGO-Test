package com.csgo.service;

import com.csgo.po.admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdminService {
    /**
     * 分页查询
     */
    PageInfo<admin> queryAdminInfoAll(admin admin,int page,int limit);

    /**
     * 添加
     */
     int addAdminSubmit(admin admin);

    /**
     * 修改
     */
    int updateAdminSubmit(admin admin);

    /**
     * 删除
     */
    int deleteAdminByIds(List<String> ids);

    /**
     * 根据id查询详细信息
     */

    admin queryAdminById(Integer id);

}
