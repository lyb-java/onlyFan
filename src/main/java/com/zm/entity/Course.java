package com.zm.entity;

import java.io.Serializable;

/**
 * 课程安排信息表(Course)实体类
 *
 * @author liyangbin
 * @since 2020-07-15 15:45:31
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 452725972130500671L;
    /**
    * 主键编号
    */
    private Integer id;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public String getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(String isEffective) {
        this.isEffective = isEffective;
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
