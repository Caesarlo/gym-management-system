package com.gym.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.dao.CourseCoachMapper;
import com.gym.entity.CourseCoach;
import com.gym.entity.Result;
import com.gym.exception.PageNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description:
 * @create: 2022-11-26 08:20
 **/
public class CourseCoachService {

    @Autowired
    CourseCoachMapper courseCoachMapper;

    @Transactional
    public Result<PageInfo<CourseCoach>> getAllCourseCoach(int offset, int limit) {
        if (offset < 1) {
            throw new PageNumberException("起始页码无效！");
        }
        Result<PageInfo<CourseCoach>> result = new Result<>();
        PageHelper.startPage(offset, limit);
        List<CourseCoach> courseCoachList = courseCoachMapper.getAllCourseCoach();
        PageInfo<CourseCoach> pageInfo = new PageInfo<>(courseCoachList);
        result.setCode(Result.OK);
        result.setMsg("课程-教练关系 查询成功");
        result.setData(pageInfo);
        return result;
    }

    @Transactional
    public Result<PageInfo<CourseCoach>> selectByCoach(int offset,int limit,String coachKey){
        if (offset < 1) {
            throw new PageNumberException("起始页码无效！");
        }
        Result<PageInfo<CourseCoach>> result = new Result<>();
        PageHelper.startPage(offset,limit);
        List<CourseCoach> courseCoachList=courseCoachMapper.selectByCoach(coachKey);
        PageInfo<CourseCoach> pageInfo = new PageInfo<>(courseCoachList);
        result.setCode(Result.OK);
        result.setMsg("根据教练模糊查询成功");
        result.setData(pageInfo);
        return  result;
    }

    @Transactional
    public Result<PageInfo<CourseCoach>> selectByCourse(int offset,int limit, String courseKey){
        if (offset < 1) {
            throw new PageNumberException("起始页码无效！");
        }
        Result<PageInfo<CourseCoach>> result = new Result<>();
        PageHelper.startPage(offset, limit);
        List<CourseCoach> courseCoachList=courseCoachMapper.selectByCourse(courseKey);
        PageInfo<CourseCoach> pageInfo = new PageInfo<>(courseCoachList);
        result.setCode(Result.OK);
        result.setMsg("根据课程 模糊查询成功");
        result.setData(pageInfo);
        return result;
    }

    @Transactional
    public Result<?> insertCourseCoach(int courseId,int coachId){
        Result<?> result=new Result<>();
        courseCoachMapper.insertCourseCoach(courseId,coachId);
        result.setCode(Result.OK);
        result.setMsg("添加 课程-教练关系 成功");
        return result;
    }

    public Result<?> deleteCourseCoach(int courseId,int coachId){
        Result<?> result=new Result<>();
        CourseCoach courseCoach =courseCoachMapper.selectOne(courseId,coachId);
        if (courseCoach==null){
            courseCoachMapper.deleteCourseCoach(courseId,coachId);
            result.setCode(Result.OK);
            result.setMsg("删除课程-教练关系成功");
        }else {
            result.setCode(Result.BAD_REQUEST);
            result.setMsg("该教练已任职该课程");
        }

        return result;
    }


}
