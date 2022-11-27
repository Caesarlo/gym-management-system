package com.gym.service;

import com.github.pagehelper.PageInfo;
import com.gym.entity.Coach;
import com.gym.entity.Result;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 教练业务
 * @create: 2022-11-20 16:32
 **/
public interface CoachService {

    /**
     * 教练分页查询信息
     *
     * @param startPage 起始页码
     * @param pageSize  页码大小
     * @return 教练集合
     */
    Result<PageInfo<Coach>> getCoachByPage(Integer startPage, Integer pageSize);


    /**
     * 关键字模糊分页查询
     *
     * @param startPage 起始页码
     * @param pageSize  页码容量
     * @param keyword   关键字
     * @return 教练集合
     */
    Result<PageInfo<Coach>> getCoachByVague(Integer startPage, Integer pageSize, String keyword);

    /**
     * 根据id查询教练信息
     *
     * @param id 教练id
     * @return 教练信息
     */
    Result<Coach> getCoachById(String id);

    /**
     * 新增教练信息
     * @param coach 教练信息
     * @return
     */
    Result insertCoach(Coach coach);

    /**
     * 更新教练信息
     * @param coach 教练信息
     * @return
     */
    Result updateCoach(Coach coach);

    /**
     * 删除教练信息
     * @param id
     * @return
     */
    Result deleteCoach(String id);



}
