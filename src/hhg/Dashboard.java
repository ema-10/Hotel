package hhg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    Dashboard() {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        JLabel text = new JLabel("WELCOME");
        text.setBounds(665, 80, 500, 50);
        text.setFont(new Font("Tahoma", Font.PLAIN, 46));
        text.setForeground(new Color(167, 213, 70));
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);

        mb.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(new Color(167, 213, 70));
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(new Color(167, 213, 70));
        mb.add(admin);

        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);

        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);

        JMenuItem logout = new JMenuItem("LOGOUT");
        logout.addActionListener(this);
        mb.add(logout);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee();
        } else if (ae.getActionCommand().equals("ADD ROOMS")) {
            new AddRooms();
        } else if (ae.getActionCommand().equals("RECEPTION")) {
            new Reception();
        } else if (ae.getActionCommand().equals("LOGOUT")) {
            
            new Login();
            dispose();
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
