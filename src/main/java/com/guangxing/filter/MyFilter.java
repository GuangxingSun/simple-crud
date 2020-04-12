package com.guangxing.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义filter
 *
 * @author Guangxing
 * @create time 2020/4/12 22:04
 **/
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter 已经执行");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }

}
