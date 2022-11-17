package com.gym.entity;

import java.io.Serializable;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 通用返回实体类
 * @create: 2022-11-16 21:48
 **/
public class Result<T> implements Serializable {

    //状态码
    private int code;

    //消息
    private String msg;

    //数据
    private T data;

    //成功
    public final static int OK = 200;

    //参数格式错误
    public final static int PARAMETER_ERROR = 400;

    //认证
    public final static int NOT_ALLOWED = 401;

    public final static int BAD_REQUEST = 400;

    //错误
    public final static int ERROR = 500;


    public Result() {

    }

    public Result(int code, String msg) {
        this(code, msg, null);
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
