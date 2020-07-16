package com.zm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 系统角色表(ZmSysRole)实体类
 *
 * @author makejava
 * @since 2020-05-14 16:49:19
 */
@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = 115674081493699983L;
    /**
    * 主键id
    */
    private Integer roleId;
    /**
    * 角色名称
    */
    private String roleName;
    /**
     * 角色权限代码
     */
    private String access;
    /**
    * 修改时间
    */
    private Long updateTime;
    /**
    * 创建时间
    */
    private Long createTime;

    /**
     * 是否删除（0否,1是）
     */
    private String isDelete;

}
