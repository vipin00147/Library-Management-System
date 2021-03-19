package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Main extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4;
    JTextField emailField;
    JPasswordField passwordField;
    JButton loginButton, forgotButton;
    ImageIcon imageIcon;
    public static int width,height;
    public static JFrame frame = new JFrame("Login");
    public static JPanel admin_panel, home_panel;
    public static JPanel add_book,issue_book,
                    return_book, create_admin;

    public void setComponents(){
        admin_panel = new JPanel();
        home_panel = new JPanel();

        label1 = new JLabel("Username: ");
        label2 = new JLabel("Password: ");
        label4 = new JLabel("Developed by Vipin Kumar");
        label3 = new JLabel();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        forgotButton = new JButton("Forgot?");
        imageIcon = new ImageIcon("src/com/company/images/books.png");

        label1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        label2.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        label3.setIcon(imageIcon);
        label3.setBounds(20,20,300,300);
        label1.setBounds(400,90,100,30);
        label2.setBounds(400,120,100,30);
        emailField.setBounds(500,90,300,30);
        passwordField.setBounds(500,120,300,30);
        loginButton.setBounds(500,150,100,40);
        forgotButton.setBounds(600,150,100,40);

        label4.setBounds(550,600,200,30);

        admin_panel.add(label1);
        admin_panel.add(label2);
        admin_panel.add(emailField);
        admin_panel.add(passwordField);
        admin_panel.add(loginButton);
        admin_panel.add(forgotButton);
        admin_panel.add(label3);
        admin_panel.add(label4);
        frame.add(admin_panel);

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) size.getWidth();
        height = (int) size.getHeight();

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLayout(null);
        admin_panel.setLayout(null);
        admin_panel.setSize(width,height);
        frame.setSize(width,height);
        frame.setVisible(true);
    }

    private void setActionListener() {
        loginButton.addActionListener(this);
        forgotButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
            login();
        }
        else if(e.getSource() == forgotButton){

        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setComponents();
        main.setActionListener();
    }

    private void login() {
        String Username = emailField.getText();
        String Password = passwordField.getText();
        String user = "", pass = "";
        boolean flag = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/Vipin","root","root");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from admin");
            while (resultSet.next()){

                user = resultSet.getString(1);
                pass = resultSet.getString(2);

                if(user.equals(Username) && pass.equals(Password)){
                    flag = true;
                    break;
                }
            }

            if(flag){
                admin_panel.setVisible(false);
                home_panel.setVisible(true);
                new Home(frame, home_panel);

            }
            else {
                JOptionPane.showMessageDialog(this,"Wrong Input Credential","Error",JOptionPane.PLAIN_MESSAGE);
            }

            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}