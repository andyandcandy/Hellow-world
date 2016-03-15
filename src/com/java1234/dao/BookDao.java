package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.transform.Result;

import com.java1234.model.Book;
import com.java1234.util.StringUtil;


public class BookDao {
    public int add(Connection con,Book book) throws Exception{
    
        String sql = "insert into books values(null,?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, book.getBookName());
        pstmt.setString(2,book.getAuthor());
        pstmt.setString(3, book.getSex());
        pstmt.setFloat(4,book.getPrice());
        pstmt.setInt(5, book.getBookTypeId());
        pstmt.setString(6, book.getBookDesc());
        return pstmt.executeUpdate();
    }
    
    public ResultSet list(Connection con,Book book) throws Exception{
        StringBuffer sb = new StringBuffer("select * from books b,t_book bt where b.bookTypeId=bt.id");
        if(StringUtil.isnotEmpty(book.getBookName())){
            sb.append(" and b.bookName like '%"+book.getBookName()+"%'");
        }
        if(StringUtil.isnotEmpty(book.getAuthor())){
            sb.append(" and b.author like '%"+book.getAuthor()+"%'");
        }
        if(book.getBookTypeId()!=null&&book.getBookTypeId()!=-1){
            sb.append("and b.bookTypeId="+book.getBookTypeId());
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
       return   pstmt.executeQuery();
    }
    /**
     * ͼ��ɾ��
     * @param con
     * @param id
     * @return
     * @throws Exception
     */
    
    public int delete(Connection con,String id) throws Exception{
        String sql = "delete from books where id = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, id);
        return pstmt.executeUpdate();
    }
    /**
     * ����ͼ��
     * @param con
     * @param book
     * @return
     * @throws Exception
     */
    public int update(Connection con,Book book) throws Exception{
        String sql = "update books set bookName=?,author=?,sex=?,price=?,bookDesc=?,bookTypeId=? where id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, book.getBookName());
        pstmt.setString(2, book.getAuthor());
        pstmt.setString(3, book.getSex());
        pstmt.setFloat(4, book.getPrice());
        pstmt.setString(5, book.getBookDesc());
        pstmt.setInt(6, book.getBookTypeId());
        pstmt.setInt(7, book.getId());
        return pstmt.executeUpdate();
    }
    /**
     * ͼ��������Ƿ����ͼ��
     * @param con
     * @param bookTypeId
     * @return
     * @throws Exception 
     */
    public Boolean existBookByBookTypeId(Connection con,String bookTypeId) throws Exception{
        String sql = "select *��books where bookTypeId=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, bookTypeId);
        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    }
    
}
