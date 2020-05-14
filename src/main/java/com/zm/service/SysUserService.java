package com.zm.service;

import com.zm.dto.UserAddReqDto;
import com.zm.entity.SysUser;

/**
 * 系统用户接口
 * @author liyangbin
 * @date 2019-1-13
 */

public interface SysUserService {
    /**
     * 系统用户接口
     * @param sysUser  登陆信息
     * @return String token
     * @throws Exception
     */
    String login(SysUser sysUser) throws Exception ;
    /**
     * 新增系统用户接口
     * @param reqDto  新增用户实体dto
     * @return String token
     * @throws Exception
     */
    Integer addUser(UserAddReqDto reqDto);
}
