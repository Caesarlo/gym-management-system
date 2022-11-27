package com.gym.service;


import com.gym.dao.UserMapper;
import com.gym.entity.Result;
import com.gym.entity.User_temp;
import com.gym.util.Constant;
import com.gym.util.JwUtil;
import com.gym.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description:
 * @create: 2022-11-26 09:57
 **/
@Service
public class UserService_temp implements Constant {

    @Autowired
    UserMapper userMapper;

    public Map<String, Object> register(User_temp user) {
        Map<String, Object> map = new HashMap<>();

        //空值处理
        if (user == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        if (StringUtils.isBlank(user.getUserName())) {
            map.put("UsernameMsg", "用户名不能为控股！");
            return map;
        }
        if (StringUtils.isBlank(user.getPassWord())) {
            map.put("passwordMsg", "密码不能为空！");
            return map;
        }
        if (user.getRole() != MEMBER_TYPE && user.getRole() != MANAGER_TYPE) {
            map.put("emailMsg", "用户类型为空或不正确");
            return map;
        }

        //验证账号是否存在
        User_temp checkUser = userMapper.selectByName(user.getUserName());
        if (checkUser != null) {
            map.put("usernameMsg", "该账号已存在");
            return map;
        }

        //注册用户
        // 多加一个字段（签名）为了防止MD5被字典反向破解
        user.setPassWord(Util.getMD5((user.getPassWord()) + PASSWORD_APPEND));
        userMapper.insertUser(user);

        return map;
    }

    /**
     * 登录服务层
     *
     * @param username
     * @param password
     * @return
     */
    public Result<String> login(String username, String password) {
        Result<String> result = new Result<>();
        if (StringUtils.isBlank(username)) {
            result.setCode(Result.ERROR);
            result.setMsg("用户名不能为空！");
            return result;
        }
        if (StringUtils.isBlank(password)) {
            result.setCode(Result.ERROR);
            result.setMsg("密码不能为空！");
            return result;
        }
        User_temp user = userMapper.selectByName(username);
        if (user == null) {
            result.setCode(Result.ERROR);
            result.setMsg("用户名不能为空！");
            return result;
        }

        //验证密码
        password = Util.getMD5(password + PASSWORD_APPEND);
        if (!user.getPassWord().equals(password)) {
            result.setCode(Result.ERROR);
            result.setMsg("密码不正确!");
            return result;
        }

        //生成Token
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("username", user.getUserName());
        //role原本是int,这里转String
        tokenMap.put("role", user.getRole() + "");
        String token = JwUtil.getToken(tokenMap);

        result.setCode(Result.OK);
        result.setMsg("登录成功!");
        result.setData(token);

        return result;
    }
}
