package com.chinasoft.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {

//        f1();

//         切换数据库
        DataSource ds = new ComboPooledDataSource("other3p0");
        for (int i = 0; i < 11; i++) {
            Connection connection = ds.getConnection();
            System.out.println(connection);
        }

    }

    private static void f1() throws SQLException {
        DataSource ds = new ComboPooledDataSource();
        for (int i = 0; i < 11; i++) {
            Connection connection = ds.getConnection();
            System.out.println(connection);
            if (i == 3){
                connection.close();
            }
        }
    }

}
