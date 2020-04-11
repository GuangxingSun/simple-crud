package com.guangxing.controller;

import com.guangxing.exception.UserNotExisException;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理器
 *
 * @author Guangxing
 * @create time 2020/4/11 22:42
 **/

@ControllerAdvice
public class MyExceptionHandler {
    //1、浏览器客户端返回的都是json,没有在浏览器中自适应
    // @ResponseBody
    // @ExceptionHandler(UserNotExisException.class)
    // public Map<String,Object> handlerException(Exception e){
    //     Map<String,Object> map = new HashMap<>();
    //     map.put("code","user.notexist");
    //     map.put("massage",e.getMessage());
    //     return  map;
    //
    // }

    @ExceptionHandler(UserNotExisException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("massage",e.getMessage());
        map.put("exception", UserNotExisException.class);

        request.setAttribute("ext", map);
         //传入自己的错误码,否则就不会进入指定的错误页面
        request.setAttribute("javax.servlet.error.status_code",500);
             //转发到/error
        return "forward:/error";
    }

}
