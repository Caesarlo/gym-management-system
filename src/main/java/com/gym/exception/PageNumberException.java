package com.gym.exception;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 查询页面异常类
 * @create: 2022-11-20 15:43
 **/
public class PageNumberException extends RuntimeException {

    private String message;

    public PageNumberException() {
        super();
    }

    public PageNumberException(String message) {
        super(message);
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
