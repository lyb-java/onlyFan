package com.zm.mapper;

import com.zm.auth.AccountDetailsDto;
import com.zm.dto.ClassReqDto;
import com.zm.dto.ClassRspDto;
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

    ClassRspDto selectByPrimaryKey(@Param("classId") Integer classId);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);

    List<ClassRspDto> getAllPage(@Param("condition") ClassReqDto condition, @Param("userInfo") AccountDetailsDto userInfo);

    List<Class> getAllOption();
}
