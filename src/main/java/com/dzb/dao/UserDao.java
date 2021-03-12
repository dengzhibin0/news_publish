package com.dzb.dao;

import com.dzb.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/9 20:40
 */
public interface UserDao {

    //查询所有用户
    public List<User> selectUserList(@Param("keywords") String keywords, @Param("userListRoleId") Integer userListRoleId);

    // 通过账号和密码查询用户
    public User findUser(@Param("loginName") String loginName, @Param("password") String password);

    // 通过用户id查询用户
    public User getUserByUserId(Integer userId);

    // 通过用户登录名查询用户
    public User getUserByLoginName(String loginName);

    // 添加用户
    public int addUser(User user);

    // 更新用户
    public int updateUser(User user);

    // 删除用户
    public int delUser(Integer userId);

    // 设置用户转态（1：未启用，2：已启用，3：被禁用）
    public int setUserStatus(User user);
}
