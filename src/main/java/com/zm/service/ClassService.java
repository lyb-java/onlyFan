package com.zm.service;

import com.github.pagehelper.PageInfo;
import com.zm.auth.AccountDetailsDto;
import com.zm.dto.AchievementReqDto;
import com.zm.dto.ClassReqDto;
import com.zm.dto.PageViewDto;
import com.zm.entity.Achievement;
import com.zm.entity.Class;
import com.zm.exception.ValidateException;

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
     * @param userInfo
     * @param reqDto 实例对象
     * @return 影响行数
     */
    Integer insert(ClassReqDto reqDto, AccountDetailsDto userInfo) throws Exception;

    /**
     * 修改数据
     *
     * @param c 实例对象
     * @return 影响行数
     * @exception ValidateException 校验
     */
    Integer update(Class c) throws ValidateException;

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Integer deleteById(Integer id);

    /**
     * 查询后台列表
     *
     * @param pageViewDto  查询条件
     * @return PageInfo<Achievement> 分页列表对象
     */
    PageInfo<Class> getAllPage(PageViewDto<ClassReqDto> pageViewDto);
    /**
     * 查询后台列表
     *
     * @return List<Class> 列表对象
     */
    List<Class> getAllOption();
}
