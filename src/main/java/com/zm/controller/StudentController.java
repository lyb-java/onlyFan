package com.zm.controller;

import com.zm.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 学生信息表(Student)表控制层
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@RestController
@RequestMapping("/onlyfan/student")
public class StudentController {
    private final Logger logger = LoggerFactory.getLogger(StudentController.class);
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;


}
