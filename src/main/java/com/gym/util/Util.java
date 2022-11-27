package com.gym.util;

import org.springframework.util.DigestUtils;

import java.util.Calendar;
import java.util.UUID;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description:
 * @create: 2022-11-26 10:22
 **/
public class Util {

    /**
     * 生成随机字符串
     * @return
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取MD5算法加密后的字符
     * @param key
     * @return
     */
    public static String getMD5(String key) {
        if (key == null) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

    /**
     * 更新mask
     * @param date
     * @param mask
     * @return
     */
    public static int updateMask(int date, int mask) {
        mask = mask | (1 << date - 1);
        return mask;
    }

    public static boolean signInOrNot(int mask){
        Calendar calendar=Calendar.getInstance();
        int temp=calendar.get(Calendar.DATE)-1;

        temp=mask&(1<<temp);
        if (temp>0){
            return true;
        }
        return false;
    }
}
