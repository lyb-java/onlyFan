package com.zm.controller;

import com.github.pagehelper.PageInfo;
import com.zm.common.Message;
import com.zm.common.ZMResult;
import com.zm.dto.CourseReqDto;
import com.zm.dto.PageViewDto;
import com.zm.dto.PageViewRspDto;
import com.zm.entity.Course;
import com.zm.service.CourseService;
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
 * 课程安排信息表(Course)表控制层
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@Api(tags = "课程安排信息管理-李杨彬")
@RestController
@RequestMapping("/onlyfan/course")
public class CourseController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(CourseController.class);
    /**
     * 服务对象
     */
    @Resource
    private CourseService courseService;
    /**
     * 新增
     *
     * @param reqDto
     * @return ZMResult
     */
    @ApiOperation(value = "新增")
    @ApiImplicitParam(name = "CourseReqDto", value = "请求dto", required = true)
    @PostMapping("/add")
    public ZMResult<Integer> add(@Valid @RequestBody CourseReqDto reqDto) {
        try {
            Integer result = courseService.insert(reqDto,super.getUserInfo());
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
    public ZMResult<PageViewRspDto<List<Course>>> getAllPage(@RequestBody PageViewDto<CourseReqDto> pageViewDto) {
        try {
            ZMResult<PageViewRspDto<List<Course>>> zmResult = new ZMResult<>(Message.SUCCESS);
            //获取分页数据
            PageInfo<Course> pageInfo = courseService.getAllPage(pageViewDto);
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
    public ZMResult<Course> getDetail(@RequestParam("courseId") Integer courseId) {
        try {
            ZMResult<Course> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(courseService.queryById(courseId));
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
    public ZMResult<Integer> edit(@RequestBody Course reqDto) {
        try {
            ZMResult<Integer> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(courseService.update(reqDto));
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
    public ZMResult<Integer> delRole(@RequestParam("courseId") Integer courseId) {
        try {
            ZMResult<Integer> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(courseService.deleteById(courseId));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
}
