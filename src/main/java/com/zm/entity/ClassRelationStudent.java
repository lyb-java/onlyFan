package com.zm.entity;

import java.io.Serializable;

/**
 * 班级关联学生信息表(ClassRelationStudent)实体类
 *
 * @author liyangbin
 * @since 2020-07-15 15:45:31
 */
public class ClassRelationStudent implements Serializable {
    private static final long serialVersionUID = 277377297987863537L;
    /**
    * 班级编号
    */
    private Integer classId;
    /**
    * 学生编号
    */
    private Integer studentId;
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


    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

}
