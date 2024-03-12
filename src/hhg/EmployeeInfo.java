package hhg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;

    EmployeeInfo() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = createLabel("Name", 40, 10, 100, 20);
        JLabel l2 = createLabel("Age", 170, 10, 100, 20);
        JLabel l3 = createLabel("Gender", 290, 10, 100, 20);
        JLabel l4 = createLabel("Job", 400, 10, 100, 20);
        JLabel l5 = createLabel("Salary", 540, 10, 100, 20);
        JLabel l6 = createLabel("Phone", 670, 10, 100, 20);
        JLabel l7 = createLabel("Email", 790, 10, 100, 20);
        JLabel l8 = createLabel("Id", 910, 10, 100, 20);

        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        table.setBackground(Color.WHITE);
        table.setForeground(new Color(167, 213, 70));
        table.setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(167, 213, 70));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setRowHeight(30);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();

        }

        back = createButton("Back", 420, 500, 120, 30);
        back.addActionListener(this);

        setBounds(300, 200, 1000, 600);
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
        new EmployeeInfo();
    }
}
