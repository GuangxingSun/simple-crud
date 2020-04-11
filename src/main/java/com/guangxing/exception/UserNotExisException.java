package com.guangxing.exception;

/**
 * 自定义异常类
 *
 * @author Guangxing
 * @create time 2020/4/11 22:34
 **/
public class UserNotExisException extends RuntimeException{
    public UserNotExisException() {
        super("用户不存在！");
    }
}
