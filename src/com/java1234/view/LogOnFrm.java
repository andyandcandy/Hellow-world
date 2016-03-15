package com.java1234.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.java1234.dao.UserDao;
import com.java1234.model.User;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;


public class LogOnFrm extends JFrame {

    private JPanel contentPane;
    private JTextField userNameTxt;
    private JPasswordField passwordTxt;

    private DbUtil dbUtil = new DbUtil();
    private UserDao userDao = new UserDao();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    LogOnFrm frame = new LogOnFrm();
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
    public LogOnFrm() {
        //改变默认字体的代码
      //改变系统默认字体
    Font font = new Font("Dialog", Font.PLAIN, 12);
    java.util.Enumeration keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
        Object key = keys.nextElement();
        Object value = UIManager.get(key);
        if (value instanceof javax.swing.plaf.FontUIResource) {
            UIManager.put(key, font);
        }
    }
        
        
        setResizable(false);
        setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 425, 342);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
        lblNewLabel.setFont(new Font("FZLanTingHeiS-UL-GB", Font.BOLD, 16));
        
        JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
        lblNewLabel_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/userName.png")));
        
        JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801");
        lblNewLabel_2.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/password.png")));
        
        userNameTxt = new JTextField();
        userNameTxt.setColumns(10);
        
        passwordTxt = new JPasswordField();
        
        JButton btnNewButton = new JButton("\u767B\u5F55");
        btnNewButton.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/login.png")));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginaActionPerformed( e);
            }
        });
        
        JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetValueActionPerformed( e);
            }
        });
        btnNewButton_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/reset.png")));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(141)
                            .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(71)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(lblNewLabel_2))
                                    .addGap(18)
                                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(passwordTxt)
                                        .addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addComponent(btnNewButton)
                                    .addGap(53)
                                    .addComponent(btnNewButton_1)))))
                    .addContainerGap(132, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(62)
                    .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    .addGap(34)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel_1)
                        .addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(33)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel_2)
                        .addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnNewButton)
                        .addComponent(btnNewButton_1))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
        //设置jfram居中显示
        this.setLocationRelativeTo(null);
    }
    /**
     * 登录时间处理
     * @param e
     */
    protected void loginaActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String userName= this.userNameTxt.getText();
        String passWord = new String(this.passwordTxt.getPassword());
        if(StringUtil.isEmpty(userName)){
            JOptionPane.showMessageDialog(null, "用户名不能为空");
            return;
        }
        if(StringUtil.isEmpty(passWord)){
            JOptionPane.showMessageDialog(null, "密码不能为空");
            return;
        }
        User user = new User(userName,passWord);
        Connection con = null;
        try {
            con = dbUtil.getCon();
            User currentUser = userDao.login(con, user);
            if(currentUser!=null){
                dispose();
//                MainFrm t =  new MainFrm();
//                t.setVisible(true);
                new MainFrm().setVisible(true);
                //JOptionPane.showMessageDialog(null, "登陆成功");
                
            }else{
                JOptionPane.showMessageDialog(null, "登录失败");
            }
            
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            //logger.logp(Level.SEVERE, className, "loginaActionPerformed", "Error when...", e1);
            
        }finally{
            
            try {
                dbUtil.closeCon(con);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
               // logger.logp(Level.SEVERE, className, "loginaActionPerformed", "Error when...", e1);
                System.out.println("数据库关闭失败");
            }
        }
       
        
    }

/**
 * 重置事件处理
 * @param e
 */
    protected void resetValueActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        this.userNameTxt.setText("");
        this.passwordTxt.setText("");
        
    }
}
