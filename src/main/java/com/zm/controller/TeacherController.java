package com.zm.controller;

import com.zm.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 教师信息表(Teacher)表控制层
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@RestController
@RequestMapping("/onlyfan/teacher")
public class TeacherController {
    private final Logger logger = LoggerFactory.getLogger(TeacherController.class);
    /**
     * 服务对象
     */
    @Resource
    private TeacherService teacherService;

}
