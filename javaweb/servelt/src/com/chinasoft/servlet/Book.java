package com.chinasoft.servlet;

import javax.servlet.*;
import java.io.IOException;

public class Book implements Servlet {
    /**
     * 初始化方法
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 工作方法
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("案件无法年检费");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     */
    @Override
    public void destroy() {

    }
}
