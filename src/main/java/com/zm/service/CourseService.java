package com.zm.service;

import com.zm.entity.Course;
import java.util.List;

/**
 * 课程安排信息表(Course)表服务接口
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
public interface CourseService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Course queryById(Integer id);

    /**
     * 新增数据
     *
     * @param Course 实例对象
     * @return 实例对象
     */
    Course insert(Course Course);

    /**
     * 修改数据
     *
     * @param Course 实例对象
     * @return 实例对象
     */
    Course update(Course Course);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
