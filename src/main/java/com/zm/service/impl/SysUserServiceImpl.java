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
import com.zm.mapper.SysUserMapper;
import com.zm.service.SysUserService;
import com.zm.util.DateUtils;
import com.zm.util.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 系统用户实现类
 * @author liyangbin
 * @date 2019-1-13
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Override
    public UserSeachRspDto login(SysUser sysUser) throws Exception {
        UserSeachRspDto user = sysUserMapper.selectByUser(sysUser);
        if(user==null){
            throw new Exception("账号不存在，请联系管理员李霞！");
        }
//        是否有效（0否，1是）
        if(Constant.IS_ENABLE_NO.equals(sysUser.getIsEnable())){
            throw new Exception("账号已失效，请联系管理员李霞！");
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
    public Integer addUser(UserAddReqDto reqDto) {
        SysUser user = new SysUser();
        //复制相同字段 拷贝
        BeanUtils.copyProperties(reqDto,user);
        //设置创建时间，修改时间
        user.setCreateTime(DateUtils.getCurrentTimes());
        user.setUpdateTime(DateUtils.getCurrentTimes());

        Integer result = sysUserMapper.insert(user);
        return result;
    }

    @Override
    public PageInfo<UserSeachRspDto>  getUserAllPage(PageViewDto<UserSeachReqDto> pageViewDto) throws Exception {
        //分页参数
        Page<UserSeachRspDto> pageInfo = PageHelper.startPage(pageViewDto.getPageIndex(), pageViewDto.getPageSize());
        //查询条件
        UserSeachReqDto reqDto = pageViewDto.getCondition();
        //查询列表数据
        sysUserMapper.getUserAllPage(reqDto);
        return pageInfo.toPageInfo();
    }
}
