package com.zm.service;

import com.zm.entity.Class;
import java.util.List;

/**
 * 班级信息表(Class)表服务接口
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
public interface ClassService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Class queryById(Integer id);

    /**
     * 新增数据
     *
     * @param Class 实例对象
     * @return 实例对象
     */
    Class insert(Class Class);

    /**
     * 修改数据
     *
     * @param Class 实例对象
     * @return 实例对象
     */
    Class update(Class Class);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
