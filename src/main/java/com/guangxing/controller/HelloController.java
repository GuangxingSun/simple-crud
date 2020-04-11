package com.guangxing.controller;

import com.guangxing.annotation.User;
import com.guangxing.exception.UserNotExisException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    private User user;

    // @RequestMapping({"/","/index.html"})
    // public String index(){
    //     return "index";
    // }

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(@RequestParam("user") String user){
        if(user.equals("aaa")) throw new UserNotExisException();
        return "Hello World!";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>"+user.getName()+"</h1>");

        map.put("users", Arrays.asList("小花","小明","小草"));
        return "success";
    }
}
