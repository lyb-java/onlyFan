package com.zm.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zm.common.Constant;
import com.zm.dto.*;
import com.zm.entity.*;
import com.zm.exception.BusinessException;
import com.zm.exception.ValidateException;
import com.zm.mapper.*;
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
 * 系统用户实现类
 * @author liyangbin
 * @date 2019-1-13
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private StudentMapper studentMapper;
    @Override
    public UserSeachRspDto login(SysUser sysUser) throws Exception {
        //md5加密
        sysUser.setPassword(Md5Util.md5(sysUser.getPassword()));
        UserSeachRspDto user = sysUserMapper.selectByUser(sysUser);
        if(user==null){
            throw new ValidateException("账号或密码错误，请重试！");
        }
//        是否有效（0否，1是）
        if(Constant.IS_ENABLE_NO.equals(sysUser.getIsEnable())){
            throw new ValidateException("账号已失效，请联系管理员！");
        }
        //查询教师信息
//        teacherMapper.selectByPrimaryKey();
        //查询学生信息
        Integer userId =user.getUserId();
        String jsonUser = JSON.toJSONString(user);
        //生成token
        String token="";
        //这里调用创建JWT信息的方法
        token = JwtUtil.createToken(jsonUser,userId);
        //token 用户唯一标识
        user.setToken(token);
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addUser(UserAddReqDto reqDto) throws Exception {
        SysUser user = new SysUser();
        //复制相同字段 拷贝
        BeanUtils.copyProperties(reqDto,user);
        //md5加密
        user.setPassword(Md5Util.md5(user.getPassword()));
        UserSeachRspDto rspDto = sysUserMapper.selectByAccount(user);
        if(Objects.nonNull(rspDto)){
            throw new BusinessException("账号已存在，不可重复添加！");
        }
        Long time = DateUtils.getCurrentTimes();
        //设置创建时间，修改时间
        user.setCreateTime(time);
        user.setUpdateTime(time);
        user.setIsDelete("0");
        Integer result = sysUserMapper.insert(user);
        //系统角色
        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(user.getUserId());
        userRole.setRoleId(reqDto.getRoleId());
        //设置创建时间，修改时间
        userRole.setCreateTime(time);
        userRole.setUpdateTime(time);

        result += sysUserRoleMapper.insert(userRole);

        //用户关联教师
        if(reqDto.getTeacherId() !=null &&  reqDto.getTeacherId() > 0){
            Teacher teacher = new Teacher();
            teacher.setTeacherId(reqDto.getTeacherId());
            teacher.setUserId(user.getUserId());
            result +=teacherMapper.updateByPrimaryKeySelective(teacher);
        }
        //学生
        if(reqDto.getStudentId() !=null && reqDto.getStudentId() > 0){
            Student student = new Student();
            student.setStudentId(reqDto.getStudentId());
            student.setUserId(user.getUserId());
            result +=studentMapper.updateByPrimaryKeySelective(student);
        }

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

    @Override
    public UserRspDto getUserDetail(Integer id) throws Exception {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer editUser(UserReqDto reqDto) throws Exception {
        //获取角色名称
//        SysRole role = sysRoleMapper.selectByPrimaryKey(reqDto.getRoleId());
//        reqDto.setRoleName(role.getRoleName());
        reqDto.setPassword(Md5Util.md5(reqDto.getPassword()));
        sysUserMapper.updateByPrimaryKeySelective(reqDto);
        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(reqDto.getUserId());
        userRole.setRoleId(reqDto.getRoleId());
        userRole.setUpdateTime(DateUtils.getCurrentTimes());
        sysUserRoleMapper.updateByPrimaryKeySelective(userRole);
        return 0;
    }

    @Override
    public Integer deleteUser(Integer id) throws Exception {
        return sysUserMapper.deleteByPrimaryKey(id);
    }
}
