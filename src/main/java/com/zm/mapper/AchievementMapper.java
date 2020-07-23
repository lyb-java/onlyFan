package com.zm.mapper;

import com.zm.auth.AccountDetailsDto;
import com.zm.dto.AchievementReqDto;
import com.zm.entity.Achievement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Machenike
 */
public interface AchievementMapper {
    int deleteByPrimaryKey(@Param("achievementId") Integer achievementId);

    int insert(Achievement record);

    int insertSelective(Achievement record);

    Achievement selectByPrimaryKey(@Param("achievementId") Integer achievementId);

    int updateByPrimaryKeySelective(Achievement record);

    int updateByPrimaryKey(Achievement record);

    List<Achievement> getAllPage(@Param("condition") AchievementReqDto condition, @Param("userInfo") AccountDetailsDto userInfo);
}
