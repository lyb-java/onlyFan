package com.zm.dto;

import com.zm.entity.SysUser;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author: liyangbin
 * @Desc: 用户信息响应Dto
 * @Date: Created in 11:14:41 2020年3月8日
 * @Modified By:
 */
@Data
@ApiModel(value = "用户信息响应Dto")
public class UserRspDto extends SysUser {
    /**
     * 角色编号
     */
    private Integer roleId;
    /**
     * 角色名称
     */
    private String roleName;
}
