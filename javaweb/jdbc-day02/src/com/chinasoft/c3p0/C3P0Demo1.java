package com.chinasoft.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo1 {
    public static void main(String[] args) throws SQLException {
//      创建核心对象 数据库连接池对象 ComboPooledDataSource
        DataSource cpds = new ComboPooledDataSource();
//       获取连接：getConnection
        Connection connection = cpds.getConnection();
        System.out.println(connection);
    }
}
