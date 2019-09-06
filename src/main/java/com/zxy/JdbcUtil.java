package com.zxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * Created by ZhouXinyu on 2019/9/6 16:47.
 */
public class JdbcUtil {
    static{
        String driver = "com.facebook.presto.jdbc.PrestoDriver";
        try{
            Class.forName(driver);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        String url =
                "jdbc:presto://66.42.64.129:8090/hive/myhive";
        String usr = "test";
        String pwd = null;
        Connection con = null;
        try{
            con = DriverManager.getConnection(url, usr, pwd);
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
    public static void close(ResultSet rs, Statement stmt, Connection con){
        try{
            if(rs!=null) {
                rs.close();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        try{
            if(stmt!=null) {
                stmt.close();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        try{
            if(con!=null) {
                con.close();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void printRs(ResultSet rs){
        try{
            StringBuffer sb = new StringBuffer();
            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();
            for(int i=1; i<=cols; i++){
                sb.append(meta.getColumnName(i) + "\t");
            }
            sb.append("\n");
            while(rs.next()){
                for(int i=1; i<=cols; i++){
                    sb.append(rs.getString(i) + "\t");
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
