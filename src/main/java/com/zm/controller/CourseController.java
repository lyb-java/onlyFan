package com.zm.controller;

import com.zm.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 课程安排信息表(Course)表控制层
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@RestController
@RequestMapping("/onlyfan/course")
public class CourseController {
    private final Logger logger = LoggerFactory.getLogger(CourseController.class);
    /**
     * 服务对象
     */
    @Resource
    private CourseService courseService;

}
