package com.java1234.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.java1234.dao.BookDao;
import com.java1234.dao.BookTypeDao;
import com.java1234.model.Book;
import com.java1234.model.BookType;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class BookManageInterFrm extends JInternalFrame {
    private JTable bookTable;
    private JTextField s_bookNameTxt;
    private JTextField s_authorTxt;
    
    private DbUtil dbUtil=new DbUtil();
    private BookDao bookDao = new BookDao();

    private BookTypeDao bookTypeDao = new BookTypeDao();
    JComboBox s_bookTypejcb ;
    private JTextField idTxt;
    private JTextField priceTxt;
    private JTextField bookNameTxt;
    private JTextField authorTxt;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField bookDescTxt;
    private JRadioButton manJrb;
    private JRadioButton femaleJrb;
    
    private JComboBox bookTypeJcb;
    
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    BookManageInterFrm frame = new BookManageInterFrm();
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
    public BookManageInterFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u56FE\u4E66\u7BA1\u7406");
        setBounds(100, 100, 686, 412);
        
        JScrollPane scrollPane = new JScrollPane();
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setToolTipText("");
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                    .addGap(76)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                        .addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                            .addPreferredGap(ComponentPlacement.RELATED)))
                    .addGap(22))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 190, Short.MAX_VALUE)
                    .addContainerGap())
        );
        
        JLabel lblNewLabel_2 = new JLabel("\u7F16\u53F7");
        
        JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66\u540D\u79F0");
        
        JLabel lblNewLabel_4 = new JLabel("\u6027\u522B");
        
        JLabel lblNewLabel_5 = new JLabel("\u4EF7\u683C");
        
        JLabel lblNewLabel_6 = new JLabel("\u56FE\u4E66\u7C7B\u522B");
        
        JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005");
        
         manJrb = new JRadioButton("\u7537");
        buttonGroup.add(manJrb);
        
        JRadioButton femaleJrb = new JRadioButton("\u5973");
        buttonGroup.add(femaleJrb);
        
        idTxt = new JTextField();
        idTxt.setColumns(10);
        
        priceTxt = new JTextField();
        priceTxt.setColumns(10);
        
        bookNameTxt = new JTextField();
        bookNameTxt.setColumns(10);
        
        authorTxt = new JTextField();
        authorTxt.setColumns(10);
        
         bookTypeJcb = new JComboBox();
        
        JLabel lblNewLabel_7 = new JLabel("\u56FE\u4E66\u63CF\u8FF0");
        
        JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bookUpdateactionPerformed(evt);
            }
        });
        
        JButton btnNewButton_2 = new JButton("\u5220\u9664");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bookdeleteActionPerformed(evt);
            }
        });
        
        bookDescTxt = new JTextField();
        bookDescTxt.setColumns(10);
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
            gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblNewLabel_2)
                        .addComponent(lblNewLabel_5))
                    .addGap(18)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(24)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblNewLabel_3)
                        .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
                        .addGroup(gl_panel_1.createSequentialGroup()
                            .addComponent(lblNewLabel_4)
                            .addGap(18)
                            .addComponent(manJrb)
                            .addGap(16)
                            .addComponent(femaleJrb))
                        .addGroup(gl_panel_1.createSequentialGroup()
                            .addComponent(lblNewLabel_6)
                            .addGap(18)
                            .addComponent(bookTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGap(27))
                .addGroup(gl_panel_1.createSequentialGroup()
                    .addGap(19)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                            .addComponent(btnNewButton_1)
                            .addGap(47)
                            .addComponent(btnNewButton_2))
                        .addGroup(gl_panel_1.createSequentialGroup()
                            .addComponent(lblNewLabel_7)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(137, Short.MAX_VALUE))
        );
        gl_panel_1.setVerticalGroup(
            gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel_2)
                        .addComponent(femaleJrb)
                        .addComponent(manJrb, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel_4)
                        .addComponent(lblNewLabel_3)
                        .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel_5)
                        .addComponent(lblNewLabel_6)
                        .addComponent(label_1)
                        .addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(29)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel_7)
                        .addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnNewButton_1)
                        .addComponent(btnNewButton_2))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);
        
        JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0");
        
        s_bookNameTxt = new JTextField();
        s_bookNameTxt.setColumns(10);
        
        JLabel label = new JLabel("\u56FE\u4E66\u4F5C\u8005");
        
        s_authorTxt = new JTextField();
        s_authorTxt.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B");
        
        JButton btnNewButton = new JButton("\u67E5\u8BE2");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookSearchActionPerformed(e);
            }
        });
        
        s_bookTypejcb = new JComboBox();
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblNewLabel)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(label, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addGap(41)
                    .addComponent(lblNewLabel_1)
                    .addGap(36)
                    .addComponent(s_bookTypejcb, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    .addGap(44)
                    .addComponent(btnNewButton)
                    .addGap(22))
        );
        gl_panel.setVerticalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(5)
                    .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel)
                        .addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label)
                        .addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNewButton)
                        .addComponent(s_bookTypejcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel_1)))
        );
        panel.setLayout(gl_panel);
        
        bookTable = new JTable();
        bookTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent met) {
                bookTableMoudePressed(met);
            }
        });
        bookTable.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u63CF\u8FF0"
            }
        ));
        scrollPane.setViewportView(bookTable);
        getContentPane().setLayout(groupLayout);
        //设置边框
        bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
        this.fillBookType("search");
        this.fillBookType("modify");
        this.fillTable(new Book());
    }
    protected void bookdeleteActionPerformed(ActionEvent evt) {
        // TODO Auto-generated method stub
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
                
                int deleteNum = bookDao.delete(con, id);
                if(deleteNum == 1){
                    JOptionPane.showMessageDialog(null, "删除成功");
                    this.resetValue();
                    this.fillTable(new Book());
                    
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
        
    

    protected void bookUpdateactionPerformed(ActionEvent evt) {
        // TODO Auto-generated method stub
        String id = this.idTxt.getText();
        if(StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null, "请选择要修改的记录");
            return;
        }
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
        String sex="";
        if(manJrb.isSelected()){
            sex = "男";
            
        }else if(femaleJrb.isSelected()){
        sex = "女";
        }
        BookType bookType = (BookType) bookTypeJcb.getSelectedItem();
        int bookTypeId = bookType.getId();
        
        Book book = new Book(Integer.parseInt(id), bookName,  author,  sex, Float.parseFloat(price),  bookTypeId,  bookDesc);
        
        Connection con = null;
        try {
            con = dbUtil.getCon();
            int addNum = bookDao.update(con,book);
            if(addNum == 1){
                JOptionPane.showMessageDialog(null, "图书修改成功");
                resetValue();
                this.fillTable(new Book());
            }else{
                JOptionPane.showMessageDialog(null, "图书修改失败");
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            //logger.logp(Level.SEVERE, className, "bookAddActionperformed", "Error when...", e1);
           e1.printStackTrace();
           JOptionPane.showMessageDialog(null, "图书修改失败");
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
        this.idTxt.setText("");
        this.bookNameTxt.setText("");
        this.authorTxt.setText("");
        this.priceTxt.setText("");
        this.manJrb.setSelected(true);
        this.bookDescTxt.setText("");
        if(this.bookTypeJcb .getItemCount()>0){
            this.bookTypeJcb.setSelectedIndex(0);
            }
        
    }

    

    protected void bookTableMoudePressed(MouseEvent met) {
        // TODO Auto-generated method stub
        int row = this.bookTable.getSelectedRow();
        this.idTxt.setText((String)bookTable.getValueAt(row, 0));
        this.bookNameTxt.setText((String)bookTable.getValueAt(row, 1));
        this.authorTxt.setText((String)bookTable.getValueAt(row, 2));
        String sex = (String) bookTable.getValueAt(row, 3);
        if("男".equals(sex)){
            this.manJrb.setSelected(true);
            
        }else if("女".equals(sex)){
        this.femaleJrb.setSelected(true);
    }
        //this.priceTxt.setText((Float)bookTable.getValueAt(row, 4)+"");
        this.priceTxt.setText(bookTable.getValueAt(row, 4)+"");
        this.bookDescTxt.setText((String)(bookTable.getValueAt(row, 5)));
        String bookTypeName = (String) this.bookTable.getValueAt(row, 6);
        
        int n = this.bookTypeJcb.getItemCount();
        for (int i = 0 ; i<n; i++){
            BookType item = (BookType)this.bookTypeJcb.getItemAt(i);
            if(item.getBookTypeName().equals(bookTypeName)){
                this.bookTypeJcb.setSelectedIndex(i);
            }
        }
        
    }

    /**
     * 图书查询
     * @param e
     */
    protected void bookSearchActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String bookName = this.s_bookNameTxt.getText();
        String author = this.s_authorTxt.getText();
        BookType bookType = (BookType) this.s_bookTypejcb.getSelectedItem();
        int bookTypeId = bookType.getId();
        Book book = new Book(bookName,author,bookTypeId);
        this.fillTable(book);;
    }

    private void fillBookType(String type){
        Connection con =null;
        BookType bookType = null;
        try{
            con=dbUtil.getCon();
        
        ResultSet rs = bookTypeDao.list(con, new  BookType());
        if("search".equals(type)){
        bookType = new BookType();
        bookType.setBookTypeName("请选择。。。");
        bookType.setId(-1);
        this.s_bookTypejcb.addItem(bookType);
        }
        while(rs.next()){
            bookType = new BookType();
            bookType.setBookTypeName(rs.getString("bookTypeName"));
            bookType.setId(rs.getInt("id"));
                if("search".equals(type)){
                    this.s_bookTypejcb.addItem(bookType);
                }else if("modify".equals(type)){
                    this.bookTypeJcb.addItem(bookType);
                }
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
    /**
     * 初始化表格
     * @param bookType
     */
    private void fillTable(Book book){
        
        DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
        dtm.setRowCount(0);
        Connection con = null;
        try{
            con = dbUtil.getCon();
           // bookTypeDao.add(con, bookType);
          ResultSet rs = bookDao.list(con, book);
          while(rs.next()){
              Vector v = new Vector();
              v.add(rs.getString("id"));
              v.add(rs.getString("bookName"));
              v.add(rs.getString("author"));
              v.add(rs.getString("sex"));
              v.add(rs.getString("price"));
              v.add(rs.getString("bookDesc"));
              v.add(rs.getString("bookTypeName"));
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
