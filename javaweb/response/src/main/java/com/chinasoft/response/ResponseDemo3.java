package com.chinasoft.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo3")
public class ResponseDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//          设置编码格式
        response.setCharacterEncoding("utf-8");
//        设置响应头
//        response.setHeader("content-type","text/html;charset=utf-8");
//        简化写法
        response.setContentType("text/html;charset=utf-8");
//        获得输出流
        PrintWriter writer = response.getWriter();
//        通过输出流向前台页面发送数据
        writer.write("<h1>这是使用字符流输出的响应</h1>");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
