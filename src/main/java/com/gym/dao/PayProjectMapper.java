package com.gym.dao;

import com.gym.entity.PayProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 付费课程持久层
 * @create: 2022-11-20 14:58
 **/
@Mapper
public interface PayProjectMapper {

    /**
     * 查询所有项目
     *
     * @return
     */
    List<PayProject> selectAllPayProject();

    /**
     * 通过id查
     *
     * @param id
     * @return
     */
    PayProject selectById(int id);

    /**
     * 通过项目名称查
     *
     * @param name
     * @return
     */
    PayProject selectByName(String name);

    /**
     * 插入项目
     *
     * @param payProject
     */
    void insertPayProject(PayProject payProject);

    /**
     * 根据id删除项目
     * @param id
     */
    void deletePayProject(int id);

    /**
     *
     * @param payProject
     */
    void updatePayProject(PayProject payProject);

}
