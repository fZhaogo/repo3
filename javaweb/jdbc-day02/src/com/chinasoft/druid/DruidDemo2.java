package com.chinasoft.druid;

import com.chinasoft.utils.JDBCUtils;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 用工具类向emp表中插入一条数据
 */
public class DruidDemo2 {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement pre = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
            pre = connection.prepareStatement(sql);
//           往sql语句中插入一些值
            pre.setInt(1,1015);
            pre.setString(2,"曹操");
            pre.setInt(3,3);
            pre.setInt(4,1007);
            pre.setDate(5,new Date(1233456765L));
            pre.setDouble(6,80000);
            pre.setDouble(7,200);
            pre.setInt(8,2);
            int i = pre.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,pre,connection);
        }
    }
}
