package hhg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;

    Department() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = createLabel("Department", 180, 10, 100, 20);
        JLabel l2 = createLabel("Budget", 420, 10, 100, 20);

        table = new JTable();
        table.setBounds(0, 50, 700, 350);
        table.setBackground(Color.WHITE);
        table.setForeground(new Color(167, 213, 70));
        table.setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(167, 213, 70));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setRowHeight(30);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();

        }

        back = createButton("Back", 280, 400, 120, 30);
        back.addActionListener(this);

        setBounds(400, 200, 700, 480);
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
        new Department();
    }
}
