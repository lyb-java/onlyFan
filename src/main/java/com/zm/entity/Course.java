package com.zm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 课程安排信息表(Course)实体类
 *
 * @author liyangbin
 * @since 2020-07-15 15:45:31
 */
@Data
public class Course implements Serializable {
    private static final long serialVersionUID = 452725972130500671L;
    /**
    * 主键编号
    */
    private Integer courseId;
    /**
    * 班级编号
    */
    private Integer classId;
    /**
    * 班级名称
    */
    private String className;
    /**
    * 教师编号
    */
    private Integer teacherId;
    /**
    * 教师姓名
    */
    private String teacherName;
    /**
    * 课程名称
    */
    private String courseName;
    /**
    * 上课开始时间
    */
    private Long startTime;
    /**
    * 上课结束时间
    */
    private Long endTime;
    /**
    * 是否有效(0否 1是)
    */
    private String isEffective;
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
