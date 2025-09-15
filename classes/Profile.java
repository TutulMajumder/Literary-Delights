package classes;

import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.io.File; 
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException; 
import java.lang.*;
import java.awt.Color;


public class Profile extends JFrame implements ActionListener
{
	private JFrame ProfileFrame;
	
	private JLabel l1,l2,l3,l4,l7,l10,l11,l12,l13,
	Name_Label,Phone_Label, Email_Label,Balance_Label;
	private JButton BackButton,ChangePassButton;
	private JPanel p3;
	private Login login;
	private HomePage home_obj;
	private FileReader reader;
	private BufferedReader bfreader;
	private Cursor cursor;
	public static String Email ="";
	private String[] Info = new String[6];
	
	
	
    public  Profile(Login login, HomePage home_obj)
	{
	
	ProfileFrame=new JFrame("Profile");
		
		this.login=login;
		this.home_obj=home_obj;
		Email=this.login.get_email();
		
		//Cursor for JButtons
		 cursor = new Cursor(Cursor.HAND_CURSOR);
	
	// Fonts collection
	Font font30 = new Font("Cambria", Font.BOLD, 30);
	Font font25 = new Font("Cambria", Font.BOLD, 25);
	Font font20 = new Font("Cambria", Font.BOLD, 20);
	Font font15 = new Font("Cambria", Font.BOLD, 15);
	Font font12 = new Font("Cambria", Font.BOLD, 12);
	Font font36 = new Font("Verdana", Font.BOLD, 36);
	
	
	
	
	reader = null;
	bfreader = null;
	String line;
		
		try
		{
			reader = new FileReader("AllTextFiles/UserInfo.txt");
			bfreader = new BufferedReader(reader);

			while ((line = bfreader.readLine()) != null)
			{
				String[] parts = line.split(",");
				String email = parts[0];

				if (Email.equals(email))
				{
					Info = parts;
				}	
			}
			reader.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	
	
		
	p3 = new JPanel();
	p3.setBounds(0,0,1080,650);
	this.setLocationRelativeTo(null);
	p3.setBackground(Color.WHITE);
	//p3.setBackground(Color.decode("#99eaff"));
	p3.setLayout(null);
	
//JLabel
    l1 = new JLabel("Name");
	l1.setFont(font20);
	l1.setBounds(100,200,80,30);
	p3.add(l1);
	
	l10 = new JLabel(":");
	l10.setFont(font20);
	l10.setBounds(240,200,10,30);
	p3.add(l10);
	
    l2 = new JLabel("E-mail");
	l2.setFont(font20);
	l2.setBounds(100,250,100,30);
	p3.add(l2);
	
	l11 = new JLabel(":");
	l11.setFont(font20);
	l11.setBounds(240,250,10,30);
	p3.add(l11);
	
	l3 = new JLabel("Phone number");
	l3.setFont(font20);
	l3.setBounds(100,300,150,30);
	p3.add(l3);
	
	l13 = new JLabel(":");
	l13.setFont(font20);
	l13.setBounds(240,300,10,30);
	p3.add(l13);
	
	
	
			Name_Label= new JLabel(Info[2]);
			Name_Label.setBounds(300,200,200,30);
			Name_Label.setFont(font20);
			p3.add(Name_Label);
			
			
			Email_Label= new JLabel(Info[0]);
			Email_Label.setBounds(300,250,300,30);
			Email_Label.setFont(font20);
			p3.add(Email_Label);
			
			
			Phone_Label= new JLabel(Info[5]);
			Phone_Label.setBounds(300,300,200,30);
			Phone_Label.setFont(font20);
			p3.add(Phone_Label);
			
	
	
	
//JButton	
	ChangePassButton = new JButton("Change password");
	ChangePassButton .setFont(new Font("Segoe UI",Font.BOLD,15));
	ChangePassButton .setBounds(480,410,170,25);
	ChangePassButton .addActionListener(this);
	ChangePassButton .setFocusable(false);
	ChangePassButton.setCursor(cursor);
	p3.add(ChangePassButton );
	
    ImageIcon icon1 = new ImageIcon("Images/back.png");
    BackButton = new JButton(icon1);
	BackButton .setBounds(18,20,35,35);
	BackButton .addActionListener(this);
	BackButton .setFocusPainted(false);
    BackButton .setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
    BackButton .setContentAreaFilled(false);
	BackButton .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    p3.add(BackButton );	
	
	ImageIcon icon = new ImageIcon("Images/profile 127x127.png");
	JLabel l7 = new JLabel(icon);
	l7.setBounds(480,50,127,127);
	p3.add(l7);	
	
	//ProfileFrame Properties
	    ProfileFrame .setSize(1080, 650);
        ProfileFrame .setLayout(null);
        ProfileFrame .setLocationRelativeTo(null);
        ProfileFrame .setVisible(true);
		ProfileFrame .setResizable(false);
        ProfileFrame .setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	//ADD
	ProfileFrame.add(p3);
		
	
	
	
	}
	
	public void actionPerformed(ActionEvent e) {
        if(e.getSource()==BackButton)
		{
			ProfileFrame.setVisible(false);
            //home_obj.setVisible(true);
			new HomePage(login);
			
            
        }
		else if(e.getSource()==ChangePassButton)
		{
           
			this.setVisible(false);
			//new Changepass(this,login_obj);
			
        }
		
	}
	   
		
}