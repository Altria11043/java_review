package com.zca.TestJDBC;

import java.io.*;
import java.sql.*;

/**
 * Blob将大对象用字节流保存
 * @author Altria
 * Date: 18/10/2019 上午 1:20
 */
public class TestBLOB02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC","root","zhou@11043");

            String sql = "select * from student where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 20018);
            rs = ps.executeQuery();

            os = new BufferedOutputStream(new FileOutputStream("E:/01.jpg"));
            while(rs.next()){
                Blob b = rs.getBlob("img");
                is = b.getBinaryStream();
                byte[] flush = new byte[1024];
                int len = -1;
                while((len=is.read(flush))!=-1){
                    os.write(flush, 0, len);
                }
                os.flush();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                if (null!=os){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null!=is){
                    is.close();
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
