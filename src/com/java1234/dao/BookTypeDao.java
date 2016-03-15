package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java1234.model.BookType;
import com.java1234.util.StringUtil;


public class BookTypeDao {
    /**
     * 图书类别添加
     * @param con
     * @param bookType
     * @return
     * @throws Exception
     */
    public int add(Connection con,BookType bookType)throws Exception{
        String sql = "insert into t_book values(null,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, bookType.getBookTypeName());
        pstmt.setString(2, bookType.getBookTypeDesc());
        return pstmt.executeUpdate();
           
        
        }
    /**
     * 查询数据
     * @param con
     * @param bookType
     * @return
     * @throws Exception
     */
    public ResultSet list(Connection con, BookType bookType) throws Exception{
        StringBuffer sb = new StringBuffer("select * from t_book");
        if(StringUtil.isnotEmpty(bookType.getBookTypeName())){
            sb.append(" and bookTypeName like '%" + bookType.getBookTypeName()+"%'");
            
        } 
        PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and","where"));
        return pstmt.executeQuery();
    }
    /*删除图书类别*
     * 
     * @param con
     * @param id
     * @return
     * @throws Exception
     */
    public int delete(Connection con,String id) throws Exception
    {
        String sql = "delete from t_book where id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,id);
        return pstmt.executeUpdate();
    }
    /**
     * 跟新图书类别
     * @param con
     * @param bookType
     * @return
     * @throws Exception
     */
    public int update(Connection con,BookType bookType)throws Exception{
        String sql ="update t_book set bookTypeName=?,bookTypeDesc=? where id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,bookType.getBookTypeName());
        pstmt.setString(2, bookType.getBookTypeDesc());
        pstmt.setInt(3, bookType.getId());
        return pstmt.executeUpdate();
               
    }
}
