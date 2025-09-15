package classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DramaF extends JFrame implements ActionListener
{
	private JFrame DramaFrame;
	
	// Fonts collection
	Font font30 = new Font("Cambria", Font.BOLD, 30);
	Font font25 = new Font("Cambria", Font.BOLD, 25);
	Font font20 = new Font("Cambria", Font.BOLD, 20);
	Font font15 = new Font("Cambria", Font.BOLD, 15);
	Font font12 = new Font("Cambria", Font.BOLD, 12);
	Font font36 = new Font("Verdana", Font.BOLD, 36);
	
	Cursor cursor;
	
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	private JButton BackButton;
	private JButton B7,B8,B9,B10,B11,B12;
	
	private HomePage home;
	private Login login;
	
	private JPanel p1;
	
	
	

		
	public DramaF(HomePage home,Login login)
	{
		DramaFrame=new JFrame(" DRAMA FRAME ");
		
		
		
		
		this.home=home;
		this.login=login;
		//Email_Address=login_obj.get_email();
		
		//Cursor for JButtons
		 cursor = new Cursor(Cursor.HAND_CURSOR);
		
		/*//Title
	    JLabel TitleLabel1=new JLabel("LITERARY");
		//TitleLabel1.setOpaque(true);
		TitleLabel1.setBounds(75,0,300,50);
		TitleLabel1.setFont(font25);
		
		JLabel TitleLabel2=new JLabel("DELIGHTS");
		//TitleLabel2.setOpaque(true);
		TitleLabel2.setBounds(30,30,300,50);
		TitleLabel2.setFont(font36);*/
	
		
		
		
    p1 = new JPanel();
		p1.setBounds(0,0,1080,650);
		//p1.setBackground(Color.decode("#99eaff"));
		p1.setBackground(Color.WHITE);
		this.setLocationRelativeTo(null);
		p1.setLayout(null);
	
    //JLabel			
		l2 = new JLabel("DRAMA");
		l2.setBounds(50,60,500,25);
		l2.setFont(font30);
		p1.add(l2);
		
		l3 = new JLabel();
		l3.setBounds(150,300,500,15);
		l3.setFont(font15);
		p1.add(l3);
		
		l4 = new JLabel();
		l4.setBounds(190,320,200,15);
		l4.setFont(font15);
		p1.add(l4);
		
		l5 = new JLabel();
		l5.setBounds(490,300,500,15);
		l5.setFont(font15);
		p1.add(l5);
		
		l7 = new JLabel();
		l7.setBounds(510,320,200,15);
		l7.setFont(font15);
		p1.add(l7);
		
		l6 = new JLabel();
		l6.setBounds(170,535,500,15);
		l6.setFont(font15);
		p1.add(l6);
		
		l8 = new JLabel();
		l8.setBounds(200,555,500,15);
		l8.setFont(font15);
		p1.add(l8);
		
		l1 = new JLabel();
		l1.setBounds(490,535,500,16);
		l1.setFont(font15);
		p1.add(l1);
		
		l9 = new JLabel();
		l9.setBounds(510,555,500,15);
		l9.setFont(font15);
		p1.add(l9);
	
		
		
		
	

		
		
	//BackButton
	    BackButton=new JButton();
        BackButton.setBounds(920, 60, 100, 40);
        BackButton.setBorderPainted(false);
		BackButton.setContentAreaFilled(false);
		BackButton.setCursor(cursor);
		ImageIcon icon3 = new ImageIcon("Images\\BackF.png");
        BackButton.setIcon(icon3);
		BackButton.addActionListener(this);
		p1.add(BackButton);
		
		
		
		//Book  Button
		B7=new JButton();
        B7.setBounds(100, 200, 122, 186);
		B7.setCursor(cursor);
		ImageIcon icon17 = new ImageIcon("Images\\B11.JPG");
        B7.setIcon(icon17);
		B7.setBorderPainted(false);
		B7.setContentAreaFilled(true);
		//B1.setFocusable(false);
		B7.addActionListener(this);
		p1.add(B7);
		
		B8=new JButton();
        B8.setBounds(350, 200,122, 186);
		B8.setCursor(cursor);
		ImageIcon icon18 = new ImageIcon("Images\\B12.JPG");
        B8.setIcon(icon18);
		B8.setBorderPainted(false);
		B8.setContentAreaFilled(true);
		//B1.setFocusable(false);
		B8.addActionListener(this);
		p1.add(B8);
		
		B9=new JButton();
        B9.setBounds(600, 200, 122, 186);
		B9.setCursor(cursor);
		ImageIcon icon19 = new ImageIcon("Images\\B13.JPG");
        B9.setIcon(icon19);
		B9.setBorderPainted(false);
		B9.setContentAreaFilled(true);
		//B1.setFocusable(false);
		B9.addActionListener(this);
		p1.add(B9);
		
		
		B10=new JButton();
        B10.setBounds(858, 200, 122, 186);
		B10.setCursor(cursor);
		ImageIcon icon20 = new ImageIcon("Images\\B23.JPG");
        B10.setIcon(icon20);
		B10.setBorderPainted(false);
		B10.setContentAreaFilled(true);
		//B1.setFocusable(false);
		B10.addActionListener(this);
		p1.add(B10);
		
		/*B11=new JButton();
        B11.setBounds(730, 370, 122, 186);
		B11.setCursor(cursor);
		ImageIcon icon21 = new ImageIcon("Images\\B11.JPG");
        B11.setIcon(icon21);
		B11.setBorderPainted(false);
		B11.setContentAreaFilled(true);
		//B1.setFocusable(false);
		B11.addActionListener(this);
		p1.add(B11);
		
		B12=new JButton();
        B12.setBounds(900, 370, 122, 186);
		B12.setCursor(cursor);
		ImageIcon icon22 = new ImageIcon("Images\\B12.JPG");
        B12.setIcon(icon22);
		B12.setBorderPainted(false);
		B12.setContentAreaFilled(true);
		//B1.setFocusable(false);
		B12.addActionListener(this);
		p1.add(B12);*/
		
		
		
		
		
		for(int i=0; i<home.info.length && i<4; i++)
				{
					
					if(home.info[i]!=null)
					{
						 String sp[] = home.info[i].split("/");
						 if(sp[1].equals("11"))
						 {
						    l3.setText(sp[0]);
							l4.setText("BDT "+sp[2]+"tk");
							
						 }
						else if(sp[1].equals("12"))
						 {
						    l5.setText(sp[0]);
							l7.setText("BDT "+sp[2]+"tk");
							
						 }
						 else if(sp[1].equals("13"))
						 {
						    l6.setText(sp[0]);
							l8.setText("BDT "+sp[2]+"tk");
							
						 }
						  else if(sp[1].equals("14"))
						 {
						    l1.setText(sp[0]);
							l9.setText("BDT "+sp[2]+"tk");
							
						 }
					}
					
				}
				
		
		
	

	

    //panel add in frame
	DramaFrame.add(p1);
	
	
	
	
	

	
	
	
		
		
		
		
		//DramaFrame Properties
	     DramaFrame.setSize(1080, 650);
         DramaFrame.setLayout(null);
         DramaFrame.setLocationRelativeTo(null);
         DramaFrame.setVisible(true);
		 DramaFrame.setResizable(false);
         DramaFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==BackButton)
		{
        DramaFrame.setVisible(false);
		 new HomePage(login);
		}
		
		if(e.getSource()==B7)
		{ 
	        home.a=11;
           DramaFrame.setVisible(false);
		   new BuyF(this,home);
		}
		if(e.getSource()==B8)
		{
          home.a=12;
           DramaFrame.setVisible(false);
		   new BuyF(this,home);
		}
		if(e.getSource()==B9)
		{
           home.a=13;
           DramaFrame.setVisible(false);
		   new BuyF(this,home);
		}
		if(e.getSource()==B10)
		{
           home.a=14;
           DramaFrame.setVisible(false);
		   new BuyF(this,home);
		}
		
	}
 
		
	
}