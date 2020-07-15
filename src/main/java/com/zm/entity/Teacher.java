package com.zm.entity;

import java.io.Serializable;

/**
 * 教师信息表(Teacher)实体类
 *
 * @author liyangbin
 * @since 2020-07-15 15:45:31
 */
public class Teacher implements Serializable {
    private static final long serialVersionUID = 822403702859219191L;
    /**
    * 主键编号
    */
    private Integer id;
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
    private Object birthday;
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
    private Object admissionDate;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Object admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
