package hhg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {
    JTable table;
    JButton back;

    Room() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 500, 600);
        add(image);

        JLabel l1 = createLabel("Room Number", 10, 10, 100, 20);
        JLabel l2 = createLabel("Availability", 120, 10, 100, 20);
        JLabel l3 = createLabel("Status", 230, 10, 100, 20);
        JLabel l4 = createLabel("Price", 330, 10, 100, 20);
        JLabel l5 = createLabel("Bed Type", 410, 10, 100, 20);

        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        table.setBackground(Color.WHITE);
        table.setForeground(new Color(167, 213, 70));
        table.setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(167, 213, 70));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setRowHeight(30);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = createButton("Back", 200, 500, 120, 30);
        back.addActionListener(this);

        setBounds(300, 200, 1050, 600);
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

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(new Color(167, 213, 70));
        button.setForeground(Color.WHITE);
        add(button);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new Room();
    }
}
