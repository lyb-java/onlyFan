package com.zm.entity;

import java.io.Serializable;

/**
 * 系统角色表(ZmSysRole)实体类
 *
 * @author makejava
 * @since 2020-05-14 16:49:19
 */
public class SysRole implements Serializable {
    private static final long serialVersionUID = 115674081493699983L;
    /**
    * 主键id
    */
    private Integer id;
    /**
    * 角色名称
    */
    private String roleName;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
