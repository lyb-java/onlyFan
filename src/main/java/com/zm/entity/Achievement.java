package com.zm.entity;

import java.io.Serializable;

/**
 * 成绩信息表(Achievement)实体类
 *
 * @author liyangbin
 * @since 2020-07-15 15:45:31
 */
public class Achievement implements Serializable {
    private static final long serialVersionUID = 412244063861621507L;
    /**
    * 主键编号
    */
    private Integer id;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
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
