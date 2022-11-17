package com.gym.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.web.servlet.HandlerInterceptor;
import com.gym.util.JwUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 拦截器 验证有没有携带token
 * @create: 2022-11-16 17:01
 **/
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从请求头的Authorization拿到token
        String token = request.getParameter("Authorization");
        response.setContentType("application/json;charset=UTF-8");
        try {
            //验证token
            JwUtil.verify(token);
            return true;
        } catch (TokenExpiredException e) {
            response.sendError(401, "Token过期！！！");
        } catch (SignatureVerificationException e) {
            response.sendError(401, "签名错误！！！");
        } catch (AlgorithmMismatchException e) {
            response.sendError(401, "解密错误！！！");
        } catch (Exception e) {
            response.sendError(401, "token无效");
        }
        return false;
    }
}
