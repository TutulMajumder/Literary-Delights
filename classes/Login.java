package classes;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.regex.Pattern;

public class Login extends JFrame implements ActionListener {

    private Font fontstyle1, fontstyle2;
    private JButton login, signup, forgotPass;
    private JTextField emailField;
    private JPasswordField passwordField;
    private String email_to_check;
    private JFrame f;
    private Cursor cursor;

    private int failedAttempts = 0;
    private static final int MAX_ATTEMPTS = 5;

    public String get_email() {
        return email_to_check;
    }

    public Login() {
        f = new JFrame("Login Screen");

        // Fonts
        fontstyle1 = new Font("Verdana", Font.BOLD, 36);
        fontstyle2 = new Font("Helvetica", Font.PLAIN, 15);

        // Cursor
        cursor = new Cursor(Cursor.HAND_CURSOR);

        JLabel emailLabel = new JLabel("Email Address");
        emailLabel.setBounds(670, 200, 273, 40);
        emailLabel.setFont(fontstyle2);

        emailField = new JTextField();
        emailField.setBounds(670, 240, 273, 40);
        emailField.setBorder(null);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(670, 290, 273, 40);
        passwordLabel.setFont(fontstyle2);

        passwordField = new JPasswordField();
        passwordField.setBounds(670, 330, 273, 40);
        passwordField.setBorder(null);

        login = new JButton("Login");
        login.setBounds(770, 410, 80, 30);
        login.setBorderPainted(false);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.GRAY);
        login.setIcon(new ImageIcon("Images\\Log In1.png"));
        login.setCursor(cursor);
        login.addActionListener(this);

        JLabel label1 = new JLabel("Login!");
        label1.setBounds(740, 140, 273, 60);
        label1.setFont(fontstyle1);

        JLabel label2 = new JLabel("Don't have an account?");
        label2.setBounds(690, 460, 170, 30);
        label2.setFont(fontstyle2);

        signup = new JButton("SignUp Now");
        signup.setBounds(825, 460, 115, 30);
        signup.setBorderPainted(false);
        signup.setForeground(Color.BLUE);
        signup.setOpaque(false);
        signup.setContentAreaFilled(false);
        signup.setCursor(cursor);
        signup.addActionListener(this);

        forgotPass = new JButton("Forgot password?");
        forgotPass.setBounds(785, 370, 200, 35);
        forgotPass.setBorderPainted(false);
        forgotPass.setForeground(Color.BLUE);
        forgotPass.setOpaque(false);
        forgotPass.setContentAreaFilled(false);
        forgotPass.setCursor(cursor);
        forgotPass.addActionListener(this);

        JLabel background = new JLabel("", new ImageIcon("Images//Login Logo.png"), JLabel.CENTER);
        background.setBounds(0, 0, 1070, 645);

        // Adding components
        f.add(passwordField);
        f.add(emailLabel);
        f.add(label1);
        f.add(label2);
        f.add(passwordLabel);
        f.add(login);
        f.add(signup);
        f.add(forgotPass);
        f.add(emailField);
        f.add(background);

        f.setSize(1080, 650);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill up all the fields");
                return;
            }

            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(this, "Please enter a valid email address.");
                return;
            }

            if (failedAttempts >= MAX_ATTEMPTS) {
                JOptionPane.showMessageDialog(this, "Too many failed attempts. Please try again later.");
                login.setEnabled(false);
                return;
            }

            String loginInfo = email + "," + password;
            String adminLoginInfo = "admin,admin";
            String employeeLoginInfo = "emp,emp1";

            boolean found = false;

            try (BufferedReader bfreader = new BufferedReader(new FileReader("AllTextFiles/UserInfo.txt"))) {
                bfreader.readLine(); // Skip header
                String line;

                while ((line = bfreader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length < 2) continue;

                    String Email = parts[0].trim();
                    String Password = parts[1].trim();
                    String userLoginInfo = Email + "," + Password;

                    if (loginInfo.equals(userLoginInfo)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    email_to_check = email;
                    f.setVisible(false);
                    new HomePage(this);
                } else if (loginInfo.equals(adminLoginInfo)) {
                    f.setVisible(false);
                    new Admin();
                } else if (loginInfo.equals(employeeLoginInfo)) {
                    f.setVisible(false);
                    new Admin();
                } else {
                    failedAttempts++;
                    JOptionPane.showMessageDialog(this, "Invalid email or password.");
                }

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "UserInfo.txt file not found.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error reading file.");
                ex.printStackTrace();
            }

        } else if (e.getSource() == signup) {
            f.setVisible(false);
            new SignUp();
        } else if (e.getSource() == forgotPass) {
            f.setVisible(false);
            JOptionPane.showMessageDialog(this, "Forgot password feature is not implemented yet.");
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }
}
