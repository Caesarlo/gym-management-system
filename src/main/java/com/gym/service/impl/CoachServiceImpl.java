package com.gym.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.dao.CoachMapper;
import com.gym.entity.Coach;
import com.gym.entity.Result;
import com.gym.exception.PageNumberException;
import com.gym.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 教练业务类实现
 * @create: 2022-11-27 10:33
 **/
@Service
@Transactional
public class CoachServiceImpl implements CoachService {

    private CoachMapper coachMapper;

    @Autowired
    public CoachServiceImpl(CoachMapper coachMapper) {
        this.coachMapper = coachMapper;
    }

    @Override
    public Result<PageInfo<Coach>> getCoachByPage(Integer startPage, Integer pageSize) {
        if (startPage<1){
            throw new PageNumberException("起始页码必须大于等于1！");
        }
        Page<Coach> coaches= PageHelper.startPage(startPage,pageSize);
        List<Coach> allCoaches=coachMapper.getAllCoaches();
        PageInfo<Coach> pageInfo=new PageInfo<>(allCoaches);
        return new Result<PageInfo<Coach>>(Result.OK,"查询成功",pageInfo);
    }

    @Override
    public Result<PageInfo<Coach>> getCoachByVague(Integer startPage, Integer pageSize, String keyword) {
        if (startPage<1){
            throw new PageNumberException("起始页码必须大于等于1");
        }
        Page<Coach> coaches=PageHelper.startPage(startPage,pageSize);
        List<Coach> allCoaches=coachMapper.getCoachByVague(keyword);
        PageInfo<Coach> pageInfo=new PageInfo<>(allCoaches);
        return new Result<PageInfo<Coach>>(Result.OK,"查询成功",pageInfo);
    }

    @Override
    public Result<Coach> getCoachById(String id) {
        Coach coach=coachMapper.getCoachById(id);
        return new Result<Coach>(Result.OK,"查询chengg",coach);
    }

    @Override
    public Result insertCoach(Coach coach) {
        coachMapper.insertCoach(coach);
        return new Result(Result.OK,"新增成功");
    }

    @Override
    public Result updateCoach(Coach coach) {
        coachMapper.updateCoach(coach);
        return new Result(Result.OK,"修改成功");
    }

    @Override
    public Result deleteCoach(String id) {
        coachMapper.deleteCoach(id);
        return new Result(Result.OK,"删除成功");
    }
}
