package com.zm.controller;

import com.github.pagehelper.PageInfo;
import com.zm.common.Message;
import com.zm.common.ZMResult;
import com.zm.dto.PageViewDto;
import com.zm.dto.PageViewRspDto;
import com.zm.dto.TeacherReqDto;
import com.zm.dto.TeacherRspDto;
import com.zm.entity.Teacher;
import com.zm.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 教师信息表(Teacher)表控制层
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@Api(tags = "教师信息管理-李杨彬")
@RestController
@RequestMapping("/onlyfan/teacher")
public class TeacherController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(TeacherController.class);
    /**
     * 服务对象
     */
    @Resource
    private TeacherService teacherService;
    /**
     * 新增
     *
     * @param reqDto
     * @return ZMResult
     */
    @ApiOperation(value = "新增")
    @ApiImplicitParam(name = "TeacherReqDto", value = "请求dto", required = true)
    @PostMapping("/add")
    public ZMResult<Integer> add(@Valid @RequestBody TeacherReqDto reqDto) {
        try {
            Integer result = teacherService.insert(reqDto,super.getUserInfo());
            return new ZMResult<>(Message.SUCCESS,result);
        } catch (Exception e) {
            e.printStackTrace();
            return new ZMResult<>(e);
        }

    }
    /**
     * 查询后台列表
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "查询后台列表")
    @PostMapping("/getallpage")
    public ZMResult<PageViewRspDto<List<Teacher>>> getAllPage(@RequestBody PageViewDto<TeacherReqDto> pageViewDto) {
        try {
            ZMResult<PageViewRspDto<List<Teacher>>> zmResult = new ZMResult<>(Message.SUCCESS);
            //获取分页数据
            PageInfo<Teacher> pageInfo = teacherService.getAllPage(pageViewDto);
            zmResult.setData(new PageViewRspDto<>(pageInfo.getList(), pageInfo.getTotal()));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
    /**
     * 查询详情
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "查询详情")
    @PostMapping("/getdetail")
    public ZMResult<TeacherRspDto> getDetail(@RequestParam("teacherId") Integer id) {
        try {
            ZMResult<TeacherRspDto> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(teacherService.queryById(id));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
    /**
     * 修改
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "修改")
    @PostMapping("/edit")
    public ZMResult<Integer> edit(@RequestBody Teacher reqDto) {
        try {
            ZMResult<Integer> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(teacherService.update(reqDto));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
    /**
     * 删除
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    public ZMResult<Integer> delRole(@RequestParam("teacherId") Integer id) {
        try {
            ZMResult<Integer> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(teacherService.deleteById(id));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
    /**
     * 查询下拉列表
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "查询下拉列表")
    @PostMapping("/getalloption")
    public ZMResult<List<Teacher>> getAllOption() {
        try {
            ZMResult<List<Teacher>> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(teacherService.getAllOption());
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
}
