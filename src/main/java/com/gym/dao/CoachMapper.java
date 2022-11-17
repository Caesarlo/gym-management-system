package com.gym.dao;

import com.gym.entity.Coach;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 教练接口层
 * @create: 2022-11-17 11:30
 **/
@Mapper
public interface CoachMapper {

    /**
     * 根据id查询教练
     *
     * @param id
     * @return
     */
    Coach getCoachById(String id);

    /**
     * 查询所有教练
     *
     * @return
     */
    List<Coach> getAllCoaches();

    /**
     * 根据关键字模拟查询教练信息
     *
     * @param keyword
     * @return
     */
    List<Coach> getCoachByVague(String keyword);

    /**
     * 查询所有教练数量
     *
     * @return 教练数量
     */
    Integer getAllCoachesNumber();


    /**
     * 注册教练
     *
     * @param coach
     */
    void insertCoach(Coach coach);


    /**
     * 注销教练信息
     *
     * @param id
     */
    void deleteCoach(String id);

    /**
     * 更新教练消息
     *
     * @param coach
     */
    void updateCoach(Coach coach);
}
