package com.zm.dto;

import com.zm.entity.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: liyangbin
 * @Desc: 用户信息请求Dto
 * @Date: Created in 11:14:41 2020年3月8日
 * @Modified By:
 */
@Data
@ApiModel(value = "用户信息请求Dto")
public class UserReqDto extends SysUser {
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色编号")
    private Integer roleId;
}
