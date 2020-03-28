package com.guangxing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/**
 * hello Controller
 * @author Guangxing
 * @create time 2020/3/24 22:01
 **/
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好!</h1>");

        map.put("users", Arrays.asList("小花","小明","小草"));
        return "success";
    }
}
