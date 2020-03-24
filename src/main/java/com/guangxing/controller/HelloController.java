package com.guangxing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
