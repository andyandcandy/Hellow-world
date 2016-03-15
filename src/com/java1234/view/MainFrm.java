package com.java1234.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainFrm extends JFrame {

    private JPanel contentPane;

    private JDesktopPane table;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    MainFrm frame = new MainFrm();
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
    public MainFrm() {
        setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
        mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
        menuBar.add(mnNewMenu);
        
        JMenu mnNewMenu_2 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
        mnNewMenu.add(mnNewMenu_2);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookTypeAddInterFrm bookTypeAddInterFrm = new BookTypeAddInterFrm();
                bookTypeAddInterFrm.setVisible(true);
                table.add(bookTypeAddInterFrm);
            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_1);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookTypeManageInterFrm bookTypeManageInterFrm = new BookTypeManageInterFrm();
                bookTypeManageInterFrm.setVisible(true);
                table.add(bookTypeManageInterFrm);
            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_2);
        
        JMenu mnNewMenu_3 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
        mnNewMenu.add(mnNewMenu_3);
        
        JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
        mntmNewMenuItem_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookAddInterFrm bookAddInterFrm = new BookAddInterFrm();
                bookAddInterFrm.setVisible(true);
                table.add(bookAddInterFrm);
            }
        });
        mnNewMenu_3.add(mntmNewMenuItem_6);
        
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookManageInterFrm bookManageInterFrm = new BookManageInterFrm();
                bookManageInterFrm.setVisible(true);
                table.add(bookManageInterFrm);
            }
        });
        mnNewMenu_3.add(mntmNewMenuItem_3);
        
        JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
                System.out.println(result);
             //   if(result )
            }
        });
        mnNewMenu.add(mntmNewMenuItem_4);
        
        JMenu mnNewMenu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
        mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
        menuBar.add(mnNewMenu_1);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("\u5173\u4E8Ejava1234");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Java1234InterFrm java1234InterFrm = new Java1234InterFrm();
                java1234InterFrm.setVisible(true);
                table.add(java1234InterFrm);
            }
        });
        mnNewMenu_1.add(mntmNewMenuItem);
        contentPane = new JPanel();
        contentPane.setToolTipText("");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
         table = new JDesktopPane();
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                    .addComponent(table, GroupLayout.PREFERRED_SIZE, 1379, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(table, GroupLayout.PREFERRED_SIZE, 684, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
        //设置jframe最大化
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
