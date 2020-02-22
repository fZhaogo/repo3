package com.chinasoft.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

@WebServlet("/demo2")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();  //获取请求方式
        System.out.println(method);
        String contextPath = req.getContextPath();  //获取虚拟路径
        System.out.println("虚拟路径目录为："+contextPath);
        String servletPath = req.getServletPath();
        System.out.println("servlet路径为："+servletPath);
        String queryString = req.getQueryString();
        System.out.println("获取请求参数为："+queryString);
        String requestURI = req.getRequestURI();
        System.out.println("获取请求的uri:"+requestURI);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("获取请求的url:"+requestURL);
        String protocol = req.getProtocol();
        System.out.println("获取协议:"+protocol);
        String remoteAddr = req.getRemoteAddr();
        System.out.println("获取ip:"+remoteAddr);

//        获取请求头
//          获取请求头对应的值
        String referer = req.getHeader("user-agent");
        System.out.println("use-agent为："+referer);

        Enumeration<String> headerNames = req.getHeaderNames();
        Iterator<String> stringIterator = headerNames.asIterator();
        while (stringIterator.hasNext()){
            String next = stringIterator.next();
            System.out.println(next);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
