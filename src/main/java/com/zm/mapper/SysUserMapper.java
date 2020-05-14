package com.zm.mapper;

import com.zm.entity.SysUser;
import org.springframework.stereotype.Repository;

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
    SysUser selectByUser(SysUser sysUser) throws Exception;
}
