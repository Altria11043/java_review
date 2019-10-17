package com.zca.TestJDBC;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Altria
 * Date: 16/10/2019 下午 9:45
 */
public class TestTime02 {

    /**
     * 字符串转时间
     * @param dataStr
     * @return
     */
    private static long strToData(String dataStr){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return format.parse(dataStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC","root","zhou@11043");

            String sql = "select * from teacher where modifyTime>? and modifyTime<? order by modifyTime ASC";
            ps = conn.prepareStatement(sql);
            Timestamp startData = new Timestamp(strToData("2019-09-28 00:00:00"));
            Timestamp endData = new Timestamp(strToData("2019-10-01 23:59:59"));
            ps.setTimestamp(1,startData);
            ps.setTimestamp(2,endData);
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("id: " + rs.getInt("id")
                        + "\t\t名字: " + rs.getString("name")
                        + "\t\t创建时间: " + rs.getDate("foundTime")
                        + "\t\t修改时间: " + rs.getTimestamp("modifyTime"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (
        SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if (null!=rs){
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
