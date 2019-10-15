package com.zca.TestJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试与数据库建立连接
 * static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
 * 问题一:
 * 在较高版本的 Mysql 中，引入了 SSL 安全认证，需要拥有一定的安全证书去连接数据库，
 * 而我们没有证书，所以出现此警告。
 * 解决方式：在原数据库 url 后加上禁用 SSL 的信息
 * jdbc:mysql://localhost:3306/你的库名?useSSL=false
 * 问题二:
 * 解决时区问题 ...The server time zone value '???ú±ê×??±??'...
 * 解决此问题只需要在原 url 后附加 serverTimezone=UTC
 * 问题解决后:
 * jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC
 * @author Altria
 * Date: 15/10/2019 上午 1:05
 */
public class Demo01
{
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC","root","zhou@11043");
            System.out.println(conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
