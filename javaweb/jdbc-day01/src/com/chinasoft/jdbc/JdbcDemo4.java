package com.chinasoft.jdbc;

import java.sql.*;

/**
 * DQL语言的操作：
 *
 *
 */
public class JdbcDemo4 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from dept";
            statement = conn.createStatement();
//        执行DQL语言
            resultSet = statement.executeQuery(sql);
//        处理结果
//            boolean next();
//            取第一行的值
            while (resultSet.next())  {
                int id = resultSet.getInt("id");
                String dname = resultSet.getString("dname");
                String loc = resultSet.getString("loc");
                System.out.println(id+" "+dname+" "+loc);
            }
//            取第二行的值
//            resultSet.next();
//            int anInt2 = resultSet.getInt(1);
//            String string2 = resultSet.getString(2);
//            String string12 = resultSet.getString(3);
//            System.out.println(anInt2+" "+string2+" "+string12);
//
//            resultSet.next();
//            int anInt3 = resultSet.getInt(1);
//            String string3 = resultSet.getString(2);
//            String string13 = resultSet.getString(3);
//            System.out.println(anInt3+" "+string3+" "+string13);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, statement, conn);
        }


    }
}

