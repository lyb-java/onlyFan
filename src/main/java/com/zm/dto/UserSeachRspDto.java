package com.zm.dto;

import com.zm.entity.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @Author: liyangbin
 * @Desc: 用户信息列表查询响应Dto
 * @Date: Created in 11:14:41 2020年3月8日
 * @Modified By:
 */
@ApiModel(value = "用户信息列表查询响应Dto")
public class UserSeachRspDto extends SysUser {

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色权限代码")
    private String access;

    @ApiModelProperty(value = "token-用户唯一标识")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
