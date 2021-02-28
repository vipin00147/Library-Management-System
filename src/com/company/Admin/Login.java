package com.company.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JLabel label1, label2;
    JTextField emailField;
    JPasswordField passwordField;
    JButton loginButton, forgotButton, newAdmin;

    public void setComponents(){
        JFrame frame = new JFrame("Admin");
        label1 = new JLabel("Username: ");
        label2 = new JLabel("Password: ");
        emailField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        forgotButton = new JButton("Forgot?");
        newAdmin = new JButton("Create new Admin");

        label1.setBounds(20,150,100,30);
        label2.setBounds(20,180,100,30);
        emailField.setBounds(120,150,300,30);
        passwordField.setBounds(120,180,300,30);
        loginButton.setBounds(120,230,100,40);
        forgotButton.setBounds(220,230,100,40);
        newAdmin.setBounds(120,270,150,40);

        frame.add(label1);
        frame.add(label2);
        frame.add(emailField);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(forgotButton);
        frame.add(newAdmin);

        frame.getDefaultCloseOperation();
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
