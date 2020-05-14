package com.zm.entity;

import java.io.Serializable;

/**
 * 用户角色表(ZmSysUserRole)实体类
 *
 * @author makejava
 * @since 2020-05-14 16:49:19
 */
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = -85069817767275443L;
    /**
    * 主键id
    */
    private Integer id;
    /**
    * 系统用户id
    */
    private Integer userId;
    /**
    * 角色id
    */
    private Integer roleId;
    /**
    * 修改时间
    */
    private Long updateTime;
    /**
    * 创建时间
    */
    private Long createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

}
