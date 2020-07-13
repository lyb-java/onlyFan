package com.zm.mapper;

import com.zm.dto.RoleReqDto;
import com.zm.dto.RoleRspDto;
import com.zm.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    RoleRspDto selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<RoleRspDto> getAllPage(RoleReqDto condition);
}
