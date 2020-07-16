package com.zm.mapper;

import com.zm.dto.TeacherReqDto;
import com.zm.entity.Teacher;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<Teacher> getAllPage(TeacherReqDto condition);

    List<Teacher> getAllOption();
}
