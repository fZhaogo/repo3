package com.chinasoft.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 练习： 使用jdbc查询emp表，并将查询出来的结果封装成对象放到list集合中遍历打印输出
 */
public class JdbcDemo5 {
    public static void main(String[] args) {

        List<Emp> all = findAll();
        System.out.println(all);
        System.out.println(all.size());

    }

    private static List<Emp> findAll() {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Emp> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from emp";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
//          遍历结果集
            while (resultSet.next()) {
//               拿数据
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int jobId = resultSet.getInt("job_id");
                int mgr = resultSet.getInt(4);
                Date joindate = resultSet.getDate(5);
                double salary = resultSet.getDouble(6);
                double bonus = resultSet.getDouble(7);
                int deptId = resultSet.getInt(8);
                Emp emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setjobId(jobId);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDeptId(deptId);
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, statement, conn);
        }
        return list;
    }
}
