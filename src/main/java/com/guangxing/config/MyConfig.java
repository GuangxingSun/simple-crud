package com.guangxing.config;

import com.guangxing.component.LoginHandlerInterceptor;
import com.guangxing.component.MylocaleResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 扩展配置类
 * 使用WebMvcConfigAdapter可以来扩展SpringMVC的功能
 *
 * @author Guangxing
 * @create time 2020/3/28 22:34
 **/
//@EnableWebMvc  不要接管SpringMVC
@Configuration
public class MyConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //浏览器发送/guangxing  请求来到success
        registry.addViewController("/guangxing").setViewName("success");
    }

    /**
     * 所有WebMvcConfigAdapter组件都会一起起作用
     * @return
     */
    @Bean//将组件注册在容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        return new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
               // super.addInterceptors(registry);
                //静态资源：*.js  *.css
                //SpingBoot已经做好了静态资源映射
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/**");
            }
        };

    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MylocaleResolver();
    }

}
