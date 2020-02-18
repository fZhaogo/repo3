package com.chinasoft.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *  PreparedStatement
 *      1.可以防止sql注入
 *      2.执行效率比较高
 *
 */
public class JdbcDemo7 {
    public static void main(String[] args) {
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement pre = null;
//        1.注册驱动
//        2.获取连接对象
        try {
            conn = JDBCUtils.getConnection();
//        3.定义sql语句
            String sql = "select * from user where username = ? and password = ?";
//        4.获取执行sql语句的对象PrepareStament对象
            pre = conn.prepareStatement(sql);
//        5.给sql语句赋值
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入用户名");
            String name = scan.nextLine();
            System.out.println("请输入密码");
            String password = scan.nextLine();
//          组装pre对象中的sql语句
            pre.setString(1,name);
            pre.setString(2,password);
//        6.执行sql并返回结果
            resultSet = pre.executeQuery();
//        7.处理结果
            if(resultSet.next()){
                System.out.println("登陆成功");
            }else {
                System.out.println("登陆失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            8.释放资源
            JDBCUtils.close(resultSet,pre,conn);
        }
    }

}
