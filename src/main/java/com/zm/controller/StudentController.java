package com.zm.controller;

import com.github.pagehelper.PageInfo;
import com.zm.common.Message;
import com.zm.common.ZMResult;
import com.zm.dto.PageViewDto;
import com.zm.dto.PageViewRspDto;
import com.zm.dto.StudentReqDto;
import com.zm.entity.Student;
import com.zm.service.StudentService;
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
 * 学生信息表(Student)表控制层
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@Api(tags = "学生信息管理-李杨彬")
@RestController
@RequestMapping("/onlyfan/student")
public class StudentController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(StudentController.class);
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 新增
     *
     * @param reqDto
     * @return ZMResult
     */
    @ApiOperation(value = "新增")
    @ApiImplicitParam(name = "StudentReqDto", value = "请求dto", required = true)
    @PostMapping("/add")
    public ZMResult<Integer> add(@Valid @RequestBody StudentReqDto reqDto) {
        try {
            Integer result = studentService.insert(reqDto,super.getUserInfo());
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
    public ZMResult<PageViewRspDto<List<Student>>> getAllPage(@RequestBody PageViewDto<StudentReqDto> pageViewDto) {
        try {
            ZMResult<PageViewRspDto<List<Student>>> zmResult = new ZMResult<>(Message.SUCCESS);
            //获取分页数据
            PageInfo<Student> pageInfo = studentService.getAllPage(pageViewDto);
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
    public ZMResult<Student> getDetail(@RequestParam("studentId") Integer studentId) {
        try {
            ZMResult<Student> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(studentService.queryById(studentId));
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
    public ZMResult<Integer> edit(@RequestBody Student reqDto) {
        try {
            ZMResult<Integer> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(studentService.update(reqDto));
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
    public ZMResult<Integer> delRole(@RequestParam("studentId") Integer studentId) {
        try {
            ZMResult<Integer> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(studentService.deleteById(studentId));
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
    public ZMResult<List<Student>> getAllOption() {
        try {
            ZMResult<List<Student>> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(studentService.getAllOption());
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
}
