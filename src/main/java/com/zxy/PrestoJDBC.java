package com.zxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ZhouXinyu on 2019/9/6 16:14.
 */
public class PrestoJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = JdbcUtil.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SHOW TABLES");
        JdbcUtil.printRs(rs);

        System.out.println("---------------");

        rs = stmt.executeQuery("SELECT * FROM employee");
        JdbcUtil.printRs(rs);
        JdbcUtil.close(rs, stmt, con);
    }

}
