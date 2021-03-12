package com.dzb.dao;

import com.dzb.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/9 20:48
 */
public interface RoleDao {
    //查询所有角色
    public List<Role> selectRoleList();
}
