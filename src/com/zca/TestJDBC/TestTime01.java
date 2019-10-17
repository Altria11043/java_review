package com.zca.TestJDBC;

import java.sql.*;
import java.util.Random;

/**
 * @author Altria
 * Date: 16/10/2019 下午 8:19
 */
public class TestTime01 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC","root","zhou@11043");

            for (int i=0; i<10000; i++){
                String sql = "insert into teacher (name, foundTime, modifyTime) values (?, ?, ?)";
                ps = conn.prepareStatement(sql);

                int read = 1000000000 + new Random().nextInt(1000000000);
                java.sql.Date data = new java.sql.Date(System.currentTimeMillis()-read);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis()-read);
                ps.setString(1, "Zhou" + i);
                ps.setDate(2, data);
                // 这里由两种方法, 但是有一种不被建议使用了
                ps.setTimestamp(3, timestamp);
                ps.execute();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if (null != ps){
                    ps.close();
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
