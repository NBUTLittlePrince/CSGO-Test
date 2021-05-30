package com.csgo.service;

import com.csgo.po.notice;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface NoticeService {
    PageInfo<notice> queryNoticeAll(String content,int page,int limit);

    /**
     * 添加公告
     */
    void insertNoticeInfo(notice notice);

    /**
     * 根据id查询
     */
    notice queryNoticeById(Integer id);

    /**
     * 删除
     */

    void deleteNoticeByIds(List<String> ids);
}
