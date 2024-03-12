package hhg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JTextField tfroom, tfavailable, tfstatus, tfpaid, tfpending;
    JButton check, update, back;

    UpdateRoom() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = createLabel("Update Room Status", 30, 20, 250, 30);
        text.setFont(new Font("Tahoma", Font.PLAIN, 25));
        text.setForeground(new Color(167, 213, 70));
        
        JLabel lblid = createLabel("Customer Id", 30, 80, 100, 20);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblroom = createLabel("Room Number", 30, 130, 100, 20);
        
        tfroom = createTextField(200, 130, 150, 25);
        
        JLabel lblname = createLabel("Availability", 30, 180, 100, 20);
        
        tfavailable = createTextField(200, 180, 150, 25);
        
        JLabel lblcheckin = createLabel("Cleaning Status", 30, 230, 100, 20);
        
        tfstatus = createTextField(200, 230, 150, 25);
        
        check = createButton("Check", 30, 300, 100, 30);
        check.addActionListener(this);
        
        update = createButton("Update", 150, 300, 100, 30);
        update.addActionListener(this);
        
        back = createButton("Back", 270, 300, 100, 30);
        back.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);
        
        setBounds(300, 200, 980, 450);
        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setForeground(new Color(167, 213, 70));
        label.setFont(new Font("Arial", Font.BOLD, 14));
        add(label);
        return label;
    }

    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        add(textField);
        return textField;
    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(new Color(167, 213, 70));
        button.setForeground(Color.WHITE);
        add(button);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '" + id + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tfroom.setText(rs.getString("room"));
                }

                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '" + tfroom.getText() + "'");
                while (rs2.next()) {
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String status = tfstatus.getText();
           
            try {
                Conn c = new Conn();
                c.s.executeUpdate("update room set availability = '" + available + "', cleaning_status = '" + status + "' where roomnumber = '" + room + "'");
                
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                
                setVisible(false);
                new Reception();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}
