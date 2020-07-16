package com.zm.mapper;

import com.zm.dto.CourseReqDto;
import com.zm.entity.Course;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> getAllPage(CourseReqDto condition);
}
