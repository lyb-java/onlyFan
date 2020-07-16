package com.zm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 成绩信息表(Achievement)实体类
 *
 * @author liyangbin
 * @since 2020-07-15 15:45:31
 */
@Data
public class Achievement implements Serializable {
    private static final long serialVersionUID = 412244063861621507L;
    /**
    * 主键编号
    */
    private Integer achievementId;
    /**
    * 学生编号
    */
    private Integer studentId;
    /**
    * 学生姓名
    */
    private String studentName;
    /**
    * 考试科目名称
    */
    private String subjectName;
    /**
    * 考试成绩
    */
    private Double points;
    /**
    * 考试开始时间
    */
    private Long startTime;
    /**
    * 考试结束时间
    */
    private Long endTime;
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
