package hhg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;

    CustomerInfo() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = createLabel("Document Type", 40, 10, 100, 20);
        JLabel l2 = createLabel("Number", 160, 10, 100, 20);
        JLabel l3 = createLabel("Name", 290, 10, 100, 20);
        JLabel l4 = createLabel("Gender", 410, 10, 100, 20);
        JLabel l5 = createLabel("Country", 540, 10, 100, 20);
        JLabel l6 = createLabel("Room", 640, 10, 100, 20);
        JLabel l7 = createLabel("Checkin time", 760, 10, 100, 20);
        JLabel l8 = createLabel("Deposit", 900, 10, 100, 20);

        table = new JTable();
        table.setBounds(40, 40, 920, 400);
        table.setBackground(Color.WHITE);
        table.setForeground(new Color(167, 213, 73));
        table.setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(167, 213, 73));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setRowHeight(30);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();

        }

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420, 500, 120, 30);
        add(back);

        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setForeground(new Color(167, 213, 73));
        label.setFont(new Font("Arial", Font.BOLD, 14));
        add(label);
        return label;
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
}
