package com.zm.dto;

import com.zm.entity.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @Author: liyangbin
 * @Desc: 用户信息列表查询响应Dto
 * @Date: Created in 11:14:41 2020年3月8日
 * @Modified By:
 */
@Data
@ApiModel(value = "用户信息列表查询响应Dto")
public class UserSeachRspDto extends SysUser {

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色权限代码")
    private String access;

    @ApiModelProperty(value = "token-用户唯一标识")
    private String token;

    @ApiModelProperty(value = "教师编号")
    private Integer teacherId;

    @ApiModelProperty(value = "学生编号")
    private Integer studentId;
}

