package com.chinasoft.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo2 {
    public static void main(String[] args){

        Connection conn = null;
        Statement statement = null;
        int i = 0;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "insert into account values(3,'王五',1000)";

            statement = conn.createStatement();

            i = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(i > 0){
                System.out.println("执行成功");
            }else {
                System.out.println("执行失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,statement,conn);

        }




    }
}
