package com.zm.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 教师信息表(Teacher)实体类
 *
 * @author liyangbin
 * @since 2020-07-15 15:45:31
 */
@Data
public class Teacher implements Serializable {
    private static final long serialVersionUID = 822403702859219191L;
    /**
    * 主键编号
    */
    private Integer teacherId;
    /**
    * 教师工号
    */
    private String teacherNo;
    /**
    * 姓名
    */
    private String name;
    /**
    * 性别(0男 1女)
    */
    private String gender;
    /**
    * 年龄
    */
    private Integer age;
    /**
    * 出生日期
    */
    private Date birthday;
    /**
    * 手机号
    */
    private String phone;
    /**
    * 居住地址
    */
    private String address;
    /**
    * 入校时间
    */
    private Date admissionDate;
    /**
    * 当前状态（0在校 1离校）
    */
    private String state;
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
