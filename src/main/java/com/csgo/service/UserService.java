package com.csgo.service;

import com.csgo.po.user;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    /**
     * 分页查询
     */
    PageInfo<user> queryUserInfoAll(user user, int page, int limit);

    /**
     * 添加
     */
    int addUserSubmit(user user);

    /**
     * 修改
     */
    int updateUserSubmit(user user);

    /**
     * 删除
     */
    int deleteUserByIds(List<String> ids);

    /**
     * 根据id查询详细信息
     */

    user queryUserById(Integer id);
}
