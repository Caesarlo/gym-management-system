package com.gym.controller;

import com.github.pagehelper.PageInfo;
import com.gym.entity.Course;
import com.gym.entity.Result;
import com.gym.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 课程信息控制层
 * @create: 2022-11-27 14:17
 **/
@Controller
@ResponseBody
public class CourseController {

    private CourseServiceImpl courseServiceImpl;

    @Autowired
    public CourseController(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }

    @GetMapping("/")
    public Result<PageInfo<Course>> getCourseByPage(@PathVariable("startPage") Integer startPage,
                                                    @PathVariable("pageSize")Integer pageSize){
        return courseServiceImpl.getCourseByPage(startPage,pageSize);
    }
}
