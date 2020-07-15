package com.zm.dto;

import com.zm.entity.Achievement;
import com.zm.entity.SysRole;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author: liyangbin
 * @Desc: 成绩信息表请求Dto
 * @Date: Created in 16:14:41 2020年7月14日
 * @Modified By:
 */
@Data
@ApiModel(value = "成绩信息表请求Dto")
public class AchievementReqDto extends Achievement {
    /**
     * 考试开始时间
     */
    private String startingTime;
    /**
     * 考试结束时间
     */
    private String completionTime;
}
