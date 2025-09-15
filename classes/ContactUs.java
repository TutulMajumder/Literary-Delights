package classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ContactUs extends JFrame implements ActionListener {
    private JButton BackButton;
    private JPanel p, p1, p2, p3, p4;
    private HomePage home;

    public ContactUs(HomePage home) {
        super("Contact Us");
        this.home = home; // Use the existing HomePage instance
        this.setSize(1080, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        p = new JPanel();
        p.setBounds(0, 0, 1080, 650);
        this.setLocationRelativeTo(null);
        p.setBackground(Color.decode("#f3f3f3"));
        p.setLayout(null);

        // Panels for contact information
        p1 = new JPanel();
        p1.setBounds(150, 100, 150, 125);
        p1.setLayout(null);
        p.add(p1);

        p2 = new JPanel();
        p2.setBounds(350, 100, 150, 125);
        p2.setLayout(null);
        p.add(p2);

        p3 = new JPanel();
        p3.setBounds(550, 100, 150, 125);
        p3.setLayout(null);
        p.add(p3);

        p4 = new JPanel();
        p4.setBounds(750, 100, 170, 125);
        p4.setLayout(null);
        p.add(p4);

        // "Contact Us" title label
        JLabel headerLabel = new JLabel("CONTACT US");
        headerLabel.setBounds(400, 30, 240, 30);
        headerLabel.setBackground(Color.BLACK);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 30));
        p.add(headerLabel);

        // Office Address Information
        JLabel l1 = new JLabel("Office");
        l1.setBounds(53, 50, 100, 25);
        l1.setFont(new Font("Serif", Font.BOLD, 15));
        p1.add(l1);

        JLabel l2 = new JLabel("Kuratoli, Dhaka");
        l2.setBounds(25, 70, 120, 25);
        l2.setFont(new Font("Serif", Font.BOLD, 15));
        p1.add(l2);

        // Phone Information
        JLabel l3 = new JLabel("Phone number");
        l3.setBounds(30, 50, 110, 25);
        l3.setFont(new Font("Serif", Font.BOLD, 15));
        p2.add(l3);

        JLabel l4 = new JLabel("01835151459");
        l4.setBounds(33, 70, 110, 25);
        l4.setFont(new Font("Serif", Font.BOLD, 15));
        p2.add(l4);

        // Email Information
        JLabel l5 = new JLabel("E-mail");
        l5.setBounds(50, 50, 80, 25);
        l5.setFont(new Font("Serif", Font.BOLD, 15));
        p3.add(l5);

        JLabel l6 = new JLabel("mrlesnar@gmail.com");
        l6.setBounds(18, 70, 200, 25);
        l6.setFont(new Font("Serif", Font.BOLD, 13));
        p3.add(l6);

        // Facebook Information
        JLabel l7 = new JLabel("Facebook");
        l7.setBounds(50, 50, 200, 25);
        l7.setFont(new Font("Serif", Font.BOLD, 13));
        p4.add(l7);

        JLabel l8 = new JLabel("https://www.facebook.com/tutul11tmt");
        l8.setBounds(5, 70, 300, 20);
        l8.setFont(new Font("Serif", Font.BOLD, 10));
        p4.add(l8);

        // Back Button with an icon
        ImageIcon backIcon = new ImageIcon("Images/back.png");
        BackButton = new JButton(backIcon);
        BackButton.setBounds(18, 20, 35, 35);
        BackButton.addActionListener(this);
        BackButton.setFocusPainted(false);
        BackButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        BackButton.setContentAreaFilled(false);
        BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p.add(BackButton);

        // Add everything to the frame
        this.add(p);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BackButton) {
            // Hide the current ContactUs frame and show HomePage
            this.setVisible(false);
            home.setVisible(true); // Show the existing HomePage instance
        }
    }
}
