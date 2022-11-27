package com.gym.service;

import com.github.pagehelper.PageInfo;
import com.gym.entity.Course;
import com.gym.entity.Result;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 课程信息业务层接口
 * @create: 2022-11-26 08:58
 **/
public interface CourseService {

    /**
     * 分页查询课程信息
     *
     * @param startPage 起始页码
     * @param pageSize  页面容量
     * @return 课程信息
     */
    Result<PageInfo<Course>> getCourseByPage(Integer startPage, Integer pageSize);

    /**
     * 模糊分页查询
     *
     * @param startPage 起始页码
     * @param pageSize  页面容量
     * @param keyword   关键字
     * @return 课程信息
     */
    Result<PageInfo<Course>> getCourseByVague(Integer startPage, Integer pageSize, String keyword);

    /**
     * 根据id查询课程信息
     *
     * @param id 课程id
     * @return 课程信息
     */
    Result<Course> getCourseById(String id);

    /**
     * 插入课程信息
     *
     * @param course
     * @return
     */
    Result insertCourse(Course course);

    /**
     * 更新课程信息
     *
     * @param course 课程信息
     * @return
     */
    Result updateCourse(Course course);


    /**
     * 根据id删除课程
     *
     * @param id 课程id
     * @return
     */
    Result deleteCourse(String id);

}
