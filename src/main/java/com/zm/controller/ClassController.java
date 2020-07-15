package com.zm.controller;

import com.zm.service.ClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 班级信息表(Class)表控制层
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@RestController
@RequestMapping("/onlyfan/class")
public class ClassController {
    private final Logger logger = LoggerFactory.getLogger(ClassController.class);
    /**
     * 服务对象
     */
    @Resource
    private ClassService classService;


}
