package com.zca.TestJDBC;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;

/**
 * CLOB
 * 读取数据库中的大文本
 * @author Altria
 * Date: 16/10/2019 下午 11:19
 */
public class TestCLOB02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Reader r = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC","root","zhou@11043");

            String sql = "select explains from student where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 20017);
            rs = ps.executeQuery();

            char[] flush = new char[1024];

            while(rs.next()){
                Clob c = rs.getClob("explains");
                r = c.getCharacterStream();
                int temp = -1;
                while((temp=r.read(flush))!=-1){
                    System.out.println(new String(flush, 0, temp));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                if (null != r){
                    r.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
