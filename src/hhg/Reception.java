package hhg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {
    JButton newCustomer, rooms, department, update, allEmployee, customers, managerInfo, roomStatus, searchRoom, checkout, logout;

    Reception() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Button width
        int buttonWidth = 200;
        // Srazmjerno razmaci između gumba
        int windowHeight = 570;
        int buttonMargin = windowHeight / 25;

        newCustomer = createButton("New Customer Form", 580, buttonMargin, buttonWidth, 30);
        rooms = createButton("Rooms", 580, buttonMargin * 2 + 30, buttonWidth, 30);
        department = createButton("Department", 580, buttonMargin * 3 + 60, buttonWidth, 30);
        update = createButton("Update Status", 580, buttonMargin * 4 + 90, buttonWidth, 30);
        allEmployee = createButton("All Employee", 580, buttonMargin * 5 + 120, buttonWidth, 30);
        customers = createButton("Customer Info", 580, buttonMargin * 6 + 150, buttonWidth, 30);
        managerInfo = createButton("Manager Info", 580, buttonMargin * 7 + 180, buttonWidth, 30);
        checkout = createButton("Checkout", 580, buttonMargin * 8 + 210, buttonWidth, 30);
        roomStatus = createButton("Update Room Status", 580, buttonMargin * 9 + 240, buttonWidth, 30);
        searchRoom = createButton("Search Room", 580, buttonMargin * 10 + 270, buttonWidth, 30);
        logout = createButton("Logout", 580, buttonMargin * 11 + 300, buttonWidth, 30);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(10, 30, 500, 470);
        add(image);

        setBounds(350, 200, 800, windowHeight);
        setVisible(true);
    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(new Color(167, 213, 70));
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        add(button);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newCustomer) {
            setVisible(false);
            new AddCustomer();
        } else if (ae.getSource() == rooms) {
            setVisible(false);
            new Room();
        } else if (ae.getSource() == department) {
            setVisible(false);
            new Department();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateCheck();
        } else if (ae.getSource() == allEmployee) {
            setVisible(false);
            new EmployeeInfo();
        } else if (ae.getSource() == managerInfo) {
            setVisible(false);
            new ManagerInfo();
        } else if (ae.getSource() == customers) {
            setVisible(false);
            new CustomerInfo();
        } else if (ae.getSource() == roomStatus) {
            setVisible(false);
            new UpdateRoom();
        } else if (ae.getSource() == searchRoom) {
            setVisible(false);
            new SearchRoom();
        } else if (ae.getSource() == checkout) {
            setVisible(false);
            new Checkout();
        } else if (ae.getSource() == logout) {
            setVisible(false);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Reception();
    }
}
