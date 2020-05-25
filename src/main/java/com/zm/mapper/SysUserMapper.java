package com.zm.mapper;

import com.zm.dto.UserSeachReqDto;
import com.zm.dto.UserSeachRspDto;
import com.zm.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

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
    List<UserSeachRspDto> getUserAllPage(UserSeachReqDto reqDto) throws Exception;
}
