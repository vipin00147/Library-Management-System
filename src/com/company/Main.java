package com.company;

import com.company.Admin.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    JButton admin,librarian;
    JLabel label;
    JFrame frame;
    Main() {
        frame = new JFrame("LMS");
        admin = new JButton("Admin");
        label = new JLabel("Developed By Vipin Kumar",JLabel.CENTER);
        librarian = new JButton("Librarian");

        frame.add(admin);
        frame.add(librarian);
        frame.add(label);

        frame.setLayout(new GridLayout(3,1));

        frame.getDefaultCloseOperation();
        frame.setResizable(false);
        frame.setSize(500,500);
        frame.setVisible(true);

    }
    public void setEventListener(){
        admin.addActionListener(this);
        librarian.addActionListener(this);
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.setEventListener();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == admin) {
            frame.dispose();
            Login login = new Login();
            login.setComponents();
        }
        else if(e.getSource() == librarian) {
            JOptionPane.showMessageDialog(frame,"You clicked on Librarian Button","Librarian",JOptionPane.PLAIN_MESSAGE);
        }
    }
}
