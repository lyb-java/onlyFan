package com.zm.controller;

import com.github.pagehelper.PageInfo;
import com.zm.common.*;
import com.zm.dto.*;
import com.zm.entity.SysUser;
import com.zm.exception.ValidateException;
import com.zm.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 系统用户接口
 * @author liyangbin
 * @date 2019-1-13
 */
@Api(tags = "系统用户管理-李杨彬")
@RestController
@RequestMapping("/onlyfan/index")
public class SysUserController {
    private final  Logger logger = LoggerFactory.getLogger(SysUserController.class);
    @Resource
    SysUserService sysUserService;
    /**
     * 用户登陆操作
     *
     * @param user
     * @return ZMResult
     */
    @ApiOperation(value = "登录入口")
    @ApiImplicitParam(name = "SysUser", value = "用户对象", required = true)
    @PostMapping("/login")
    public ZMResult<UserSeachRspDto> login(@RequestBody SysUser user) {
        try {
            // 账号或者密码不能为空否则就提示错误信息
            if (StringUtils.isBlank(user.getAccount()) || StringUtils.isBlank(user.getPassword())) {
               throw new ValidateException("账号或密码不能为空！");
            }
            UserSeachRspDto rspDto = sysUserService.login(user);

            return new ZMResult<>(Message.SUCCESS,rspDto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ZMResult<>(e);
        }

    }
    /**
     * 新增后台用户
     *
     * @param reqDto
     * @return ZMResult
     */
    @ApiOperation(value = "新增后台用户")
    @ApiImplicitParam(name = "UserAddReqDto", value = "用户添加实体", required = true)
    @PostMapping("/adduser")
    public ZMResult<Integer>  addUser(@Valid @RequestBody UserAddReqDto reqDto) {
        try {
            Integer result = sysUserService.addUser(reqDto);
            return new ZMResult<> (Message.SUCCESS,result);
        } catch (Exception e) {
            e.printStackTrace();
            return new ZMResult<> (e);
        }

    }
    /**
     * 查询后台用户列表
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "查询后台用户列表")
    @PostMapping("/getuserall")
    public ZMResult<PageViewRspDto<List<UserSeachRspDto>>> getUserAllPage(@RequestBody  PageViewDto<UserSeachReqDto> pageViewDto) {
        try {
            ZMResult<PageViewRspDto<List<UserSeachRspDto>>> zmResult = new ZMResult<>(Message.SUCCESS);
            //获取分页数据
            PageInfo<UserSeachRspDto> pageInfo = sysUserService.getUserAllPage(pageViewDto);
            zmResult.setData(new PageViewRspDto<>(pageInfo.getList(), pageInfo.getTotal()));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
    /**
     * 查询后台用户详情
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "查询后台用户详情")
    @PostMapping("/getusedetail")
    public ZMResult<UserRspDto> getDetail(@RequestParam("id") Integer id) {
        try {
            ZMResult<UserRspDto> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(sysUserService.getUserDetail(id));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
    /**
     * 用户修改
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "用户修改")
    @PostMapping("/edituser")
    public ZMResult<Integer> editUser(@RequestBody UserReqDto reqDto) {
        try {
            ZMResult<Integer> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(sysUserService.editUser(reqDto));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
    /**
     * 用户删除
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "用户修改")
    @PostMapping("/deluser")
    public ZMResult<Integer> delUser(@RequestParam("id") Integer id) {
        try {
            ZMResult<Integer> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(sysUserService.deleteUser(id));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
}
