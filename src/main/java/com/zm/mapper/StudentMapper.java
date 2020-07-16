package com.zm.mapper;

import com.zm.dto.StudentReqDto;
import com.zm.entity.Student;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> getAllPage(StudentReqDto condition);

    List<Student> getAllOption();
}
