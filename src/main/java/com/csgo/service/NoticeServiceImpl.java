package com.csgo.service;

import com.csgo.dao.noticeMapper;
import com.csgo.po.notice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements  NoticeService{

    @Autowired
    private noticeMapper noticeDao;

    @Override
    public PageInfo<notice> queryNoticeAll(String content, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<notice> list=noticeDao.queryNoticeAll(content);
        PageInfo<notice> pageInfo=new PageInfo<>(list);
        return  pageInfo;
    }

    @Override
    public void insertNoticeInfo(notice notice) {

        noticeDao.insertSelective(notice);
    }

    @Override
    public notice queryNoticeById(Integer id) {
        return noticeDao.selectByPrimaryKey(id);
    }

    @Override
    public void deleteNoticeByIds(List<String> ids) {

        List<Integer> list=new ArrayList<>();
        for (String id:ids)
        {
            list.add(Integer.valueOf(id));
        }
        noticeDao.deleteNoticeByIds(list);

    }
}
