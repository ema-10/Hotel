package hhg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JTextField tfroom, tfname, tfcheckin, tfpaid, tfpending;
    JButton check, update, back;

    UpdateCheck() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = createLabel("Update Status", 90, 20, 200, 30);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
        
        JLabel lblroom = createLabel("Room Number", 30, 120, 100, 20);
        
        tfroom = createTextField(200, 120, 150, 25);
        
        JLabel lblname = createLabel("Name", 30, 160, 100, 20);
        
        tfname = createTextField(200, 160, 150, 25);
        
        JLabel lblcheckin = createLabel("Checkin Time", 30, 200, 100, 20);
        
        tfcheckin = createTextField(200, 200, 150, 25);
        
        JLabel lblpaid = createLabel("Amount Paid", 30, 240, 100, 20);
        
        tfpaid = createTextField(200, 240, 150, 25);
        
        JLabel lblpending = createLabel("Pending Amount", 30, 280, 120, 20);
        
        tfpending = createTextField(200, 280, 150, 25);
        
        check = createButton("Check", 30, 340, 100, 30);
        check.addActionListener(this);
        
        update = createButton("Update", 150, 340, 100, 30);
        update.addActionListener(this);
        
        back = createButton("Back", 270, 340, 100, 30);
        back.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 50, 500, 300);
        add(image);

        setBounds(300, 200, 980, 500);
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
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposit"));
                }

                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '" + tfroom.getText() + "'");
                while (rs2.next()) {
                    String price = rs2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                    tfpending.setText("" + amountPaid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposit = tfpaid.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room = '" + room + "', name = '" + name + "', checkintime = '"
                        + checkin + "', deposit = '" + deposit + "' where number = '" + number + "'");

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
        new UpdateCheck();
    }

}
