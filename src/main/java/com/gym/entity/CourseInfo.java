package com.gym.entity;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 课程信息实体类
 * @create: 2022-11-17 13:21
 **/
public class CourseInfo implements Serializable {
    //课程号
    private String courseId;

    //课程名称
    @NotNull(message = "课程名为空！")
    private String courseName;

    //课程教练
    @NotNull(message = "课程教练为空！")
    private String course_coach;

    //

    //
}
