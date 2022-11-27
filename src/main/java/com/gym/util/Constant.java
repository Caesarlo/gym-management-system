package com.gym.util;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 字段定义
 * @create: 2022-11-26 10:18
 **/
public interface Constant {
    /**
     * 管理员类型
     */
    int MEMBER_TYPE = 1;

    /**
     * 超级管理员
     */
    int MANAGER_TYPE = 2;

    /**
     * 密码MD5加密的额外字段
     */
    String PASSWORD_APPEND = "123456";

    String BEGIN_OF_TEL = "1";

    String BEGIN_OF_MEMBER_CARD = "5";

    int LENGTH_OF_TEL = 11;

}
