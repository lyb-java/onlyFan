package com.zm.dto;

import com.zm.entity.Course;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author: liyangbin
 * @Desc: 成绩信息表响应Dto
 * @Date: Created in 16:14:41 2020年7月14日
 * @Modified By:
 */
@Data
@ApiModel(value = "成绩信息表响应Dto")
public class CourseRspDto extends Course {

}
