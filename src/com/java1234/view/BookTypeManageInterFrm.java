package com.java1234.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;









import com.java1234.dao.BookDao;
import com.java1234.dao.BookTypeDao;
import com.java1234.model.BookType;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeManageInterFrm extends JInternalFrame {
    private JTable bookTypeTable;
    private DbUtil dbUtil = new DbUtil();
    private BookTypeDao bookTypeDao = new BookTypeDao();
    private JTextField s_bookTypeNameTxt;
    private JTextField idTxt;
    private JTextField bookTypeNameTxt;
    private JTextField bookTypeDescTxt;
    private BookDao bookDao = new BookDao();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    BookTypeManageInterFrm frame = new BookTypeManageInterFrm();
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
    public BookTypeManageInterFrm() {
        setIconifiable(true);
        setClosable(true);
        setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
        setBounds(100, 100, 562, 389);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               // bookTypeTableMousePressed(e);
            }
        });
        
        JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0");
        
        s_bookTypeNameTxt = new JTextField();
        s_bookTypeNameTxt.setColumns(10);
        
        JButton btnNewButton = new JButton("\u67E5\u8BE2");
       
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookTypeSearchActionPerformed(e);
            }
        });
        btnNewButton.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/search.png")));
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(30)
                            .addComponent(lblNewLabel)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(btnNewButton))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(114)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))))
                    .addContainerGap(50, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(23)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel)
                        .addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNewButton))
                    .addGap(18)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                    .addGap(29)
                    .addComponent(panel, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addContainerGap())
        );
        
        JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7");
        
        idTxt = new JTextField();
        idTxt.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0");
        
        bookTypeNameTxt = new JTextField();
        bookTypeNameTxt.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("\u63CF\u8FF0");
        
        bookTypeDescTxt = new JTextField();
        bookTypeDescTxt.setColumns(10);
        
        JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookTypeUpdateActionEvent( e);
            }
        });
        
        JButton btnNewButton_2 = new JButton("\u5220\u9664");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookTypeDeleteActionEvent(e);
            }
        });
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addComponent(lblNewLabel_1)
                            .addGap(18)
                            .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(29)
                            .addComponent(lblNewLabel_2)
                            .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addComponent(lblNewLabel_3)
                            .addGap(18)
                            .addComponent(bookTypeDescTxt, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))))
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(25)
                    .addComponent(btnNewButton_1)
                    .addPreferredGap(ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                    .addComponent(btnNewButton_2)
                    .addGap(83))
        );
        gl_panel.setVerticalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel_1)
                        .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel_2)
                        .addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel_3)
                        .addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                    .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnNewButton_1)
                        .addComponent(btnNewButton_2)))
        );
        panel.setLayout(gl_panel);
        
        bookTypeTable = new JTable();
        bookTypeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                bookTypeTableMousePressed(e);
            }
        });
        bookTypeTable.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
            }
        ));
        scrollPane.setViewportView(bookTypeTable);
        getContentPane().setLayout(groupLayout);

        this.fillTable(new BookType());
    }
    protected void bookTypeDeleteActionEvent(ActionEvent evt) {
        // TODO Auto-generated method stub
        String id= idTxt.getText();
        if(StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null, "请选择要删除的记录");
            return;
        }
        int n = JOptionPane.showConfirmDialog(null, "确定要删除该记录？");
        if(n==0){
            Connection con = null;
            try{
                con = dbUtil.getCon();
                boolean flag = bookDao.existBookByBookTypeId(con, id);
                if(flag){
                    JOptionPane.showMessageDialog(null, "当前图书类别下有图书,不能删除此类别");
                    return;
                        }
                
                int deleteNum = bookTypeDao.delete(con, id);
                if(deleteNum == 1){
                    JOptionPane.showMessageDialog(null, "删除成功");
                    this.resetValue();
                    this.fillTable(new BookType());
                    
                }else{
                    JOptionPane.showMessageDialog(null, "删除失败");
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    dbUtil.closeCon(con);
                }catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        }
    }

    protected void bookTypeUpdateActionEvent(ActionEvent evt) {
        // TODO Auto-generated method stub
        String id = idTxt.getText();
        String bookTypeName = bookTypeNameTxt.getText();
        String bookTypeDesc = bookTypeDescTxt.getText();
        if(StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null, "请选择要修改的记录");
            return;
        }
        BookType bookType = new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
        Connection con = null;
        try{
        con = dbUtil.getCon();
        int modifyNum = bookTypeDao.update(con, bookType);
        if(modifyNum == 1){
            JOptionPane.showMessageDialog(null, "修改成功");
            this.resetValue();
            this.fillTable(new  BookType());
            
        }else{
            JOptionPane.showMessageDialog(null,"修改失败");
        }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                dbUtil.closeCon(con);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private void resetValue() {
        // TODO Auto-generated method stub
        this.idTxt.setText("");
        this.bookTypeNameTxt.setText("");
        this.bookTypeDescTxt.setText("");
    }

    /**
     * 表格行选中处理
     * @param evt
     */
    protected void bookTypeTableMousePressed(MouseEvent evt) {
        // TODO Auto-generated method stub
        int row = bookTypeTable.getSelectedRow();
        idTxt.setText((String)bookTypeTable.getValueAt(row, 0));
        bookTypeNameTxt.setText((String)bookTypeTable.getValueAt(row, 1));
        bookTypeDescTxt.setText((String)bookTypeTable.getValueAt(row,2));
        
        
    }

    protected void bookTypeSearchActionPerformed(ActionEvent evt) {
        // TODO Auto-generated method stub
        String s_bookTypeName = this.s_bookTypeNameTxt.getText();
        BookType bookType = new BookType();
        bookType.setBookTypeName(s_bookTypeName);
        this.fillTable(bookType);
       
    }

    /**
     * 初始化表格
     * @param bookType
     */
    private void fillTable(BookType bookType){
        
        DefaultTableModel dtm = (DefaultTableModel) bookTypeTable.getModel();
        dtm.setRowCount(0);
        Connection con = null;
        try{
            con = dbUtil.getCon();
           // bookTypeDao.add(con, bookType);
          ResultSet rs = bookTypeDao.list(con, bookType);
          while(rs.next()){
              Vector v = new Vector();
              v.add(rs.getString("id"));
              v.add(rs.getString("bookTypeName"));
              v.add(rs.getString("bookTypeDesc"));
              
              dtm.addRow(v);
              
          }
          
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
               // logger.logp(Level.SEVERE, className, "fillTable", "Error when...", e);
                e.printStackTrace();
            }
        }
    }
}
