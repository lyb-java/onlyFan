package com.zm.service;

import com.zm.entity.Teacher;
import java.util.List;

/**
 * 教师信息表(Teacher)表服务接口
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
public interface TeacherService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Teacher queryById(Integer id);

    /**
     * 新增数据
     *
     * @param Teacher 实例对象
     * @return 实例对象
     */
    Teacher insert(Teacher Teacher);

    /**
     * 修改数据
     *
     * @param Teacher 实例对象
     * @return 实例对象
     */
    Teacher update(Teacher Teacher);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
