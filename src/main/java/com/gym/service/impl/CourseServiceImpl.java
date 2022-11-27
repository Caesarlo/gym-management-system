package com.gym.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.dao.CourseMapper;
import com.gym.entity.Course;
import com.gym.entity.Result;
import com.gym.exception.PageNumberException;
import com.gym.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 课程业务类实现
 * @create: 2022-11-27 11:08
 **/
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private CourseMapper courseMapper;

    @Autowired
    public CourseServiceImpl(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public Result<PageInfo<Course>> getCourseByPage(Integer startPage, Integer pageSize) {
        if (startPage<1){
            throw new PageNumberException("起始页码无效");
        }
        Page<Course> courses= PageHelper.startPage(startPage,pageSize);
        List<Course> allCourse=courseMapper.getAllCourse();
        PageInfo<Course> pageInfo=new PageInfo<>(allCourse);
        return new Result<>(Result.OK,"查询成功",pageInfo);
    }

    @Override
    public Result<PageInfo<Course>> getCourseByVague(Integer startPage, Integer pageSize, String keyword) {
        if (startPage<1){
            throw new PageNumberException("起始页码无效");
        }
        Page<Course> courses=PageHelper.startPage(startPage,pageSize);
        List<Course> allCourse=courseMapper.getAllCourseByName(keyword);
        PageInfo<Course> pageInfo=new PageInfo<>(allCourse);
        return new Result<>(Result.OK,"查询成功",pageInfo);
    }

    @Override
    public Result<Course> getCourseById(String id) {
        Course course=courseMapper.getCourseById(id);
        return new Result<Course>(Result.OK,"查询成功",course);
    }

    @Override
    public Result insertCourse(Course course) {
        courseMapper.insertCourse(course);
        return new Result(Result.OK,"添加成功");
    }

    @Override
    public Result updateCourse(Course course) {
        courseMapper.updateCourse(course);
        return new Result(Result.OK,"修改成功");
    }

    @Override
    public Result deleteCourse(String id) {
        courseMapper.deleteCourse(id);
        return new Result(Result.OK,"删除成功");
    }
}
