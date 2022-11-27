package com.gym.controller;

import com.google.code.kaptcha.Producer;
import com.gym.entity.Result;
import com.gym.service.UserService_temp;
import com.gym.util.JwUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description:
 * @create: 2022-11-27 09:44
 **/
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    //验证码生成
    private Producer producer;


    @Autowired
    private UserService_temp userService;

    @RequestMapping(path = "/api/captche", method = RequestMethod.GET)
    @ResponseBody
    public Result<String> getCaptcha(HttpSession session) {
        Result<String> result = new Result<>();
        //获取四位字符串
        String text = producer.createText();
        //生成图片
        BufferedImage image = producer.createImage(text);
        //验证码存入session
        session.setAttribute("captcha", text);
        String base64Image;
        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", stream);
            base64Image = "data:image/png;base64," + Base64Utils.encodeToString(stream.toByteArray());
            //Base64Utils是Spring提供的工具类
        } catch (IOException e) {
            logger.error("响应验证码失败" + e.getMessage());
            result.setCode(Result.ERROR);
            result.setMsg("验证码生成失败");
            return result;
        }
        result.setCode(Result.OK);
        result.setMsg("验证码生成成功");
        result.setData(base64Image);
        return result;
    }

    /**
     * 登录方法
     *
     * @param map
     * @param session
     * @return
     */
    @RequestMapping(path = "/api/login", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Result<String> login(@RequestBody Map<String, String> map, HttpSession session) {
        Result<String> result = new Result<>();
        //取得生成的验证码
        String captcha = (String) session.getAttribute("captcha");

        if (StringUtils.isBlank(captcha) || StringUtils.isBlank(map.get("code")) || !captcha.equalsIgnoreCase(map.get("code"))) {
            result.setCode(Result.ERROR);
            result.setMsg("验证码错误");
            return result;
        }
        result = userService.login(map.get("username"), map.get("password"));
        return result;
    }

    /**
     * 这个是处理验证token的方法
     * 因为token验证已经由过滤器做过了
     * 我就只要返回用户信息
     *
     * @param token
     * @return
     */
    @GetMapping(path = "/api/currentUser")
    @ResponseBody
    public Result<Map<String, String>> verifyToken(@RequestHeader("Authorization") String token) {
        Result<Map<String, String>> result = new Result<>();
        //获取token里的用户信息
        result = JwUtil.getPayloadInfo(token);
        return result;
    }

}
