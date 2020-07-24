package com.zm.service;

import com.github.pagehelper.PageInfo;
import com.zm.auth.AccountDetailsDto;
import com.zm.dto.PageViewDto;
import com.zm.dto.TeacherReqDto;
import com.zm.dto.TeacherRspDto;
import com.zm.entity.Teacher;
import com.zm.exception.ValidateException;

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
    TeacherRspDto queryById(Integer id);

    /**
     * 新增数据
     * @param userInfo
     * @param reqDto 实例对象
     * @return 影响行数
     */
    Integer insert(TeacherReqDto reqDto, AccountDetailsDto userInfo) throws Exception;

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 影响行数
     */
    Integer update(Teacher teacher) throws ValidateException;

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Integer deleteById(Integer id) throws ValidateException;

    /**
     * 查询后台分页列表
     *
     * @param pageViewDto  查询条件
     * @return PageInfo<Teacher> 分页列表对象
     */
    PageInfo<Teacher> getAllPage(PageViewDto<TeacherReqDto> pageViewDto);
    /**
     * 查询后台下拉列表
     *
     * @return List<Teacher> 分页列表对象
     */
    List<Teacher> getAllOption();

    List<Teacher> getOptionNoUserId();
}
