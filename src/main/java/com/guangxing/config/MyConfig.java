package com.guangxing.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 扩展配置类
 *
 * @author Guangxing
 * @create time 2020/3/28 22:34
 **/
@Configuration
public class MyConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //浏览器发送/guangxing  请求来到success
        registry.addViewController("/guangxing").setViewName("success");
    }
}
