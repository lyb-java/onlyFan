package com.zm.service;

import com.github.pagehelper.PageInfo;
import com.zm.auth.AccountDetailsDto;
import com.zm.dto.CourseReqDto;
import com.zm.dto.PageViewDto;
import com.zm.dto.StudentReqDto;
import com.zm.entity.Course;
import com.zm.entity.Student;
import com.zm.exception.ValidateException;

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
     * @param userInfo
     * @param reqDto 实例对象
     * @return 影响行数
     */
    Integer insert(StudentReqDto reqDto, AccountDetailsDto userInfo) throws Exception;

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    Integer update(Student student) throws ValidateException;

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Integer deleteById(Integer id);

    /**
     * 查询后台分页列表
     *
     * @param pageViewDto  查询条件
     * @return PageInfo<Student> 分页列表对象
     */
    PageInfo<Student> getAllPage(PageViewDto<StudentReqDto> pageViewDto);
    /**
     * 查询后台下拉列表
     *
     * @param
     * @return List<Student> 列表对象
     */
    List<Student> getAllOption();
}
