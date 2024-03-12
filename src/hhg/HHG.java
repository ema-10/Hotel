package hhg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HHG extends JFrame implements ActionListener {

    HHG() {
        setBounds(100, 100, 1200, 800);
        setLayout(null);
        getContentPane().setBackground(new Color(167, 213, 70));

        JPanel imagePanel = new JPanel();
        imagePanel.setBounds(300, 150, 600, 400);
        imagePanel.setOpaque(false);
        imagePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        imagePanel.setLayout(new BorderLayout());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image img = i1.getImage().getScaledInstance(590, 390, Image.SCALE_SMOOTH);
        i1 = new ImageIcon(img);
        JLabel image = new JLabel(i1);
        image.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        imagePanel.add(image, BorderLayout.CENTER);

        add(imagePanel);

        JButton next = new JButton("NEXT");
        next.setBounds(500, 550, 200, 40);
        next.setBackground(Color.WHITE);
        next.setForeground(new Color(167, 213, 70));
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.BOLD, 20));
        next.setBorder(BorderFactory.createLineBorder(new Color(167, 213, 70), 5));
        add(next);

        JLabel text = new JLabel("HHG MANAGEMENT SYSTEM");
        text.setBounds(300, 50, 600, 30);
        text.setForeground(Color.GRAY);
        text.setFont(new Font("serif", Font.BOLD, 36));
        text.setHorizontalAlignment(JLabel.CENTER);
        add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new HHG();
    }
}
