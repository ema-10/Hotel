package hhg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back, submit;
    JComboBox<String> bedType;
    JCheckBox available;

    SearchRoom() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Search for Room");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        text.setForeground(new Color(167, 213, 70));

        add(text);

        JLabel lblbed = createLabel("BedType", 50, 100, 100, 20);

        bedType = new JComboBox<>(new String[] { "Single Bed", "Double Bed" });
        bedType.setBounds(150, 100, 150, 25);
        bedType.setBackground(Color.WHITE);
        add(bedType);

        available = new JCheckBox("Only display available");
        available.setBounds(650, 100, 200, 25);
        available.setBackground(Color.WHITE);
        add(available);

        JLabel l1 = createLabel("Room Number", 50, 160, 100, 20);
        JLabel l2 = createLabel("Availability", 270, 160, 100, 20);
        JLabel l3 = createLabel("Status", 450, 160, 100, 20);
        JLabel l4 = createLabel("Price", 670, 160, 100, 20);
        JLabel l5 = createLabel("Bed Type", 870, 160, 100, 20);

        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
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

        submit = createButton("Submit", 300, 520, 120, 30);
        submit.addActionListener(this);

        back = createButton("Back", 500, 520, 120, 30);
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
        if (ae.getSource() == submit) {
            try {
                String query1 = "select * from room where bed_type = '" + bedType.getSelectedItem() + "'";
                String query2 = "select * from room where availability = 'Available' AND bed_type = '"
                        + bedType.getSelectedItem() + "'";

                Conn conn = new Conn();
                ResultSet rs;
                if (available.isSelected()) {
                    rs = conn.s.executeQuery(query2);
                } else {
                    rs = conn.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
