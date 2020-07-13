package com.zm.controller;

import com.github.pagehelper.PageInfo;
import com.zm.common.Message;
import com.zm.common.ZMResult;
import com.zm.dto.*;
import com.zm.entity.SysUser;
import com.zm.exception.ValidateException;
import com.zm.service.SysRoleService;
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
 * 系统用户角色接口
 * @author liyangbin
 * @date 2020-7-13
 */
@Api(tags = "角色管理-李杨彬")
@RestController
@RequestMapping("/onlyfan/sysrole")
public class SysRoleController {
    private final  Logger logger = LoggerFactory.getLogger(SysRoleController.class);
    @Resource
    SysRoleService sysRoleService;
    /**
     * 新增后台角色
     *
     * @param reqDto
     * @return ZMResult
     */
    @ApiOperation(value = "新增后台角色")
    @ApiImplicitParam(name = "RoleReqDto", value = "角色添加实体", required = true)
    @PostMapping("/add")
    public ZMResult<Integer> addRole(@Valid @RequestBody RoleReqDto reqDto) {
        try {
            Integer result = sysRoleService.addRole(reqDto);
            return new ZMResult<>(Message.SUCCESS,result);
        } catch (Exception e) {
            e.printStackTrace();
            return new ZMResult<>(e);
        }

    }
    /**
     * 查询后台角色列表
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "查询后台角色列表")
    @PostMapping("/getall")
    public ZMResult<PageViewRspDto<List<RoleRspDto>>> getAllPage(@RequestBody  PageViewDto<RoleReqDto> pageViewDto) {
        try {
            ZMResult<PageViewRspDto<List<RoleRspDto>>> zmResult = new ZMResult<>(Message.SUCCESS);
            //获取分页数据
            PageInfo<RoleRspDto> pageInfo = sysRoleService.getAllPage(pageViewDto);
            zmResult.setData(new PageViewRspDto<>(pageInfo.getList(), pageInfo.getTotal()));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
    /**
     * 查询后台角色详情
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "查询后台角色详情")
    @PostMapping("/getdetail")
    public ZMResult<RoleRspDto> getDetail(@RequestParam("id") Integer id) {
        try {
            ZMResult<RoleRspDto> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(sysRoleService.getDetail(id));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
    /**
     * 角色修改
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "角色修改")
    @PostMapping("/edit")
    public ZMResult<Integer> editUser(@RequestBody RoleReqDto reqDto) {
        try {
            ZMResult<Integer> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(sysRoleService.editRole(reqDto));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
    /**
     * 角色删除
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "角色修改")
    @PostMapping("/delete")
    public ZMResult<Integer> delRole(@RequestParam("id") Integer id) {
        try {
            ZMResult<Integer> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(sysRoleService.delete(id));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
}
