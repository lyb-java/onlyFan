package com.zm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @Author: liyangbin
 * @Desc: 用户信息新增Dto
 * @Date: Created in 11:14:41 2020年3月8日
 * @Modified By:
 */
@ApiModel(value = "用户信息新增Dto")
public class UserAddReqDto {
    @NotNull(message = "账户名称不能为空")
    @Size(max = 20,message = "账户名称长度不能超过20")
    @ApiModelProperty(value = "账户名称")
    private String account;

    @NotNull(message = "密码不能为空")
    @Size(max = 50,message = "密码长度不能超过50")
    @ApiModelProperty(value = "密码")
    private String password;

    @NotNull(message = "用户名不能为空")
    @Size(max = 20,message = "用户名长度不能超过20")
    @ApiModelProperty(value = "用户名")
    private String userName;

    @NotNull(message = "是否有效不能为空")
    @Pattern(regexp = "^[0-1]|\\s?$",message = "是否有效的值只能为0和1")
    @ApiModelProperty(value = "是否有效（0否，1是）")
    private String isEnable;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "UserAddReqDto{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", isEnable='" + isEnable + '\'' +
                '}';
    }
}
