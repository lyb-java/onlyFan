package com.zm.dto;

import com.zm.entity.Course;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author: liyangbin
 * @Desc: 课程安排信息表请求Dto
 * @Date: Created in 16:14:41 2020年7月14日
 * @Modified By:
 */
@Data
@ApiModel(value = "课程安排信息表请求Dto")
public class CourseReqDto extends Course {
    /**
     * 上课开始时间
     */
    private String courseStartTime;
    /**
     * 上课结束时间
     */
    private String courseEndTime;
}
