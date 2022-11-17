package com.gym.dao;

import com.gym.entity.CourseCoach;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description:
 * @create: 2022-11-17 11:37
 **/
public interface CourseCoachMapper {

    /**
     * 查询所有课程-教练关系
     *
     * @return
     */
    List<CourseCoach> getAllCourseCoach();

    /**
     * 根据教练id，name模糊查询
     *
     * @param coachKey
     * @return
     */
    List<CourseCoach> selectByCoach(String coachKey);

    /**
     * 根据课程（id，name）模糊查
     *
     * @param courseKey
     * @return
     */
    List<CourseCoach> selectByCourse(String courseKey);

    CourseCoach selectOne(@Param("courseId") int courseId, @Param("coachId") int coachId);

    /**
     * 实体类属性是两个引用，所以这里参数不是对象
     *
     * @param courseId
     * @param coachId
     */
    void insertCourseCoach(@Param("courseId") int courseId, @Param("coachId") int coachId);


    /**
     * 两个字段共同作为主键，两个参数才能确定一条记录
     * @param courseId
     * @param coachId
     */
    void deleteCourseCoach(@Param("courseId") int courseId, @Param("coachId") int coachId);

}
