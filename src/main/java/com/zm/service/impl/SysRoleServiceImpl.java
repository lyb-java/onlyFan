package com.zm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zm.common.Constant;
import com.zm.dto.*;
import com.zm.entity.SysRole;
import com.zm.entity.SysUser;
import com.zm.entity.SysUserRole;
import com.zm.exception.BusinessException;
import com.zm.exception.ValidateException;
import com.zm.mapper.SysRoleMapper;
import com.zm.mapper.SysUserMapper;
import com.zm.mapper.SysUserRoleMapper;
import com.zm.service.SysRoleService;
import com.zm.service.SysUserService;
import com.zm.util.DateUtils;
import com.zm.util.JwtUtil;
import com.zm.util.Md5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 系统角色实现类
 * @author liyangbin
 * @date 2019-1-13
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    SysRoleMapper sysRoleMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addRole(RoleReqDto reqDto) throws Exception {
        SysRole role = new SysRole();
        //复制相同字段 拷贝
        BeanUtils.copyProperties(reqDto,role);

        Long time = DateUtils.getCurrentTimes();
        //设置创建时间，修改时间
        role.setCreateTime(time);
        role.setUpdateTime(time);
        role.setIsDelete("0");

        return sysRoleMapper.insert(role);
    }

    @Override
    public PageInfo<RoleRspDto>  getAllPage(PageViewDto<RoleReqDto> pageViewDto) throws Exception {
        //分页参数
        Page<RoleRspDto> page = PageHelper.startPage(pageViewDto.getPageIndex(), pageViewDto.getPageSize());
        //查询列表数据
        List<RoleRspDto> rspDtos = sysRoleMapper.getAllPage(pageViewDto.getCondition());

        PageInfo  pageInfo = page.toPageInfo();
        pageInfo.setTotal(rspDtos.size());
        pageInfo.setList(rspDtos);
        return pageInfo;
    }

    @Override
    public RoleRspDto getDetail(Integer id) throws Exception {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer editRole(RoleReqDto reqDto) throws Exception {
        return sysRoleMapper.updateByPrimaryKeySelective(reqDto);
    }

    @Override
    public Integer delete(Integer id) throws Exception {
        return sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SysRole> getOption() throws Exception {
        List<SysRole> roleRspDtos = sysRoleMapper.getAllOption();
        return roleRspDtos;
    }
}
