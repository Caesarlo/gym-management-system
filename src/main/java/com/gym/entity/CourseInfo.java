package com.gym.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 课程信息实体类
 * @create: 2022-11-17 13:21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseInfo implements Serializable {
    //课程号 自增
    @NotNull(message = "课程号为空！")
    private String courseId;

    //课程名称
    @NotNull(message = "课程名为空！")
    private String courseName;

    //课程教练
    @NotNull(message = "课程教练为空！")
    private String courseCoach;

    //上课时间
    private Date courseTime;

    //班容量
    private Integer courseCount;

    //已报人数
    private Integer courseAlready;

    //发布时间
    private Timestamp courseData;

}
