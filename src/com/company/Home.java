package com.company;

import com.company.panel.Panels;

import javax.swing.*;
import javax.swing.text.IconView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Home extends JFrame implements ActionListener {
    JButton new_book, issue_book, return_book, logout;
    JButton create_admin;
    Icon add_icon, issue_icon, return_icon, logout_icon, creat_admin_icon;
    JFrame frame;
    JPanel home_panel;

    Home(JFrame frame, JPanel home_panel) {
        this.frame = frame;
        this.home_panel = home_panel;

        home_panel.setBackground(Color.BLUE);

        add_icon = new ImageIcon("src/com/company/images/add_book.png");
        issue_icon = new ImageIcon("src/com/company/images/issue.png");
        return_icon = new ImageIcon("src/com/company/images/return.png");
        logout_icon = new ImageIcon("src/com/company/images/logout.png");
        creat_admin_icon = new ImageIcon("src/com/company/images/create_user.png");

        new_book = new JButton(add_icon);
        issue_book = new JButton(issue_icon);
        return_book = new JButton(return_icon);
        logout = new JButton(logout_icon);
        create_admin = new JButton(creat_admin_icon);

        home_panel.setLayout(null);
        home_panel.setSize(Main.width/2,Main.height);

        Panels.add_book_panel.setBackground(Color.RED);
        Panels.add_book_panel.setSize(Main.width/2, Main.height);
        Panels.add_book_panel.setLayout(null);


        setBounds();
        addToFrame();
        setActionListener();
    }

    private void setActionListener() {
        new_book.addActionListener(this);
        issue_book.addActionListener(this);
        return_book.addActionListener(this);
        create_admin.addActionListener(this);
        logout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == new_book){
            Panels.add_book_panel = new JPanel();

            Panels.add_book_panel.setBackground(Color.RED);
            Panels.add_book_panel.setSize(Main.width/2, Main.height);
            Panels.add_book_panel.setLayout(null);
            frame.setLayout(new GridLayout(1,2));

        }
        else if(e.getSource() == issue_book){

        }
        else if(e.getSource() == return_book){

        }
        else if(e.getSource() == create_admin){

        }
        else if(e.getSource() == logout){
            int option = JOptionPane.showConfirmDialog(this,"Are you sure you wish to logout?","Warning",JOptionPane.WARNING_MESSAGE,JOptionPane.YES_NO_CANCEL_OPTION,new ImageIcon("src/com/company/images/warning.png"));
            if(option == JOptionPane.OK_OPTION){
                home_panel.setVisible(false);
                Main.admin_panel.setVisible(true);
            }
        }
    }
    private void setBounds() {
        new_book.setBounds(40,40,170,170);
        issue_book.setBounds(220,40,170,170);
        return_book.setBounds(40,220,170,170);
        create_admin.setBounds(220,220,170,170);
        logout.setBounds(40,400,170,170);
    }
    private void addToFrame() {
        home_panel.add(new_book);
        home_panel.add(issue_book);
        home_panel.add(return_book);
        home_panel.add(logout);
        home_panel.add(create_admin);

        frame.setLayout(new GridLayout(1,2));
        frame.add(home_panel);
        frame.add(Panels.add_book_panel);
    }
}