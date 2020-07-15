package com.zm.mapper;
import com.zm.dto.ClassReqDto;
import com.zm.entity.Class;

import java.util.List;

/**
 * @author Machenike
 */
public interface ClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);

    List<Class> getAllPage(ClassReqDto condition);
}
