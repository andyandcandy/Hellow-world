package com.java1234.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.java1234.dao.BookDao;
import com.java1234.dao.BookTypeDao;
import com.java1234.model.Book;
import com.java1234.model.BookType;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;
//import com.mysql.jdbc.ResultSet;


public class BookAddInterFrm extends JInternalFrame {
    private JTextField bookNameTxt;
    private JTextField authorTxt;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField priceTxt;

    private DbUtil dbUtil = new DbUtil();
    private BookTypeDao  bookTypeDao = new BookTypeDao();
    private BookDao bookDao = new BookDao();
    private JComboBox bookTypeJcb ;
    private JTextArea bookDescTxt;
    private JRadioButton manJrb;
    private JRadioButton femaleJrb;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    BookAddInterFrm frame = new BookAddInterFrm();
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
    public BookAddInterFrm() {
        setBounds(100, 100, 459, 337);
        
        JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0");
        
        JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005");
        
        bookNameTxt = new JTextField();
        bookNameTxt.setColumns(10);
        
        authorTxt = new JTextField();
        authorTxt.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("\u6027\u522B");
        
         manJrb = new JRadioButton("\u7537");
        manJrb.setSelected(true);
        buttonGroup.add(manJrb);
        
         femaleJrb = new JRadioButton("\u5973");
        buttonGroup.add(femaleJrb);
        
        JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66\u63CF\u8FF0");
        
        priceTxt = new JTextField();
        priceTxt.setColumns(10);
        
        JLabel label = new JLabel("\u56FE\u4E66\u4EF7\u683C");
        
         bookDescTxt = new JTextArea();
        
        JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B");
        
         bookTypeJcb = new JComboBox();
        
        JButton btnNewButton = new JButton("\u4FEE\u6539");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookAddActionperformed(e);
            }
        });
        
        JButton button = new JButton("\u91CD\u7F6E");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetValueActionPerformed(e);
            }
        });
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(41)
                            .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                .addComponent(label_1)
                                .addComponent(lblNewLabel_3)
                                .addComponent(lblNewLabel)
                                .addComponent(lblNewLabel_2, Alignment.LEADING)))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(83)
                            .addComponent(btnNewButton)))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                        .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                            .addComponent(button)
                            .addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                            .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(lblNewLabel_1)
                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                                .addComponent(manJrb)
                                .addGap(10)
                                .addComponent(femaleJrb)
                                .addGap(12)
                                .addComponent(label, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(44, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(46)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel)
                        .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel_1))
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(manJrb)
                            .addComponent(femaleJrb)
                            .addComponent(label)
                            .addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addComponent(lblNewLabel_2)
                            .addGap(18)))
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(14)
                            .addComponent(label_1)
                            .addGap(18)
                            .addComponent(lblNewLabel_3))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(18)
                            .addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(button)
                        .addComponent(btnNewButton))
                    .addContainerGap())
        );
        getContentPane().setLayout(groupLayout);
        
        //initial interface
        fillBookType();
        
      //设置文本框边框
        bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
   
    }
    /**
     * 充值事件处理
     * @param e
     */
    protected void resetValueActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        this.resetValue();
    }

    protected void bookAddActionperformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String bookName = this.bookNameTxt.getText();
        String author = this.authorTxt.getText();
        String price = this.priceTxt.getText();
        String bookDesc = this.bookDescTxt.getText();
        
        if(StringUtil.isEmpty(bookName)){
            JOptionPane.showMessageDialog(null, "图书不能为空");
            return;
        }
        if(StringUtil.isEmpty(author)){
            JOptionPane.showMessageDialog(null, " author不能为空");
            return;
        }
        if(StringUtil.isEmpty(price)){
            JOptionPane.showMessageDialog(null, " price不能为空");
            return;
        }
        if(StringUtil.isEmpty(bookDesc)){
            JOptionPane.showMessageDialog(null, " bookDesc不能为空");
            return;
        }
        String sex="";
        if(manJrb.isSelected()){
            sex = "男";
            
        }else if(femaleJrb.isSelected()){
        sex = "女";
        }
        BookType bookType = (BookType) bookTypeJcb.getSelectedItem();
        int bookTypeId = bookType.getId();
        
        Book book = new Book(bookName, author,sex, Float.parseFloat(price),bookTypeId,bookDesc);
        
//        Book(int id, String bookName, String author, String sex, Float price, Integer bookTypeId,
//                String bookTypeName, String bookDesc) {
        
        Connection con = null;
        try {
            con = dbUtil.getCon();
            int addNum = bookDao.add(con,book);
            if(addNum == 1){
                JOptionPane.showMessageDialog(null, "图书添加成功");
                resetValue();
            }else{
                JOptionPane.showMessageDialog(null, "图书添加失败");
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            //logger.logp(Level.SEVERE, className, "bookAddActionperformed", "Error when...", e1);
           e1.printStackTrace();
           JOptionPane.showMessageDialog(null, "图书添加失败");
        }finally{
            try{
            dbUtil.closeCon(con);
        }catch(Exception e2){
            e2.printStackTrace();
        }
      
        
        }
        
    }
    

    private void resetValue() {
        // TODO Auto-generated method stub
        this.bookNameTxt.setText("");
        this.authorTxt.setText("");
        this.priceTxt.setText("");
        this.manJrb.setSelected(true);
        this.bookDescTxt.setText("");
        if(this.bookTypeJcb .getItemCount()>0){
            this.bookTypeJcb.setSelectedIndex(0);
            }
        
    }

    

    private void fillBookType(){
        Connection con = null;
        BookType bookType = null;
       
        try{
            con = dbUtil.getCon();
            ResultSet rs = bookTypeDao.list(con, new BookType());
            while(rs.next()){
                bookType = new BookType();
                bookType.setId(rs.getInt("id"));
                bookType.setBookTypeName(rs.getString("bookTypeName"));
                this.bookTypeJcb.addItem(bookType);
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally
        {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
               // logger.logp(Level.SEVERE, className, "fillBookType", "Error when...", e);
                e.printStackTrace();
            }
        }
    }
}
