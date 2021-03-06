package com.dzb.service;

import com.dzb.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/9 20:55
 */
public interface UserService {

    public List<User> findUserList(String keywords, Integer userListRoleId);
    public User findUser(String loginName,String password);
    public User getUserByUserId(Integer userId);
    public User getUserByLoginName(String loginName);
    public int editUser(User user);
    public int addUser(User user);
    public int delUser(Integer userId);
    public int setUserStatus(User user);
}
