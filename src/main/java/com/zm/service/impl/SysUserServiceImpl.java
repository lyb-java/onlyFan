package com.zm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zm.common.Constant;
import com.zm.dto.PageViewDto;
import com.zm.dto.UserAddReqDto;
import com.zm.dto.UserSeachReqDto;
import com.zm.dto.UserSeachRspDto;
import com.zm.entity.SysUser;
import com.zm.entity.SysUserRole;
import com.zm.mapper.SysUserMapper;
import com.zm.mapper.SysUserRoleMapper;
import com.zm.service.SysUserService;
import com.zm.util.DateUtils;
import com.zm.util.JwtUtil;
import com.zm.util.Md5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.ValidationException;
import java.util.List;

/**
 * 系统用户实现类
 * @author liyangbin
 * @date 2019-1-13
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    SysUserMapper sysUserMapper;
    @Resource
    SysUserRoleMapper sysUserRoleMapper;
    @Override
    public UserSeachRspDto login(SysUser sysUser) throws Exception {
        //md5加密
        sysUser.setPassword(Md5Util.md5(sysUser.getPassword()));
        UserSeachRspDto user = sysUserMapper.selectByUser(sysUser);
        if(user==null){
            throw new ValidationException("账号不存在，请联系管理员李霞！");
        }
//        是否有效（0否，1是）
        if(Constant.IS_ENABLE_NO.equals(sysUser.getIsEnable())){
            throw new ValidationException("账号已失效，请联系管理员李霞！");
        }
        //生成token
        String token="";
        //这里调用创建JWT信息的方法
        token = JwtUtil.createToken(user.getId());
        //token 用户唯一标识
        user.setToken(token);
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addUser(UserAddReqDto reqDto) throws Exception {
        Long time = DateUtils.getCurrentTimes();
        SysUser user = new SysUser();
        //复制相同字段 拷贝
        BeanUtils.copyProperties(reqDto,user);
        //设置创建时间，修改时间
        user.setCreateTime(time);
        user.setUpdateTime(time);
        //md5加密
        user.setPassword(Md5Util.md5(user.getPassword()));
        Integer result = sysUserMapper.insert(user);
        //系统角色
        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(reqDto.getRoleId());
        //设置创建时间，修改时间
        userRole.setCreateTime(time);
        userRole.setUpdateTime(time);

        result += sysUserRoleMapper.insert(userRole);
        return result;
    }

    @Override
    public PageInfo<UserSeachRspDto>  getUserAllPage(PageViewDto<UserSeachReqDto> pageViewDto) throws Exception {
        //分页参数
        Page<UserSeachRspDto> page = PageHelper.startPage(pageViewDto.getPageIndex(), pageViewDto.getPageSize());
        //查询列表数据
        List<UserSeachRspDto> rspDtos = sysUserMapper.getUserAllPage(pageViewDto.getCondition());

        PageInfo  pageInfo = page.toPageInfo();
        pageInfo.setTotal(rspDtos.size());
        pageInfo.setList(rspDtos);
        return pageInfo;
    }
}
