package hhg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton login, cancel;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        user.setForeground(new Color(167, 213, 73));
        add(user);

        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        username.setBorder(BorderFactory.createLineBorder(new Color(167, 213, 73)));
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        pass.setForeground(new Color(167, 213, 73));
        add(pass);

        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        password.setBorder(BorderFactory.createLineBorder(new Color(167, 213, 73)));
        add(password);

        login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(new Color(167, 213, 73));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFocusPainted(false);
        login.setBorderPainted(false);
        add(login);

    
        getRootPane().setDefaultButton(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(new Color(167, 213, 73));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFocusPainted(false);
        cancel.setBorderPainted(false);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        setBounds(500, 200, 600, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String user = username.getText();
            String pass = new String(password.getPassword());

            try {
                Conn c = new Conn();

                String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    if (user.equals("admin") && pass.equals("12345")) {
                        setVisible(false);
                        new Dashboard();
                    } else if (user.equals("user") && pass.equals("5678910")) {
                        setVisible(false);
                        new Dashboarduser(user);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
