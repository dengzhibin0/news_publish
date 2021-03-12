package com.dzb.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/9 20:50
 */
public class Role implements Serializable {
    private Integer roleId;
    private String roleName;
    private List<User> userList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", userList=" + userList +
                '}';
    }
}
