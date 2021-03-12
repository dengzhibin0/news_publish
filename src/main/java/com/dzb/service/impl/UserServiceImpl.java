package com.dzb.service.impl;

import com.dzb.dao.UserDao;
import com.dzb.domain.User;
import com.dzb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/9 20:58
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    //注入UserDao
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findUserList(String keywords, Integer userListRoleId) {
        List<User> userList=this.userDao.selectUserList(keywords,userListRoleId);
        return userList;
    }
    @Override
    public User findUser(String loginName, String password) {
        User user=this.userDao.findUser(loginName, password);
        return user;
    }
    @Override
    public User getUserByUserId(Integer userId) {
        return this.userDao.getUserByUserId(userId);
    }
    @Override
    public User getUserByLoginName(String loginName) {
        return this.userDao.getUserByLoginName(loginName);
    }
    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }
    @Override
    public int editUser(User user) {
        return this.userDao.updateUser(user);
    }
    @Override
    public int delUser(Integer userId) {
        return userDao.delUser(userId);
    }
    @Override
    public int setUserStatus(User user) {
        return userDao.setUserStatus(user);
    }
}
