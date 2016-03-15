package com.java1234.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.java1234.dao.BookTypeDao;
import com.java1234.dao.UserDao;
import com.java1234.model.BookType;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;


public class BookTypeAddInterFrm extends JInternalFrame {

    private JTextArea bookTypeTxt = null;
    
    private JTextArea bookTypeDescTxt = null;
    
    private DbUtil dbUtil = new DbUtil();
    
    private UserDao userDao = new UserDao();
  
    private BookTypeDao bookTypeDao = new BookTypeDao();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public BookTypeAddInterFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
        setBounds(100, 100, 450, 300);
        
        JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0");
        
        JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0");
        
        JList list = new JList();
        
         bookTypeTxt = new JTextArea();
        
         bookTypeDescTxt = new JTextArea();
        
        JButton btnNewButton = new JButton("\u6DFB\u52A0");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookTypeAddActionPerformed(e);
            }
        });
        
        JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetValueActionPerformed(e);
            }
        });
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(58)
                    .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addComponent(btnNewButton)
                        .addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                            .addComponent(lblNewLabel_1)
                            .addComponent(lblNewLabel)))
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                                .addComponent(bookTypeDescTxt)
                                .addComponent(bookTypeTxt, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(73)
                            .addComponent(btnNewButton_1)))
                    .addContainerGap(125, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(48)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel)
                        .addComponent(bookTypeTxt, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                    .addGap(10)
                    .addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
                    .addGap(28)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel_1)
                        .addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnNewButton)
                        .addComponent(btnNewButton_1))
                    .addGap(48))
        );
        getContentPane().setLayout(groupLayout);
        //设置文本框边框
        bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
    }
    protected void bookTypeAddActionPerformed(ActionEvent e)  {
        // TODO Auto-generated method stub
        String bookTypeName = this.bookTypeTxt.getText();
        String bookTypeDesc = this.bookTypeDescTxt.getText();
        if(StringUtil.isEmpty(bookTypeName)){
            JOptionPane.showMessageDialog(null, "图书类别不能为空");
            return;
        }
        BookType bookType = new BookType(bookTypeName,bookTypeDesc);
        Connection con = null;
        
        try {
            con = dbUtil.getCon();
           int n =  bookTypeDao.add(con, bookType);
           if(n==1){
               JOptionPane.showMessageDialog(null, "图书添加成功！");
               resetValue();
           }else{
               JOptionPane.showMessageDialog(null, "图书添加失败");
           }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            //logger.logp(Level.SEVERE, className, "bookTypeAddActionPerformed", "Error when...", e1);
            e1.printStackTrace();
            System.out.println("数据库连接失败");
        }finally{
            try {
                dbUtil.closeCon(con);
            } catch (Exception e2) {
                // TODO Auto-generated catch block
                //logger.logp(Level.SEVERE, className, "bookTypeAddActionPerformed", "Error when...", e1);
                e2.printStackTrace();
                System.out.println("断开数据库连接失败");
            }
        }
        
        
    }

    protected void resetValueActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        this.resetValue();
    }

    private void resetValue(){
        this.bookTypeDescTxt.setText("");
        this.bookTypeTxt.setText("");
        
    }
}
