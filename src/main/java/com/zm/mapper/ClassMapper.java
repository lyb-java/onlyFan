package com.zm.mapper;
import com.zm.entity.Class;
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
}
