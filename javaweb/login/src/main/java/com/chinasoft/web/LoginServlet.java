package com.chinasoft.web;

import com.chinasoft.dao.UserDao;
import com.chinasoft.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置参数的编码集
        request.setCharacterEncoding("utf-8");
//        获取页面传过来的参数
        String name = request.getParameter("name");
        String password = request.getParameter("password");
//        将参数封装到user对象中 作为一个参数传给后续方法
        User user = new User(null,name,password);
        UserDao userDao = new UserDao();
//        调用查询方法，将封装好的user对象传到后面去
        int result = userDao.findUserByNameAndPassword(user);

        if ( result > 0){
//            登录成功转发到成功的servlet
            request.getRequestDispatcher("/scusse").forward(request,response);
        }else {
            request.getRequestDispatcher("/faile").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
