package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AboutUs extends JFrame implements ActionListener {
    JButton BackButton;
    JPanel p1, p2;
    HomePage home;  // Reference to the HomePage instance

    public AboutUs(HomePage home) {
        super("About Us");
        this.home = home;  // Assign HomePage instance
        this.setSize(550, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        // Main panel
        p1 = new JPanel();
        p1.setBounds(0, 0, 550, 400);
        p1.setBackground(Color.WHITE);
        p1.setLayout(null);

        // Footer panel
        p2 = new JPanel();
        p2.setBounds(0, 300, 550, 80);
        p2.setBackground(Color.WHITE);
        p2.setLayout(null);

        // About Us content
        JTextArea terms = new JTextArea();
        terms.setBounds(10, 0, 545, 300);
        terms.setBackground(Color.WHITE);
        terms.setText("\n" +
                     "                                    Welcome to Literary Delights\n" +
                     "  *At Literary Delights, we believe in the transformative power of literature. Our\n online bookshop is a haven for book enthusiasts, a virtual realm where stories come \n alive, ideas flourish, and literary wonders await exploration.\n" +
                     "                                  Join the Literary Delights Community\n" +
                     "   *Become a part of our community of literary enthusiasts. Follow us on social \n media. Together, let's celebrate the joy of reading and the magic that unfolds within the \n pages of a good book.\n" +
                     "   *Thank you for choosing Literary Delights Online Bookshop. We invite you to \n immerse yourself in the world of literature and discover the endless delights that\n await you.\n" +
                     "Happy Reading!\n" +
                     "The Literary Delights Team");
        terms.setEditable(false);
        terms.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        terms.setLineWrap(true);
        terms.setWrapStyleWord(true);

        p1.add(terms);

        // Back button
        BackButton = new JButton("BACK");
        BackButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        BackButton.setForeground(Color.BLACK);
        BackButton.setBounds(220, 5, 90, 30);
        BackButton.addActionListener(this);
        BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p2.add(BackButton);

        p1.add(p2);
        this.add(p1);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BackButton) {
            // Hide the AboutUs window and show the HomePage window
            this.setVisible(false);
            home.setVisible(true); // Show the HomePage again
        }
    }

    public static void main(String[] args) {
        // Assuming Login is a class that is already available
        Login login = new Login();  // Create a Login instance
        HomePage homePage = new HomePage(login);  // Initialize HomePage with Login

        // Now pass the HomePage instance to AboutUs constructor
        new AboutUs(homePage);  // Open the AboutUs page with HomePage reference
    }
}
