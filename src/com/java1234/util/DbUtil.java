package com.java1234.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 */
public class DbUtil {
    private String dbUrl = "jdbc:mysql://localhost:3306/db_book";
    private String dbUserName = "root";
    private String dbPassword = "root";
    private String jdbcName ="com.mysql.jdbc.Driver";
    /**
     * 获得连接
     * @return
     * @throws Exception
     */
    public Connection getCon() throws Exception{
        //Class.forName(jdbcName);
        try {
            Class.forName(jdbcName);
            System.out.println("加载驱动成功");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            //logger.logp(Level.SEVERE, className, "main", "Error when...", e);
            e.printStackTrace();
            System.out.println("加载驱动成功");
            
        }
        Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        return con;
    }
    public void closeCon(Connection con)throws Exception{
        if(con!= null){
            con.close();
        }
    }
    public Connection getCon1() throws Exception{
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        return con;
    }
    public static void main(String[] args){
        DbUtil dbUtil = new DbUtil();
        try {
            dbUtil.getCon();
            System.out.println("数据库连成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            //logger.logp(Level.SEVERE, className, "mian", "Error when...", e);
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
        
    }
}

