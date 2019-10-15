package com.zca.TestJDBC;

import java.sql.*;

/**
 * ProparedStatement类
 * 继承自Statement接口, 由prepareStatement创建, 用于发送含有
 * 一个或多个输入参数的sql语句. preparedStatement对象比Statement对象的效率更高,
 * 并且可以防止SQL注入. 美味一般都用PreparedStatement.
 * @author Altria
 * Date: 15/10/2019 上午 10:44
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC","root","zhou@11043");

            String sql = "insert into student (id, name, pwd, age) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 5);
            ps.setString(2, "Zhou1");
            ps.setString(3, "123123");
            ps.setInt(4, 25);
            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
