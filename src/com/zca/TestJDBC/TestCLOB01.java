package com.zca.TestJDBC;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * CLOB
 * 测试大文本对象的使用
 * 这里要注意设计数据库字段的时候不要与关键字同名
 * @author Altria
 * Date: 16/10/2019 下午 10:34
 */
public class TestCLOB01 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC","root","zhou@11043");

            String sql = "insert into student (name, pwd, explains) values (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "Zhou");
            ps.setString(2, "123456");
            ps.setClob(3, new FileReader(new File("F:/a.txt")));
            ps.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
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
