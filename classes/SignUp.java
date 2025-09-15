package classes;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import javax.imageio.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

public class SignUp extends JFrame implements ActionListener {

	private Font fontstyle1;
	private Font fontstyle2;
	private JButton LoginButton;
	private JButton ConfirmButton;

	private JTextField UNameField;
	private JTextField FirstNameField;
	private JTextField LastNameField;
	private JTextField MobileNoField;
	private JTextField EmailField;
	private JPasswordField PasswordField;
	private JPasswordField RepasswordField;
	private Cursor cursor;
	// private JComboBox Gender_comboBox;

	private JLabel background;
	// private JCheckBox checkBox1;

	public FileWriter FW;

	private JFrame SignUpFrame;

	public SignUp() {
		SignUpFrame = new JFrame("SignUp Screen");

		// font
		fontstyle1 = new Font("Verdana", Font.BOLD, 36);
		fontstyle2 = new Font("Helvetica", Font.PLAIN, 15);

		// final JLabel label = new JLabel();
		// label.setBounds(750, 380, 200, 50);

		// Cursor for JButtons
		cursor = new Cursor(Cursor.HAND_CURSOR);

		// fisrt and last name

		JLabel FirstNameLabel = new JLabel("First name:");
		FirstNameLabel.setBounds(70, 150, 100, 30);
		FirstNameLabel.setFont(fontstyle2);
		FirstNameLabel.setForeground(Color.white);

		FirstNameField = new JTextField();
		FirstNameField.setBounds(70, 182, 180, 30);
		FirstNameField.setOpaque(false);
		FirstNameField.setForeground(Color.white);
		FirstNameField.setFont(fontstyle2);

		JLabel LastNameLabel = new JLabel("Last name:");
		LastNameLabel.setBounds(270, 150, 100, 30);
		LastNameLabel.setFont(fontstyle2);
		LastNameLabel.setForeground(Color.white);

		LastNameField = new JTextField();
		LastNameField.setBounds(270, 182, 180, 30);
		LastNameField.setOpaque(false);
		LastNameField.setForeground(Color.white);
		LastNameField.setFont(fontstyle2);

		// email

		JLabel EmailLabel = new JLabel("Email:");
		EmailLabel.setBounds(70, 220, 100, 30);
		EmailLabel.setFont(fontstyle2);
		EmailLabel.setForeground(Color.white);

		EmailField = new JTextField();
		EmailField.setBounds(70, 250, 380, 30);
		EmailField.setOpaque(false);
		EmailField.setForeground(Color.white);
		EmailField.setFont(fontstyle2);

		// Mobile no
		JLabel MobileNoLabel = new JLabel("Mobile Number:");
		MobileNoLabel.setBounds(70, 290, 150, 30);
		MobileNoLabel.setFont(fontstyle2);
		MobileNoLabel.setForeground(Color.white);

		MobileNoField = new JTextField();
		MobileNoField.setBounds(70, 322, 180, 30);
		MobileNoField.setOpaque(false);
		MobileNoField.setForeground(Color.white);
		MobileNoField.setFont(fontstyle2);
		/*
		 * //gender combobox
		 * JLabel GenderLabel = new JLabel("Gender");
		 * GenderLabel.setBounds(290, 320, 100, 30);
		 * GenderLabel.setFont(fontstyle2);
		 * GenderLabel.setForeground(Color.white);
		 * 
		 * String Gender[]={"Male", "Female", "Custom"};
		 * Gender_comboBox = new JComboBox(Gender);
		 * Gender_comboBox.setBounds(362, 322,90,25);
		 * Gender_comboBox.setOpaque(false);
		 */

		// username

		JLabel UNameLabel = new JLabel("User Name:");
		UNameLabel.setBounds(70, 355, 120, 30);
		UNameLabel.setFont(fontstyle2);
		UNameLabel.setForeground(Color.white);

		UNameField = new JTextField();
		UNameField.setBounds(70, 387, 180, 30);
		UNameField.setOpaque(false);
		UNameField.setForeground(Color.white);
		UNameField.setFont(fontstyle2);

		// password

		JLabel PasswordLabel = new JLabel("Password:");
		PasswordLabel.setBounds(70, 430, 100, 30);
		PasswordLabel.setFont(fontstyle2);
		PasswordLabel.setForeground(Color.white);

		PasswordField = new JPasswordField();
		PasswordField.setBounds(70, 460, 180, 30);
		PasswordField.setOpaque(false);
		PasswordField.setForeground(Color.white);
		PasswordField.setFont(fontstyle2);

		JLabel RepasswordLabel = new JLabel("Confirm Password:");
		RepasswordLabel.setBounds(270, 430, 180, 30);
		RepasswordLabel.setFont(fontstyle2);
		RepasswordLabel.setForeground(Color.white);

		RepasswordField = new JPasswordField();
		RepasswordField.setBounds(270, 460, 180, 30);
		RepasswordField.setOpaque(false);
		RepasswordField.setForeground(Color.white);
		RepasswordField.setFont(fontstyle2);

		// SignUp Form Label
		JLabel Label1 = new JLabel("Sign Up Form!");
		Label1.setBounds(150, 50, 300, 50);
		Label1.setFont(fontstyle1);
		Label1.setForeground(Color.white);

		JLabel Label2 = new JLabel("IT'S SIMPLE AND EASY");
		Label2.setBounds(210, 100, 500, 30);
		Label2.setFont(fontstyle2);
		Label2.setForeground(Color.white);

		// login label
		JLabel Label3 = new JLabel("Already Have an Account?");
		Label3.setBounds(150, 550, 180, 30);
		Label3.setFont(fontstyle2);
		Label3.setForeground(Color.white);

		// create button

		ConfirmButton = new JButton();
		ConfirmButton.setBounds(220, 510, 100, 30);
		ConfirmButton.setBorderPainted(false);
		ConfirmButton.setBackground(Color.BLACK);
		ConfirmButton.setForeground(Color.GRAY);
		ConfirmButton.setContentAreaFilled(false);
		ConfirmButton.setCursor(cursor);
		ImageIcon icon = new ImageIcon("Images\\Signup.png");
		ConfirmButton.setIcon(icon);
		ConfirmButton.addActionListener(this);

		LoginButton = new JButton("Log in");
		LoginButton.setBounds(332, 550, 100, 30);
		LoginButton.setBorderPainted(false);
		LoginButton.setOpaque(false);
		// LoginButton.setForeground(Color.decode("#002364"));

		LoginButton.setForeground(Color.white);
		LoginButton.setCursor(cursor);
		LoginButton.setContentAreaFilled(false);
		LoginButton.addActionListener(this);
		LoginButton.setFont(fontstyle2);

		/*
		 * JCheckBox checkBox1 = new JCheckBox("Accept Terms And Conditions");
		 * checkBox1.setBounds(110,480, 250,50);
		 * checkBox1.setFont(fontstyle2);
		 * checkBox1.setOpaque(false);
		 * checkBox1.setForeground(Color.white);
		 * checkBox1.setSelected(true);
		 * selected = checkBox1.isSelected();
		 */

		JLabel background;
		ImageIcon img = new ImageIcon("Images//Signup (2).png");
		background = new JLabel("", img, JLabel.CENTER);
		background.setBounds(0, 0, 1070, 645);

		// add components
		SignUpFrame.add(UNameLabel);
		SignUpFrame.add(UNameField);

		SignUpFrame.add(FirstNameLabel);
		SignUpFrame.add(FirstNameField);
		SignUpFrame.add(LastNameLabel);
		SignUpFrame.add(LastNameField);
		SignUpFrame.add(EmailLabel);
		SignUpFrame.add(EmailField);

		SignUpFrame.add(MobileNoLabel);
		SignUpFrame.add(MobileNoField);
		SignUpFrame.add(PasswordLabel);
		SignUpFrame.add(PasswordField);
		SignUpFrame.add(RepasswordLabel);
		SignUpFrame.add(RepasswordField);
		SignUpFrame.add(Label1);
		SignUpFrame.add(Label2);
		SignUpFrame.add(Label3);

		// SignUpFrame.add(GenderLabel);
		// SignUpFrame.add(Gender_comboBox);
		SignUpFrame.add(ConfirmButton);
		SignUpFrame.add(LoginButton);
		// SignUpFrame.add(checkBox1);
		SignUpFrame.add(background);

		// signup frame properties
		SignUpFrame.setSize(1080, 650);
		SignUpFrame.setLayout(null);
		SignUpFrame.setLocationRelativeTo(null);
		SignUpFrame.setVisible(true);
		SignUpFrame.setResizable(false);
		SignUpFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void ClearAll() {
		UNameField.setText("");
		FirstNameField.setText("");
		LastNameField.setText("");
		EmailField.setText("");
		MobileNoField.setText("");
		PasswordField.setText("");
		RepasswordField.setText("");
	}

	// ...existing code...

	public void actionPerformed(ActionEvent e) {
		String firstname = FirstNameField.getText().trim();
		String lastname = LastNameField.getText().trim();
		String username = UNameField.getText().trim();
		String pnumber = MobileNoField.getText().trim();
		String email = EmailField.getText().trim();
		String password = new String(PasswordField.getPassword());
		String repassword = new String(RepasswordField.getPassword());

		if (e.getSource() == ConfirmButton) {
			// Check for empty fields
			if (firstname.isEmpty() || lastname.isEmpty() || username.isEmpty() ||
					pnumber.isEmpty() || email.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
				JOptionPane.showMessageDialog(null, "One or more fields are empty");
				return;
			}

			// Email format validation
			if (!isValidEmail(email)) {
				JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
				return;
			}

			// Password strength validation
			if (!isStrongPassword(password)) {
				JOptionPane.showMessageDialog(null,
						"Password must be at least 8 characters, include a number and an uppercase letter.");
				return;
			}

			// Password match check
			if (!password.equals(repassword)) {
				JOptionPane.showMessageDialog(null, "The confirmation password does not match.");
				return;
			}

			// Check for duplicate email
			if (isEmailRegistered(email)) {
				JOptionPane.showMessageDialog(null, "This email is already registered.");
				return;
			}

			// Email format validation
			if (!isValidEmail(email)) {
				JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
				return;
			}

			// BD phone number validation
			if (!isValidBDPhone(pnumber)) {
				JOptionPane.showMessageDialog(null,
						"Please enter a valid  phone number (e.g., 017XXXXXXXX).");
				return;
			}

			// Prepare user info string
			String userInfo = email + "," +
					password + "," +
					username + "," +
					firstname + "," +
					lastname + "," +
					pnumber + "\n";

			try {
				File file = new File("AllTextFiles/UserInfo.txt");
				boolean fileExists = file.exists();
				boolean writeHeader = false;

				// If file doesn't exist or is empty, write header
				if (!fileExists || file.length() == 0) {
					writeHeader = true;
				}

				FW = new FileWriter(file, true);
				if (writeHeader) {
					FW.write("Email,Password,Username,FirstName,LastName,MobileNo\n");
				}
				FW.write(userInfo);
				FW.close();

				JOptionPane.showMessageDialog(null, "Sign up successful");
				SignUpFrame.setVisible(false);
				new Login();
				ClearAll();
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
			}
		} else if (e.getSource() == LoginButton) {
			SignUpFrame.setVisible(false);
			new Login();
		}
	}

	// Helper: Email format validation
	private boolean isValidEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		return java.util.regex.Pattern.matches(emailRegex, email);
	}

	// Helper: Password strength validation
	private boolean isStrongPassword(String password) {
		return password.length() >= 8 &&
				password.matches(".*[A-Z].*") &&
				password.matches(".*[0-9].*");
	}

	// Helper: Check for duplicate email
	private boolean isEmailRegistered(String email) {
		try (BufferedReader reader = new BufferedReader(new FileReader("AllTextFiles/UserInfo.txt"))) {
			String line = reader.readLine(); // skip header
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length > 0 && parts[0].trim().equalsIgnoreCase(email)) {
					return true;
				}
			}
		} catch (IOException ex) {
			// File might not exist yet, so ignore
		}
		return false;

	}

	private boolean isValidBDPhone(String phone) {
		// BD operators: 016,017,012,013,014,019,015 and total 11 digits
		return phone.matches("^(016|017|012|013|014|019|015)\\d{8}$");
	}

}
