package com.guangxing.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自己的servlet配置
 *
 * @author Guangxing
 * @create time 2020/4/12 13:32
 **/
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文输出乱码问题
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        resp.getWriter().write("这是输出数据");
    }
}
