package com.chinasoft.servlet;

import com.chinasoft.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 完善登录案例：将前台输入过来的数据获取后跟数据库中的user表作比较验证用户是否登陆成功，
 * 需要用到jdbc相关知识，以及springTemplate相关知识
 *
 */
@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name);
        System.out.println(password);

        Connection connection = null;
        PreparedStatement pre = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from user";
            pre = connection.prepareStatement(sql);

            int i = pre.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,pre,connection);
        }

//        回复消息给页面
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<h1>登录成功</h1>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
