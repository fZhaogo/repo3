package com.chinasoft.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//@WebServlet({"/demo1","/demo2","/hehe"})  //同时给这个servlet添加了多个虚拟路径
//@WebServlet("/hello/demo1")  //添加多级目录
//@WebServlet("/*")
@WebServlet("/demo1")  //使用扩展名匹配
public class ServletDemo implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        System.out.println("这是用注解的形式完成的servlet");
//        System.out.println(servletRequest);
//        System.out.println(servletResponse);
//        向request对象中取值
        Object like = servletRequest.getAttribute("like");
        System.out.println(like);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
