package com.chinasoft.springTemplate;

import com.chinasoft.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 *  springjdbcTemplate入门案例
 */
public class SpringTemplateDemo {
        public static void main(String[] args) {

//     1.导包
//     2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
//     3.写sql
        String sql = "select * from user";
//     4.执行sql
                List<Map<String, Object>> maps = template.queryForList(sql);
//     5.出结果
                for (Map<String, Object> map : maps) {
                        System.out.println(map);
                }

        }
}
