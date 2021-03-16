package com.dzb.service.impl;

import com.dzb.dao.RoleDao;
import com.dzb.domain.Role;
import com.dzb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/9 20:57
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    //注入RoleDao
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findRoleList() {
        List<Role> roleList=roleDao.selectRoleList();
        return roleList;
    }

    @Override
    public Role findRoleWithUsersByRoleId(Integer roleId) {
        return null;
//        return roleDao.selectRoleList();  //TODO
//        return null;
    }
}
