package com.zm.service;

import com.github.pagehelper.PageInfo;
import com.zm.dto.*;

import java.util.List;

/**
 * 系统角色接口
 * @author liyangbin
 * @date 2020-7-13
 */

public interface SysRoleService {
    /**
     * 新增系统角色接口
     * @param reqDto  新增角色实体dto
     * @return Integer 影响行数
     * @throws Exception
     */
    Integer addRole(RoleReqDto reqDto) throws Exception;

    /**
     * 查询系统角色列表分页接口
     * @param pageViewDto
     * @return List<RoleRspDto>
     * @throws Exception
     */
    PageInfo<RoleRspDto> getAllPage(PageViewDto<RoleReqDto> pageViewDto) throws Exception;
    /**
     * 系统角色详情接口
     * @param id
     * @return UserRspDto
     * @throws Exception
     */
    RoleRspDto getDetail(Integer id) throws Exception;
    /**
     * 编辑系统角色接口
     * @param reqDto
     * @return Integer
     * @throws Exception
     */
    Integer editRole(RoleReqDto reqDto) throws Exception;
    /**
     * 删除系统角色接口
     * @param id
     * @return Integer
     * @throws Exception
     */
    Integer delete(Integer id) throws Exception;
    /**
     * 查询后台角色下拉列表
     * @return List<RoleRspDto>
     * @throws Exception
     */
    List<RoleRspDto> getOption() throws Exception;
}
