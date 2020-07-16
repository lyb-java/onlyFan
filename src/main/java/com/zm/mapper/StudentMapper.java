package com.zm.mapper;

import com.zm.dto.StudentReqDto;
import com.zm.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Machenike
 */
public interface StudentMapper {
    int deleteByPrimaryKey(@Param("studentId") Integer studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(@Param("studentId") Integer studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> getAllPage(StudentReqDto condition);

    List<Student> getAllOption();
}
