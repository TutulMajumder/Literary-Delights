package classes;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

public class Admin extends JFrame implements ActionListener {

    private JFrame f;
    private JButton submit, back, remove;
    private Font fontstyle;
    private JTextField firstnameField;
    private JTextField lastnameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JComboBox<String> day;
    private JComboBox<String> month;
    private JComboBox<String> year;
    private JComboBox<String> gender;
    private JTable jt;
    private DefaultTableModel tblModel;
	FileWriter fw;
	BufferedWriter bw;
	
	
	String filePath = "AllTextFiles\\employee.txt";

    Admin() {

        f = new JFrame("Admin");
		

        fontstyle = new Font("cambria", Font.PLAIN, 16);

        submit = new JButton("Add Employee");
        submit.setBounds(360, 530, 190, 40);
        submit.addActionListener(this);

        back = new JButton("Log Out");
        back.setBounds(50, 530, 80, 30);
        back.addActionListener(this);

        remove = new JButton("Remove Employee");
        remove.setBounds(570, 530, 190, 40);
        remove.addActionListener(this);

        JLabel firstnameLabel = new JLabel("Name:");
        firstnameLabel.setBounds(20, 100, 120, 30);
        firstnameLabel.setFont(fontstyle);
		firstnameLabel.setForeground(Color.black);

        firstnameField = new JTextField();
        firstnameField.setBounds(20, 132, 200, 30);
      //  firstnameField.setOpaque(false);
        firstnameField.setFont(fontstyle);
        firstnameField.setToolTipText("Enter name");

        JLabel email = new JLabel("Email:");
        email.setBounds(247, 100, 150, 30);
        email.setFont(fontstyle);
		email.setForeground(Color.black);

        emailField = new JTextField();
        emailField.setBounds(247, 132, 200, 30);
       // emailField.setOpaque(false);
        emailField.setFont(fontstyle);
        emailField.setToolTipText("Enter email");

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(468, 100, 150, 30);
        passwordLabel.setFont(fontstyle);
		passwordLabel.setForeground(Color.black);

        passwordField = new JPasswordField();
        passwordField.setBounds(468, 132, 200, 30);
      //  passwordField.setOpaque(false);
        passwordField.setFont(fontstyle);
        passwordField.setToolTipText("Enter a strong password");

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(800, 100, 120, 30);
        dob.setFont(fontstyle);
		dob.setForeground(Color.black);

        String[] country = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
        day = new JComboBox<>(country);
        day.setBounds(800, 132, 90, 25);
       // day.setOpaque(false);

        String[] country1 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        month = new JComboBox<>(country1);
        month.setBounds(900, 132, 90, 25);
       // month.setOpaque(false);

        String[] country2 = {"1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"};
        year = new JComboBox<>(country2);
        year.setBounds(1000, 132, 90, 25);
       // year.setOpaque(false);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(685, 100, 120, 30);
        genderLabel.setFont(fontstyle);
		genderLabel.setForeground(Color.black);

        String[] country3 = {"Male", "Female"};
        gender = new JComboBox<>(country3);
        gender.setBounds(685, 132, 90, 25);
        gender.setOpaque(false);
		

        String[] column = {"First Name", "Email", "Password", "Gender", "Date of Birth", "Date and Time"};
        tblModel = new DefaultTableModel(column, 0);
        jt = new JTable(tblModel);
        JScrollPane sp = new JScrollPane(jt);
        sp.setBounds(50, 200, 1000, 300);
		
      //  String filePath = "AllTextFiles\employee.txt";
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("        ");
                tblModel.addRow(dataRow);
            }

        } catch (Exception ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon imageIcon = new ImageIcon("ng");
        Image image = imageIcon.getImage();

        JLabel background;
        ImageIcon img = new ImageIcon("Images\\Admint.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1106, 595);

        f.add(firstnameLabel);
        f.add(firstnameField);
        f.add(gender);
        f.add(genderLabel);
        f.add(email);
        f.add(emailField);
        f.add(passwordLabel);
        f.add(passwordField);
        f.add(dob);
        f.add(day);
        f.add(month);
        f.add(year);
        f.add(submit);
        f.add(sp);
        f.add(back);
        f.add(remove);
        f.setIconImage(image);
        f.add(background);

        f.setSize(1120, 630);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String name = firstnameField.getText();
            String emailid = emailField.getText();
            String password = passwordField.getText();
            String gender = (String) this.gender.getSelectedItem();
            String birthdate = (String) day.getSelectedItem() + "-" + (String) month.getSelectedItem() + "-" + (String) year.getSelectedItem();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String date = dtf.format(now);
            String[] data = {name, emailid, password, gender, birthdate, date};
            tblModel.addRow(data);
			

            if (name.equals("") || emailid.equals("") || password.equals("") || gender.equals("") || birthdate.equals("")) {
                JOptionPane.showMessageDialog(null, "One or more fields are empty");
            } else {
				
				
                try {
                    FileWriter fw = new FileWriter("AllTextFiles\\employee.txt");
                    BufferedWriter bw = new BufferedWriter(fw);

                    for (int i = 0; i < tblModel.getRowCount(); i++) {
                        for (int j = 0; j < tblModel.getColumnCount(); j++) {
                            bw.write(tblModel.getValueAt(i, j) + "        ");
                        }
                        bw.write("\n");
                    }

                    bw.close();
                    fw.close();
                    firstnameField.setText("");
                    emailField.setText("");
                    passwordField.setText("");
                    this.gender.setSelectedItem("");
                    day.setSelectedItem("");
                    month.setSelectedItem("");
                    year.setSelectedItem("");
                } catch (IOException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (e.getSource() == remove) {
        int selectedRow = jt.getSelectedRow();
        if (selectedRow != -1) {
            tblModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(null, "Selected row deleted successfully");

            try {
                FileWriter fw1 = new FileWriter("AllTextFiles\\employee.txt");
                BufferedWriter bw1 = new BufferedWriter(fw1);
                for (int i = 0; i < tblModel.getRowCount(); i++) {
                    for (int j = 0; j < tblModel.getColumnCount(); j++) {
                        bw1.write(tblModel.getValueAt(i, j) + "        ");
                    }
                    bw1.write("\n");
                }
                bw1.close();
                fw1.close();
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No row selected");
        }
    } else if (e.getSource() == back) {
            f.setVisible(false);
             Login a=new Login();
        }
    }
}