package com.chinasoft.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

@WebServlet(name = "/demo3")
public class RequestServletDemo02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置参数的编码集解决中文乱码问题
        request.setCharacterEncoding("utf-8");
//        根据参数名称获取参数的值
        String name = request.getParameter("name");
        System.out.println(name);
//        获取同名参数 并将值放到数组当中
        String[] likes = request.getParameterValues("like");
        for (String like : likes) {
            System.out.println(like);
        }
//         获取参数的名称
        Enumeration<String> parameterNames = request.getParameterNames();
        Iterator<String> stringIterator = parameterNames.asIterator();
        while (stringIterator.hasNext()){
            String next = stringIterator.next();
            System.out.println(next);
        }

    }
}
