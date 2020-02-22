package com.chinasoft.dao;

import com.chinasoft.pojo.User;
import com.chinasoft.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Description 此类负责对数据的查询操作
 * @ClassName UserDao
 * @Author Dudu
 * @Date 2020/2/21 10:15
 * @Version V1.0
 */
public class UserDao {


    /**
     * 通过用户名和密码查询用户信息
     * @param user
     * @return  0表示没查到 1表示查到了
     */
    public int findUserByNameAndPassword(User user){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select count(id) from t_user where name=? and password=?";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class, user.getName(), user.getPassword());
        return integer.intValue();
    }

}
