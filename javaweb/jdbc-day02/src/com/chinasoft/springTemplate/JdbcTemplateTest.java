package com.chinasoft.springTemplate;

import com.chinasoft.prjo.Dept;
import com.chinasoft.prjo.Emp;
import com.chinasoft.utils.JDBCUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * 使用jdbcTemplate对Dept表做 CURD操作
 *
 * 将查询结果封装为map集合进行打印输出
 * 将查询出来的所有结果封装到list集合中进行包装打印输出
 *
 * 求出部门编号为3的部门的全部信息并打印输出
 *
 * 求出emp表中的年工资最大值 封装后打印输出
 *
 */
public class JdbcTemplateTest {

    JdbcTemplate jdbcTemplate = null;
    @Before
    public void init(){
        jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    }
    @Test
    public void f1(){
        String sql = "insert into dept values(?,?,?) ";
        int insert = jdbcTemplate.update(sql, 5, "商务部", "武汉");
        System.out.println(insert);
    }
    @Test
    public void f2(){
        String sql = "delete  from dept where id = ?";
        int delete = jdbcTemplate.update(sql, 5);
        System.out.println(delete);
    }
    @Test
    public void f3(){
        String sql = "update dept set dname = ? where id = ?";
        int update = jdbcTemplate.update(sql, "商务部", 3);
        System.out.println(update);
    }
    @Test
    public void f4(){
        String sql = "select * from dept where id = ? ";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 1);
        System.out.println(map);
    }
    @Test
    public void f5(){
        String sql = "select * from dept";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }
//    @Test
//    public void f51(){
//        String sql = "select * from dept";
//        List<Dept> depts = jdbcTemplate.query(sql,(ResultSet rs,int i) -> {
//            Dept dept = new Dept();
//            Integer id = dept.getId(1);
//            String dname = dept.getDname(2);
//            String loc = dept.getLoc(3);
//
//            dept.setId(id);
//            dept.setDname(dname);
//            dept.setLoc(loc);
//            return dept;
//
//        });
//    }
    @Test
    public void f52(){
        String sql = "select * from dept";
        List<Dept> lists = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dept.class));
        for(Dept list: lists){
            System.out.println(list);
        }
    }
    @Test
    public void f6(){
        String sql = "select * from dept where id = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 3);
        System.out.println(map);
    }
    @Test
    public void f7(){
        String sql = "select max(salary) from emp ";
        Long max = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(max);
    }

}
