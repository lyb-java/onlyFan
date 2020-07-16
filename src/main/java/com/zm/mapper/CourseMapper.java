package com.zm.mapper;

import com.zm.dto.CourseReqDto;
import com.zm.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Machenike
 */
public interface CourseMapper {
    int deleteByPrimaryKey(@Param("courseId") Integer courseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(@Param("courseId") Integer courseId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> getAllPage(CourseReqDto condition);
}
