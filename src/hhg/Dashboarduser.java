package hhg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboarduser extends JFrame implements ActionListener {

    Dashboarduser(String user) {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        JLabel text = new JLabel("WELCOME, " + user + "!");
        text.setBounds(665, 80, 500, 50);
        text.setFont(new Font("Tahoma", Font.PLAIN, 46));
        text.setForeground(new Color(167, 213, 70));
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);

        mb.setLayout(new FlowLayout(FlowLayout.CENTER));

        JMenu receptionMenu = new JMenu("RECEPTION");
        receptionMenu.setForeground(new Color(167, 213, 70));
        mb.add(receptionMenu);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        receptionMenu.add(reception);

        JMenuItem logout = new JMenuItem("LOGOUT");
        logout.addActionListener(this);
        mb.add(logout);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("RECEPTION")) {
            new Reception();
        } else if (ae.getActionCommand().equals("LOGOUT")) {
          
            new Login();
            dispose(); 
        }
    }

    public static void main(String[] args) {
        
    }
}
