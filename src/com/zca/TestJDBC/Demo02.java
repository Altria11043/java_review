package com.zca.TestJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Statement类
 * 由create Statement创建, 用于发送简单的SQL语句.
 * @author Altria
 * Date: 15/10/2019 上午 10:09
 */
public class Demo02 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC","root","zhou@11043");

            // 这个方法不会再实际中使用, 容易发生SQL注入
            Statement stmt = conn.createStatement();
            String sql = "insert into student (id, name, pwd, age, regTime) values (4, 'Zhouchenan', '666666', 24, now())";
            stmt.execute(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
