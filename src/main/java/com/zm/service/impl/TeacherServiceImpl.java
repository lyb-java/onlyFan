package com.zm.service.impl;

import com.zm.entity.Teacher;
import com.zm.mapper.TeacherMapper;
import com.zm.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 教师信息表(Teacher)表服务实现类
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Teacher queryById(Integer id) {
        return this.teacherMapper.selectByPrimaryKey(id);
    }


    /**
     * 新增数据
     *
     * @param Teacher 实例对象
     * @return 实例对象
     */
    @Override
    public Teacher insert(Teacher Teacher) {
        this.teacherMapper.insert(Teacher);
        return Teacher;
    }

    /**
     * 修改数据
     *
     * @param Teacher 实例对象
     * @return 实例对象
     */
    @Override
    public Teacher update(Teacher Teacher) {
        this.teacherMapper.updateByPrimaryKeySelective(Teacher);
        return this.queryById(Teacher.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.teacherMapper.deleteByPrimaryKey(id) > 0;
    }
}
