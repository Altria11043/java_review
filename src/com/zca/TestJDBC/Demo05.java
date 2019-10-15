package com.zca.TestJDBC;

import java.sql.*;

/**
 * @author Altria
 * Date: 15/10/2019 下午 12:51
 */
public class Demo05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC","root","zhou@11043");
            conn.setAutoCommit(false); // 设为手动提交

            long startTime = System.currentTimeMillis();

            stmt = conn.createStatement();
            for (int i=0; i<20000; i++){
                stmt.addBatch("insert into student (name, pwd, age, regTime) values ('Z" + i + "', '666666', 24, now())");
            }
            stmt.executeBatch();
            conn.commit(); // 提交事务

            long endTime = System.currentTimeMillis();
            System.out.println("插入20000条数据总耗时:" + (endTime - startTime));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if (null != stmt){
                    stmt.close();
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
