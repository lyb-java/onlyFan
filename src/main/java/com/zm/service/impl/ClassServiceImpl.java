package com.zm.service.impl;

import com.zm.entity.Class;
import com.zm.mapper.ClassMapper;
import com.zm.service.ClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 班级信息表(Class)表服务实现类
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@Service("ClassService")
public class ClassServiceImpl implements ClassService {
    @Resource
    private ClassMapper classMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Class queryById(Integer id) {
        return this.classMapper.selectByPrimaryKey(id);
    }


    /**
     * 新增数据
     *
     * @param Class 实例对象
     * @return 实例对象
     */
    @Override
    public Class insert(Class Class) {
        this.classMapper.insert(Class);
        return Class;
    }

    /**
     * 修改数据
     *
     * @param Class 实例对象
     * @return 实例对象
     */
    @Override
    public Class update(Class Class) {
        this.classMapper.updateByPrimaryKey(Class);
        return this.queryById(Class.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.classMapper.deleteByPrimaryKey(id) > 0;
    }
}
