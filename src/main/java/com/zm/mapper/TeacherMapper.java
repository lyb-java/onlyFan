package com.zm.mapper;

import com.zm.dto.TeacherReqDto;
import com.zm.dto.TeacherRspDto;
import com.zm.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(@Param("teacherId") Integer teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    TeacherRspDto selectByPrimaryKey(@Param("teacherId") Integer teacherId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<Teacher> getAllPage(TeacherReqDto condition);

    List<Teacher> getAllOption();
}
