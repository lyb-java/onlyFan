package com.zm.service;

import com.github.pagehelper.PageInfo;
import com.zm.dto.PageViewDto;
import com.zm.dto.UserAddReqDto;
import com.zm.dto.UserSeachReqDto;
import com.zm.dto.UserSeachRspDto;
import com.zm.entity.SysUser;

import javax.validation.ValidationException;
import java.util.List;

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
    UserSeachRspDto login(SysUser sysUser) throws Exception, ValidationException;
    /**
     * 新增系统用户接口
     * @param reqDto  新增用户实体dto
     * @return Integer 影响行数
     * @throws Exception
     */
    Integer addUser(UserAddReqDto reqDto) throws Exception,ValidationException;

    /**
     * 新增系统用户接口
     * @return List<UserSeachRspDto>
     * @throws Exception
     */
    PageInfo<UserSeachRspDto> getUserAllPage(PageViewDto<UserSeachReqDto> pageViewDto) throws Exception;
}
