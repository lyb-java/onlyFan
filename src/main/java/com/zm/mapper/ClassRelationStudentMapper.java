package com.zm.mapper;

import com.zm.entity.ClassRelationStudent;
import org.apache.ibatis.annotations.Param;

/**
 * @author Machenike
 */
public interface ClassRelationStudentMapper {
    int insert(ClassRelationStudent record);

    int insertSelective(ClassRelationStudent record);

    Integer updateByStudentId(ClassRelationStudent classRelationStudent);

    Integer getByClassId(@Param("classId") Integer classId);

    Integer deleteByStudentId(@Param("studentId") Integer studentId);
}
