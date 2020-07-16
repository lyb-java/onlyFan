package com.zm.controller;

import com.github.pagehelper.PageInfo;
import com.zm.common.Message;
import com.zm.common.ZMResult;
import com.zm.dto.ClassReqDto;
import com.zm.dto.PageViewDto;
import com.zm.dto.PageViewRspDto;
import com.zm.entity.Class;
import com.zm.service.ClassService;
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
 * 班级信息表(Class)表控制层
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@Api(tags = "班级信息管理-李杨彬")
@RestController
@RequestMapping("/onlyfan/class")
public class ClassController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(ClassController.class);
    /**
     * 服务对象
     */
    @Resource
    private ClassService classService;
    /**
     * 新增
     *
     * @param reqDto
     * @return ZMResult
     */
    @ApiOperation(value = "新增")
    @ApiImplicitParam(name = "ClassReqDto", value = "请求dto", required = true)
    @PostMapping("/add")
    public ZMResult<Integer> add(@Valid @RequestBody ClassReqDto reqDto) {
        try {
            Integer result = classService.insert(reqDto,super.getUserInfo());
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
    public ZMResult<PageViewRspDto<List<Class>>> getAllPage(@RequestBody PageViewDto<ClassReqDto> pageViewDto) {
        try {
            ZMResult<PageViewRspDto<List<Class>>> zmResult = new ZMResult<>(Message.SUCCESS);
            //获取分页数据
            PageInfo<Class> pageInfo = classService.getAllPage(pageViewDto);
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
    public ZMResult<Class> getDetail(@RequestParam("classId") Integer classId) {
        try {
            ZMResult<Class> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(classService.queryById(classId));
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
    public ZMResult<Integer> edit(@RequestBody Class reqDto) {
        try {
            ZMResult<Integer> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(classService.update(reqDto));
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
    public ZMResult<Integer> delRole(@RequestParam("classId") Integer classId) {
        try {
            ZMResult<Integer> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(classService.deleteById(classId));
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
    public ZMResult<List<Class>> getAllOption() {
        try {
            ZMResult<List<Class>> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(classService.getAllOption());
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
}
