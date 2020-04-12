package com.guangxing.config;

import com.guangxing.filter.MyFilter;
import com.guangxing.listener.MyListener;
import com.guangxing.servlet.MyServlet;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 服务器配置信息
 *
 * @author Guangxing
 * @create time 2020/4/12 13:34
 **/
@Configuration
public class MyServerConfig {

    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        return new ServletRegistrationBean(new MyServlet(), "/myServlet");
    }

    @Bean
    public FilterRegistrationBean myFilter(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myLisener(){

        return new ServletListenerRegistrationBean<MyListener>(new MyListener());
    }

  //配置去嵌入Servlet容器
    @Bean
    public TomcatConnectorCustomizer tomcatConnectorCustomizer(){
        return new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
               /* Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
                protocol.setAcceptCount(2000);
                protocol.setAcceptorThreadCount(2);

                protocol.setMaxThreads(100);
                protocol.setMinSpareThreads(100);
                protocol.setMaxConnections(10000);
                protocol.setConnectionTimeout(20000);*/

                //配置端口号
                connector.setPort(8083);
            }
        };
    }


}
