package com.zm.controller;

import com.zm.common.*;
import com.zm.dto.UserAddReqDto;
import com.zm.entity.SysUser;
import com.zm.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 系统用户接口
 * @author liyangbin
 * @date 2019-1-13
 */
@Api(tags = "系统登录-李杨彬")
@RestController
@RequestMapping("/index")
public class SysUserController {
    @Autowired
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
    public ZMResult login(@RequestBody SysUser user) {
        try {
            // 账号或者密码不能为空否则就提示错误信息
            if (StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPassword())) {
               throw new Exception("用户名或密码不能为空！");
            }
            String token = sysUserService.login(user);

            return new ZMResult(Message.SUCCESS_CODE,token);
        } catch (Exception e) {
            e.printStackTrace();
            return new ZMResult(e);
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
    public ZMResult addUser(@Valid @RequestBody UserAddReqDto reqDto) {
        try {
            Integer result = sysUserService.addUser(reqDto);
            return new ZMResult(Message.SUCCESS_CODE,result);
        } catch (Exception e) {
            e.printStackTrace();
            return new ZMResult(e);
        }

    }
}
