package com.zm.entity;

import java.io.Serializable;

/**
 * 菜单权限表(ZmSysMenuPermissions)实体类
 *
 * @author makejava
 * @since 2020-05-14 16:49:19
 */
public class SysMenuPermissions implements Serializable {
    private static final long serialVersionUID = -65426417811118816L;
    /**
    * 主键id
    */
    private Integer id;
    /**
    * 菜单名称
    */
    private String menuName;
    /**
    * 指向地址
    */
    private String url;
    /**
    * 图标
    */
    private String icon;
    /**
    * 是否启用（0否，1是）
    */
    private String state;
    /**
    * 上级id
    */
    private Integer superiorId;
    /**
    * 创建时间
    */
    private Long createTime;
    /**
    * 修改时间
    */
    private Long updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(Integer superiorId) {
        this.superiorId = superiorId;
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
