package com.chinasoft.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 *  druid入门使用
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
//        加载配置文件
        Properties pro = new Properties();
        InputStream in = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(in);
//        获取连接对象 DruidDataSource
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
//        获取连接
        Connection connection = ds.getConnection();
        System.out.println(connection);

    }
}
