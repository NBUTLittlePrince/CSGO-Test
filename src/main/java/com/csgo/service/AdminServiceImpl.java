package com.csgo.service;

import com.csgo.dao.adminMapper;
import com.csgo.po.admin;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("adminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    private adminMapper adminDao;
    @Override
    public PageInfo<admin> queryAdminInfoAll(admin admin, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<admin> list= adminDao.queryAdminInfoAll(admin);
        PageInfo pageInfo=new PageInfo(list);

        return pageInfo;
    }

    @Override
    public int addAdminSubmit(admin admin) {
        return adminDao.insert(admin);
    }

    @Override
    public int updateAdminSubmit(admin admin) {
        return adminDao.updateByPrimaryKey(admin);
    }

    @Override
    public int deleteAdminByIds(List<String> ids) {
        int num=0;
        for (String id:ids){
            int i=0;
           num+=adminDao.deleteByPrimaryKey(Integer.valueOf(id));
        }
        return num;
    }

    @Override
    public admin queryAdminById(Integer id) {
        return adminDao.selectByPrimaryKey(id);
    }
}
