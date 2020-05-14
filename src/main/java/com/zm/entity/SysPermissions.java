package com.zm.entity;

import java.io.Serializable;

/**
 * 角色权限表(ZmSysPermissions)实体类
 *
 * @author makejava
 * @since 2020-05-14 16:49:19
 */
public class SysPermissions implements Serializable {
    private static final long serialVersionUID = 526248192201618940L;
    /**
    * 主键id
    */
    private Integer id;
    /**
    * 角色id
    */
    private Integer roleId;
    /**
    * 菜单编号
    */
    private Integer menuId;
    /**
    * 创建时间
    */
    private Long createTime;
    /**
    * 修改时间
    */
    private Long updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

}
