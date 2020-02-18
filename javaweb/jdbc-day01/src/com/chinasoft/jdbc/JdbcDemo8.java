package com.chinasoft.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 *  演示如何通过jdbc来操作mysql中的事务
 */
public class JdbcDemo8 {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pre1 =null;
        PreparedStatement pre2 =null;

//       1.获取连接
//         开启事务
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
//       2.定义sql
            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";
//        3.获取执行sql的对象
            pre1 = conn.prepareStatement(sql1);
            pre2 = conn.prepareStatement(sql2);
//        4.设置参数
            pre1.setDouble(1,500);
            pre1.setInt(2,1);
            pre2.setDouble(1,500);
            pre2.setInt(2,2);
//        5.执行sql
            pre1.executeUpdate();
//            自创异常
            int i = 3/0;
            pre2.executeUpdate();
//        执行成功commit
            conn.commit();
            System.out.println("转账操作执行成功");
        }catch (Exception e) {
            System.out.println("转账失败");
            //        执行失败rollback()
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
//        关闭资源
            JDBCUtils.close(null,pre1,conn);
            JDBCUtils.close(null,pre2,null);
        }
    }
}
