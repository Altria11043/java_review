package com.zca.TestJDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

/**
 * @author Altria
 * Date: 18/10/2019 上午 1:07
 */
public class TestBLOB01 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC","root","zhou@11043");

            String sql = "insert into student (img, name, pwd, regTime) values (?, ?, ?, now())";
            ps = conn.prepareStatement(sql);

            ps.setBlob(1, new FileInputStream("F:/01.jpg"));
            ps.setString(2, "黑贞");
            ps.setString(3, "123456");
            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally{
            try {
                if (null != rs){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
