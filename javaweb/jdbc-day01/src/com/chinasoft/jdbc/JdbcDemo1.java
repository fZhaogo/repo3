package com.chinasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
//        2.获取数据库连接对象Connection对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
//         3.定义sql
        String sql = "update account set balance = 1500 where id = 1";
//        4.获取执行SQL对象statement
        Statement statement = conn.createStatement();
//        5.执行SQL语句，接受返回结果
        int i = statement.executeUpdate(sql);
//        6.处理结果
        System.out.println(i);
//        7.释放资源
        statement.close();
        conn.close();


    }
}
