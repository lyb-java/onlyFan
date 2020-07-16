package com.zm.mapper;

import com.zm.dto.RoleReqDto;
import com.zm.dto.RoleRspDto;
import com.zm.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Machenike
 */
public interface SysRoleMapper {
    int deleteByPrimaryKey(@Param("roleId") Integer roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    RoleRspDto selectByPrimaryKey(@Param("roleId") Integer roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<RoleRspDto> getAllPage(RoleReqDto condition);

    List<SysRole> getAllOption();
}
