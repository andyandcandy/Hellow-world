package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java1234.model.User;
/**
 * �û�Dao��
 */

public class UserDao {
/**
 * ��¼��֤
 * @param con
 * @param user
 * @return
 * @throws Exception
 */
    public User login (Connection con,User user) throws Exception{
        User resultUser = null;
        String sql = "select * from t_user where userName=? and passWord=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getpassWord());
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            resultUser = new User();
            resultUser.setId(rs.getInt("id"));
            resultUser.setUserName(rs.getString("userName"));
            resultUser.setpassWord(rs.getString("passWord"));
            
        }
        return resultUser;
        
    }
}
