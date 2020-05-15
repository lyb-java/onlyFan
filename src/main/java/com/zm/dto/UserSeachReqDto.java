package com.zm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: liyangbin
 * @Desc: 用户信息列表查询请求Dto
 * @Date: Created in 11:14:41 2020年3月8日
 * @Modified By:
 */
@ApiModel(value = "用户信息列表查询请求Dto")
public class UserSeachReqDto {

    @ApiModelProperty(value = "账户名称")
    private String account;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "是否有效（0否，1是）")
    private String isEnable;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

}
