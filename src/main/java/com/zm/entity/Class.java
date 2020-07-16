package com.zm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 班级信息表(Class)实体类
 *
 * @author liyangbin
 * @since 2020-07-15 15:45:31
 */
@Data
public class Class implements Serializable {
    private static final long serialVersionUID = -41667160946358716L;
    /**
    * 主键编号
    */
    private Integer classId;
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


}
