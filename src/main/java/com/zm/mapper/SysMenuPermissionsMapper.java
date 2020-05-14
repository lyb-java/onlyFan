package com.zm.mapper;

import com.zm.entity.SysMenuPermissions;

public interface SysMenuPermissionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenuPermissions record);

    int insertSelective(SysMenuPermissions record);

    SysMenuPermissions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenuPermissions record);

    int updateByPrimaryKey(SysMenuPermissions record);
}