package com.zm.mapper;

import com.zm.dto.UserRspDto;
import com.zm.dto.UserSeachReqDto;
import com.zm.dto.UserSeachRspDto;
import com.zm.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liyangbin
 */
@Repository
public interface SysUserMapper {
    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    UserRspDto selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /***
     * 查询单个用户
     * @param sysUser 条件
     * @return SysUser  返回实体
     * @throws Exception 异常处理
     */
    UserSeachRspDto selectByUser(SysUser sysUser) throws Exception;

    /***
     * 查询单个用户
     * @param reqDto 条件
     * @return UserSeachRspDto  返回实体
     * @throws Exception 异常处理
     */
    List<UserSeachRspDto> getUserAllPage(@Param("condition") UserSeachReqDto reqDto) throws Exception;
}
