package com.csgo.service;
import com.csgo.dao.userMapper;
import com.csgo.po.user;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private userMapper userDao;

    @Override
    public PageInfo<user> queryUserInfoAll(user user, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<user> list= userDao.queryUserInfoAll(user);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int addUserSubmit(user user) {
        user.setAccount(0.0F);
        return userDao.insert(user);
    }

    @Override
    public int updateUserSubmit(user user) {
        return userDao.updateByPrimaryKey(user);
    }

    @Override
    public int deleteUserByIds(List<String> ids) {
        int num=0;
        for (String id:ids){
            int i=0;
            num+=userDao.deleteByPrimaryKey(Integer.valueOf(id));
        }
        return num;
    }

    @Override
    public user queryUserById(Integer id) {
       return userDao.selectByPrimaryKey(id);
    }

    @Override
    public user queryUserByNameAndPassword(String username, String password) {
        return userDao.queryUserByNameAndPassword(username,password);
    }
}
