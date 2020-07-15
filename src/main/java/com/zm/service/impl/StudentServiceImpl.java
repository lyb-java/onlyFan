package com.zm.service.impl;

import com.zm.entity.Student;
import com.zm.mapper.StudentMapper;
import com.zm.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学生信息表(Student)表服务实现类
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@Service("StudentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(Integer id) {
        return this.studentMapper.selectByPrimaryKey(id);
    }


    /**
     * 新增数据
     *
     * @param Student 实例对象
     * @return 实例对象
     */
    @Override
    public Student insert(Student Student) {
        this.studentMapper.insert(Student);
        return Student;
    }

    /**
     * 修改数据
     *
     * @param Student 实例对象
     * @return 实例对象
     */
    @Override
    public Student update(Student Student) {
        this.studentMapper.updateByPrimaryKey(Student);
        return this.queryById(Student.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.studentMapper.deleteByPrimaryKey(id) > 0;
    }
}
