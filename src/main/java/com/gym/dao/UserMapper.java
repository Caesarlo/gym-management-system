package com.gym.dao;

import com.gym.entity.User_temp;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 用户持久层
 * @create: 2022-11-19 13:35
 **/
@Mapper
public interface UserMapper {

    /**
     * 通过id查用户
     * @param id
     * @return
     */
    User_temp selectById(int id);

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    User_temp selectByName(String username);


    /**
     * 插入用户
     * 这里因为密码是被加密后存储到数据库的，所以还不能直接操作数据库插
     * @param user
     */
    void insertUser(User_temp user);
}
