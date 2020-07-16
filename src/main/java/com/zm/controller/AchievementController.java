package com.zm.controller;

import com.github.pagehelper.PageInfo;
import com.zm.common.Message;
import com.zm.common.ZMResult;
import com.zm.dto.*;
import com.zm.entity.Achievement;
import com.zm.service.AchievementService;
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
 * 成绩信息表(Achievement)表控制层
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:33
 */
@Api(tags = "学生成绩管理-李杨彬")
@RestController
@RequestMapping("/onlyfan/achievement")
public class AchievementController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(AchievementController.class);
    /**
     * 服务对象
     */
    @Resource
    private AchievementService achievementService;
    /**
     * 新增成绩信息
     *
     * @param reqDto
     * @return ZMResult
     */
    @ApiOperation(value = "新增成绩信息")
    @ApiImplicitParam(name = "AchievementReqDto", value = "新增成绩信息", required = true)
    @PostMapping("/add")
    public ZMResult<Integer> add(@Valid @RequestBody AchievementReqDto reqDto) {
        try {
            Integer result = achievementService.insert(reqDto,super.getUserInfo());
            return new ZMResult<>(Message.SUCCESS,result);
        } catch (Exception e) {
            e.printStackTrace();
            return new ZMResult<>(e);
        }

    }
    /**
     * 查询后台学生成绩列表
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "查询后台学生成绩列表")
    @PostMapping("/getallpage")
    public ZMResult<PageViewRspDto<List<Achievement>>> getAllPage(@RequestBody PageViewDto<AchievementReqDto> pageViewDto) {
        try {
            ZMResult<PageViewRspDto<List<Achievement>>> zmResult = new ZMResult<>(Message.SUCCESS);
            //获取分页数据
            PageInfo<Achievement> pageInfo = achievementService.getAllPage(pageViewDto);
            zmResult.setData(new PageViewRspDto<>(pageInfo.getList(), pageInfo.getTotal()));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
    /**
     * 查询后台学生成绩详情
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "查询后台学生成绩详情")
    @PostMapping("/getdetail")
    public ZMResult<Achievement> getDetail(@RequestParam("achievementId") Integer achievementId) {
        try {
            ZMResult<Achievement> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(achievementService.queryById(achievementId));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
    /**
     * 后台学生成绩修改
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "后台学生成绩修改")
    @PostMapping("/edit")
    public ZMResult<Integer> edit(@RequestBody Achievement reqDto) {
        try {
            ZMResult<Integer> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(achievementService.update(reqDto));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }
    /**
     * 后台学生成绩删除
     *
     * @param
     * @return ZMResult
     */
    @ApiOperation(value = "学生成绩删除")
    @PostMapping("/delete")
    public ZMResult<Integer> delRole(@RequestParam("achievementId") Integer achievementId) {
        try {
            ZMResult<Integer> zmResult = new ZMResult<>(Message.SUCCESS);
            zmResult.setData(achievementService.deleteById(achievementId));
            return zmResult;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ZMResult<>(e);
        }

    }

}
