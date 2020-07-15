package com.zm.service.impl;

import com.zm.entity.Course;
import com.zm.mapper.CourseMapper;
import com.zm.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程安排信息表(ZmCourse)表服务实现类
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@Service("CourseService")
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Course queryById(Integer id) {
        return this.courseMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Override
    public Course insert(Course course) {
        this.courseMapper.insert(course);
        return course;
    }

    /**
     * 修改数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Override
    public Course update(Course course) {
        this.courseMapper.updateByPrimaryKey(course);
        return this.queryById(course.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.courseMapper.deleteByPrimaryKey(id) > 0;
    }
}
