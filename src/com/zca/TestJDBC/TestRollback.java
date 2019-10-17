package com.zca.TestJDBC;

import java.sql.*;

/**
 * 此案例不能作为事物的案例进行参考
 * 在报错之后就没有执行后面的语句了, 导致没有执行提交操作.
 * @author Altria
 * Date: 16/10/2019 下午 7:57
 */
public class TestRollback {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC","root","zhou@11043");

            // 改成手动提交事物
//            conn.setAutoCommit(false);

            // 正确的插入语句
            String sql1 = "insert into student (name, pwd, regTime) values (?, ?, now())";
            // 错误的插入语句
            String sql2 = "insert into student (name, pwd, regTime) values (?, ?, ?, now())";
            ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, "Altria");
            ps1.setString(2, "123456");
            ps1.execute();
            System.out.println("插入一条记录");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, "Saber");
            ps2.setString(2, "123456");
            ps2.execute();
            System.out.println("插入一条记录");

//            conn.commit();// 提交事物
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                System.out.println("执行回滚");
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("回滚异常");
                ex.printStackTrace();
            }
        } finally{
            try {
                if (null != ps2){
                    ps2.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (null != ps1){
                    ps1.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (null != conn){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
