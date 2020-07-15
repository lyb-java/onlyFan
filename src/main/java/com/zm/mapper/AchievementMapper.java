package com.zm.mapper;

import com.zm.dto.AchievementReqDto;
import com.zm.entity.Achievement;

import java.util.List;

public interface AchievementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Achievement record);

    int insertSelective(Achievement record);

    Achievement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Achievement record);

    int updateByPrimaryKey(Achievement record);

    List<Achievement> getAllPage(AchievementReqDto condition);
}
