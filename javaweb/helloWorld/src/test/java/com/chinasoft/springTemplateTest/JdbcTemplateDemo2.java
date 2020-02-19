package com.chinasoft.springTemplateTest;

import com.chinasoft.prjo.Emp;
import com.chinasoft.utils.JDBCUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 *
 *  使用jdbcTemplate对象的方法执行CURD操作
 *  update():执行DML语言，insert，delete，update
 *  queryForMap():查询的结果直接封账成Map集合，将列名作为key值，将值作为value,该方法查询出来的结果集长度只能为1
 *  queryForList():将查询出来的结果封装为List集合，执行过程：先将每一条记录封装到map中，然后将map集合装载到list集合中
 *  query()：将查询结果封装为JavaBean对象，
 *      query方法有多个重载方法：其中重要的参数RowMapper
 *          一般使用BeanPropertyRow实现类，可以完成数据的自动封装 new BeanPropertyRowMapper<类型>(类型.class)
 *  queryForObject：查询结果封装为对象 一般用作聚合查询的结果封装
 *
 *  使用JdbcTemplate 完成CRUD操作
 *
 */
public class JdbcTemplateDemo2 {
    JdbcTemplate jdbcTemplate = null;
    @Before
    public void init(){
        jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    }
    /**
     * 插入一条数据
     */
    @Test
    public void f1() {
        String sql = "insert into account values(?,?,?)";
        int insert = jdbcTemplate.update(sql,6,"jack",7000);
        System.out.println(insert);
    }

    /**
     * 删除一条数据
     */
    @Test
    public void f2(){
        String sql = "delete from account where id = ?";
        int delete = jdbcTemplate.update(sql, 6);
        System.out.println(delete);
    }
    /**
     * 修改操作
     */
    @Test
    public void f3(){
        String sql = "update account set balance = ? where id = ?";
        int update = jdbcTemplate.update(sql, 500, 3);
        System.out.println(update);
    }
    /**
     * 查询emp表中id为1010的记录，并将结果封装为map集合
     *  注意结果集只能为一条
     */
    @Test
    public void f4(){
        String sql = "select * from emp where id = ? ";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 1010);
        System.out.println(map);
    }
    /**
     *  将查询的结果封装为list集合
     */
    @Test
    public void f5(){
        String sql = "select * from emp";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map:maps) {
            System.out.println(map);
        }
    }
    /**
     * 将查询结果封装到对象并添加到List集合中
     */
//    @Test
//    public void f6(){
//        String sql = "select * from emp";
//        List<Emp> emps = jdbcTemplate.query(sql, (ResultSet rs, int i) -> {
//            Emp emp = new Emp();
//            int id = rs.getInt(1);
//            String name = rs.getString(2);
//            int jobId = rs.getInt(3);
//            int mgr = rs.getInt(4);
//            Date joindate = rs.getDate(5);
//            double salary = rs.getDouble(6);
//            double bonus = rs.getDouble(7);
//            int deptId = rs.getInt(8);
//
//            emp.setId(id);
//            emp.setEname(name);
//            emp.setJobId(jobId);
//            emp.setMgr(mgr);
//            emp.setJoindate(joindate);
//            emp.setSalary(salary);
//            emp.setBonus(bonus);
//            emp.setDeptId(deptId);
//
//            return emp;
//
//        });
//        for (Emp emp : emps) {
//            System.out.println(emp);
//        }
//    }

    /**
     *  简化对象的封装
     */
//    @Test
//    public void f7(){
//        String sql = "select * from emp";
//        List<Emp> lists = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
//        for(Emp list: lists){
//            System.out.println(list);
//        }
//    }

    /**
     * queryForObject：查询结果封装为对象
     */
    @Test
    public void f8(){
        String sql = "select count(*) from emp";
        Long total = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(total);
    }

}
