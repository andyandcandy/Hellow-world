package com.java1234.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ���ݿ⹤����
 */
public class DbUtil {
    private String dbUrl = "jdbc:mysql://localhost:3306/db_book";
    private String dbUserName = "root";
    private String dbPassword = "root";
    private String jdbcName ="com.mysql.jdbc.Driver";
    /**
     * �������
     * @return
     * @throws Exception
     */
    public Connection getCon() throws Exception{
        //Class.forName(jdbcName);
        try {
            Class.forName(jdbcName);
            System.out.println("���������ɹ�");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            //logger.logp(Level.SEVERE, className, "main", "Error when...", e);
            e.printStackTrace();
            System.out.println("���������ɹ�");
            
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
            System.out.println("���ݿ����ɹ�");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            //logger.logp(Level.SEVERE, className, "mian", "Error when...", e);
            e.printStackTrace();
            System.out.println("���ݿ�����ʧ��");
        }
        
    }
}

