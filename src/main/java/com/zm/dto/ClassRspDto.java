package com.zm.dto;

import com.zm.entity.Class;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author: liyangbin
 * @Desc: 班级信息表返回Dto
 * @Date: Created in 16:14:41 2020年7月14日
 * @Modified By:
 */
@Data
@ApiModel(value = "班级信息表返回Dto")
public class ClassRspDto extends Class {
    /**
     * 教师编号
     */
    private Integer teacherId;
    /**
     * 教师姓名
     */
    private String teacherName;
}
