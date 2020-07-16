package com.zm.mapper;

import com.zm.dto.ClassReqDto;
import com.zm.entity.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Machenike
 */
public interface ClassMapper {
    int deleteByPrimaryKey(@Param("classId") Integer classId);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(@Param("classId") Integer classId);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);

    List<Class> getAllPage(ClassReqDto condition);

    List<Class> getAllOption();
}
