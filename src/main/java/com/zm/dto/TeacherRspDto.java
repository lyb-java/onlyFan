package com.zm.dto;

import com.zm.entity.Teacher;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author: liyangbin
 * @Desc: 教师信息表响应Dto
 * @Date: Created in 16:14:41 2020年7月14日
 * @Modified By:
 */
@Data
@ApiModel(value = "教师信息表响应Dto")
public class TeacherRspDto extends Teacher {
    /**
     * 班级编号
     */
    private Integer classId;
    /**
     * 班级名称
     */
    private String className;
}
