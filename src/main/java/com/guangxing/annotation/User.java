package com.guangxing.annotation;

import org.springframework.stereotype.Component;

/**
 * 测试自定义直接类
 *
 * @author Guangxing
 * @create time 2020/3/29 13:22
 **/
@Component

public class User {
    private String name;
    private int age;

    @TestAnnotation(name = "小明",age = 23)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
