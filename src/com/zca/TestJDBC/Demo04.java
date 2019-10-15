package com.zca.TestJDBC;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用executeQuery(): 运行select语句, 返回ResultSet结果集
 * @author Altria
 * Date: 15/10/2019 下午 12:33
 */
public class Demo04 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC","root","zhou@11043");

            String sql = "select id, name, pwd, age from student where id > ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 2);
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("id: " + rs.getInt(1) +
                        ",name: " + rs.getString(2) +
                        ", pwd: " + rs.getString(3) +
                        ",age: " + rs.getInt(4));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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
