package com.zm.service;

import com.zm.entity.Student;
import java.util.List;

/**
 * 学生信息表(Student)表服务接口
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
public interface StudentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(Integer id);

    /**
     * 新增数据
     *
     * @param Student 实例对象
     * @return 实例对象
     */
    Student insert(Student Student);

    /**
     * 修改数据
     *
     * @param Student 实例对象
     * @return 实例对象
     */
    Student update(Student Student);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
