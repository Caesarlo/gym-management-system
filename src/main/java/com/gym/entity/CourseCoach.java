package com.gym.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 教练课程关系表实体
 * @create: 2022-11-17 13:19
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseCoach {

    /**
     * 教练引用
     */

    private Integer coachId;

    /**
     * 课程引用
     */
    private Integer courseId;
}
