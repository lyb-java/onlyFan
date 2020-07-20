package com.zm.mapper;

import com.zm.entity.ClassRelationTeacher;
import org.apache.ibatis.annotations.Param;

/**
 * @author Machenike
 */
public interface ClassRelationTeacherMapper {
    int insert(ClassRelationTeacher record);

    int insertSelective(ClassRelationTeacher record);

    Integer updateByClassId(ClassRelationTeacher relationTeacher);

    ClassRelationTeacher selectByTeacherId(@Param("teacherId") Integer teacherId);

}
