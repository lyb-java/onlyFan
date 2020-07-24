package com.zm.mapper;

import com.zm.dto.StudentReqDto;
import com.zm.dto.StudentRspDto;
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

    StudentRspDto selectByPrimaryKey(@Param("studentId") Integer studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<StudentRspDto> getAllPage(StudentReqDto condition);

    List<Student> getAllOption();

    Student selectByStudent(StudentReqDto reqDto);

    List<Student> getOptionNoUserId();
}
