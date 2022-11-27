package com.gym.service;

import com.gym.dao.MemberMapper;
import com.gym.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description:
 * @create: 2022-11-26 15:45
 **/
@Service
public class SignInService implements Constant {

    @Autowired
    MemberMapper memberMapper;


}
