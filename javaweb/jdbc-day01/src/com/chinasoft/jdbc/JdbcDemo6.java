package com.chinasoft.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 使用jdbc实现登陆功能
 *
 * 1.在数据库中查询是否有你前期注册好的账号密码
 * 2.如果查到账号密码然后跟你输入的账号密码相匹配则会显示登陆成功
 * 3.账号存在，但是密码不正确则显示密码错误登陆不成功，请重新输入密码
 */
public class JdbcDemo6 {

    static Connection conn = null;
    static Statement statement = null;
    static ResultSet resultSet = null;

    public static void main(String[] args) {

//        1.获取数据的连接
        try {
            conn = JDBCUtils.getConnection();
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入用户名");
            String name = scan.nextLine();
            System.out.println("请输入密码");
            String password = scan.nextLine();
//        创建sql语句
            String sql = "select * from user WHERE  username = '" + name + "' AND password = '" + password + "'";
//        创建statment对象
            statement = conn.createStatement();
//        使用statment对象执行sql语句
            resultSet = statement.executeQuery(sql);
//       处理结果
            if (resultSet.next()){
                //            1.没有查到时结果为false  2.查到返回true
                System.out.println("登录成功");
            }else {
                LoginOut(name,password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //        关闭资源
            JDBCUtils.close(resultSet,statement,conn);
        }
    }

    private static void LoginOut(String name,String password) {
        try {
            String sql ="SELECT * FROM user where username = '" + name + "' or password = '" + password + "'";
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                System.out.println("用户名或者密码错误");
            }else {
                System.out.println("登录失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




//public class JdbcDemo6 {
//    public static void main(String[] args) {
//        //1.键盘录入，接受用户名和密码
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入用户名：");
//        String username = sc.nextLine();
//        System.out.println("请输入密码：");
//        String password = sc.nextLine();
//        //2.调用方法
//        boolean flag = new JdbcDemo6().login(username, password);
//        //3.判断结果，输出不同语句
//        if (flag) {
//            //登录成功
//            System.out.println("登录成功！");
//        } else {
//            System.out.println("用户名或密码错误！");
//        }
//    }
//    /**
//     * 登录方法
//     */
//    public boolean login(String username, String password) {
//        if (username == null || password == null) {
//            return false;
//        }
//        //连接数据库判断是否登录成功
//        Connection conn = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        //1.获取连接
//        try {
//            conn = JDBCUtils.getConnection();
//            //2.定义sql
//            String sql = "select * from user where username = '" + username + "' and password = '" + password + "' ";
//            //3.获取执行sql的对象
//            statement = conn.createStatement();
//            //4.执行查询
//            resultSet = statement.executeQuery(sql);
//            //5.判断
//            /*if (resultSet.next()) {//如果有下一行，则返回true
//                return true;
//            } else {
//                return false;
//            }*/
//            return resultSet.next();//如果有下一行，则返回true
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            JDBCUtils.close(resultSet, statement, conn);
//        }
//        return false;
//    }
//}