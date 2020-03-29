package com.guangxing.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解测试
 *
 * @author Guangxing
 * @create time 2020/3/29 13:06
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {
    String name() default "小明";
    int age() default 22;
}
