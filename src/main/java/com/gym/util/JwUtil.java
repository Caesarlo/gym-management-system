package com.gym.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gym.entity.Result;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: jwt工具类
 * @create: 2022-11-16 17:12
 **/
public class JwUtil {
    /**
     * 签名
     */
    private static String signature = "caesar_gump@163.com";

    /**
     * 生成token
     *
     * @param map 传入payload
     * @return 返回token
     */
    public static String getToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        Calendar instance = Calendar.getInstance();
        //token 有效时间30分钟
        instance.add(Calendar.MINUTE, 30);
        builder.withExpiresAt(instance.getTime());
        return builder.sign(Algorithm.HMAC256(signature));
    }

    /**
     * 获取token中payload
     * 不用验证只需要取信息就可以
     * @param token
     * @return
     */
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(signature)).build().verify(token);
    }

    public static Result<Map<String,String>> getPayloadInfo(String token){
        Result<Map<String,String>> result = new Result<>();
        Map<String,String> map = new HashMap<>();
        DecodedJWT decodedJWT = JWT.decode(token);

        map.put("username",decodedJWT.getClaim("username").asString());
        map.put("type",decodedJWT.getClaim("type").asString());
        result.setData(map);

        result.setCode(Result.OK);
        result.setMsg("用户验证成功");
        return result;
    }
}
