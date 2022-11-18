package com.gym.dao;

import com.gym.entity.CourseInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 课程信息持久层
 * @create: 2022-11-18 15:40
 **/
@Mapper
public interface CourseInfoMapper {

    /**
     * 通过id查询课程信息
     *
     * @param id
     * @return 课程信息
     */
    CourseInfo getCourseInfoById(String id);

    /**
     * 查询所有课程信息
     *
     * @return 课程信息
     */
    List<CourseInfo> getAllCourseInfo();


    /**
     * 根据课程名字模糊查询课程信息
     *
     * @param keyword
     * @return 课程信息
     */
    List<CourseInfo> getAllCourseInfoByName(String keyword);

    /**
     * 新增课程信息
     *
     * @param courseInfo
     */
    void insertCourseInfo(CourseInfo courseInfo);

    /**
     * 更新课程信息
     *
     * @param courseInfo
     */
    void updateCourseInfo(CourseInfo courseInfo);

    /**
     * 根据id删除课程信息
     *
     * @param id
     */
    void deleteCourseInfo(String id);

    /**
     * 查询所有课程信息数量
     *
     * @return 课程信息数量
     */
    Integer getAllCourseInfoNumber();

}
