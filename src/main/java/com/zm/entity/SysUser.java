package com.zm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 系统用户表(ZmSysUser)实体类
 *
 * @author makejava
 * @since 2020-05-14 16:49:19
 */
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = -62814893794734563L;
    /**
    * 主键id
    */
    private Integer userId;
    /**
    * 账号
    */
    private String account;
    /**
    * 密码
    */
    private String password;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 是否有效（0否，1是）
    */
    private String isEnable;
    /**
    * 创建时间
    */
    private Long createTime;
    /**
    * 修改时间
    */
    private Long updateTime;
    /**
     * 是否删除（0否,1是）
     */
    private String isDelete;

}
