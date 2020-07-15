package com.zm.mapper;

import com.zm.entity.ClassRelationStudent;

/**
 * @author Machenike
 */
public interface ClassRelationStudentMapper {
    int insert(ClassRelationStudent record);

    int insertSelective(ClassRelationStudent record);
}
