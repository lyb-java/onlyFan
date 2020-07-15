package com.zm.entity;

import java.io.Serializable;

/**
 * 班级信息表(Class)实体类
 *
 * @author liyangbin
 * @since 2020-07-15 15:45:31
 */
public class Class implements Serializable {
    private static final long serialVersionUID = -41667160946358716L;
    /**
    * 主键编号
    */
    private Integer id;
    /**
    * 班级名称
    */
    private String name;
    /**
    * 班级人数
    */
    private Long classSize;
    /**
    * 是否删除(0否 1是)
    */
    private String isDelete;
    /**
    * 创建时间
    */
    private Long createTime;
    /**
    * 修改时间
    */
    private Long updateTime;
    /**
    * 操作人编号
    */
    private Integer opUserId;
    /**
    * 操作人名称
    */
    private String opUserName;
    /**
    * 操作人角色
    */
    private String opRoleName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClassSize() {
        return classSize;
    }

    public void setClassSize(Long classSize) {
        this.classSize = classSize;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
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

    public Integer getOpUserId() {
        return opUserId;
    }

    public void setOpUserId(Integer opUserId) {
        this.opUserId = opUserId;
    }

    public String getOpUserName() {
        return opUserName;
    }

    public void setOpUserName(String opUserName) {
        this.opUserName = opUserName;
    }

    public String getOpRoleName() {
        return opRoleName;
    }

    public void setOpRoleName(String opRoleName) {
        this.opRoleName = opRoleName;
    }

}
