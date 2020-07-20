package com.zm.dto;

import com.zm.entity.Student;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author: liyangbin
 * @Desc: 学生信息表请求Dto
 * @Date: Created in 16:14:41 2020年7月14日
 * @Modified By:
 */
@Data
@ApiModel(value = "学生信息表请求Dto")
public class StudentReqDto extends Student {
    /**
     * 班级编号
     */
    private Integer classId;
    /**
     * 班级名称
     */
    private String className;
}
