package classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Payment extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l33,l4,l5,l6,l7;
	JButton b1,b2,b3,b4,b5;
	JTextField t1,t2;
	JPasswordField pf1;
	JRadioButton r1,r2,r3,r4;
	JPanel p1;
	ButtonGroup grp;
	BuyF b;
	
	public Payment(BuyF b)
	{
		super(" Payment ");
		this.b=b;
		this.setSize(820,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		p1 = new JPanel();
		p1.setBounds(0,0,820,600);
		p1.setBackground(Color.WHITE);
		//p1.setBackground(Color.decode("#99eaff"));
		this.setLocationRelativeTo(null);
		p1.setLayout(null);
		
	//JLabel
        l1 = new JLabel("SELECT A PAYMENT METHOD");
		l1.setBounds(400,30,500,25);
		l1.setFont(new Font("Segoe UI",Font.BOLD,25));
		p1.add(l1);

        l2 = new JLabel("Or, online payment");
		l2.setBounds(410,140,200,25);
		l2.setFont(new Font("Segoe UI",Font.PLAIN,18));
		p1.add(l2);
		
	    l4 = new JLabel("*Phone number");
		l4.setBounds(430,300,130,30);
		l4.setFont(new Font("Segoe UI",Font.PLAIN,16));
		l4.setForeground(Color.BLACK);
		p1.add(l4);
		
		t1 = new JTextField();
		t1.setFont(new Font("Segoe UI",Font.PLAIN,16));
        t1.setBounds(430,330,260,30);
        p1.add(t1);
		
		l5 = new JLabel("*Password");
		l5.setBounds(430,360,80,30);
		l5.setFont(new Font("Segoe UI",Font.PLAIN,16));
		l5.setForeground(Color.BLACK);
		p1.add(l5);
		
		pf1 = new JPasswordField();
		pf1.setBounds(430,390,260,30);
		pf1.setFont(new Font("Serif",Font.BOLD,16));
		pf1.setEchoChar('*');
		p1.add(pf1);
		
		l6 = new JLabel("*Code");
		l6.setBounds(430,420,80,30);
		l6.setFont(new Font("Segoe UI",Font.PLAIN,16));
		l6.setForeground(Color.BLACK);
		p1.add(l6);
		
		t2 = new JTextField();
		t2.setFont(new Font("Segoe UI",Font.PLAIN,16));
        t2.setBounds(430,450,115,30);
        p1.add(t2);
		
		
	//JButton
	    ImageIcon icon1 = new ImageIcon("Images/back.png");
		b1 = new JButton(icon1);
		b1.setBounds(15,18,35,35);
		b1.addActionListener(this);
		b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);
	    b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		p1.add(b1);	
		
		ImageIcon icon2 = new ImageIcon("Images/bkash_payment.png");
		b2 = new JButton(icon2);
		b2.setBounds(420,180,180,42);
	    //b2.addActionListener(this);
		b2.setFocusPainted(false);
        b2.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b2.setContentAreaFilled(false);
	    b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(b2);
		
		ImageIcon icon3 = new ImageIcon("Images/nagad_payment.png");
		b3 = new JButton(icon3);
		b3.setBounds(635,180,180,43);
	    //b3.addActionListener(this);
		b3.setFocusPainted(false);
        b3.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b3.setContentAreaFilled(false);
	    b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(b3);
		
		ImageIcon icon4 = new ImageIcon("Images/rocket_payment.jpg");
		b4 = new JButton(icon4);
		b4.setBounds(490,235,180,43);
	    //b4.addActionListener(this);
		b4.setFocusPainted(false);
        b4.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b4.setContentAreaFilled(false);
	    b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(b4);
		
		ImageIcon icon5 = new ImageIcon("Images/pay now.jpg");
		b5 = new JButton(icon5);
		b5.setBounds(430,500,270,40);
	    b5.addActionListener(this);
	    b5.setFocusable(false);
		b5.setFocusPainted(false);
        b5.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b5.setContentAreaFilled(false);
	    b5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b5.setEnabled(false);
	    p1.add(b5);
		
		
	//JRadioButton
        r1 = new JRadioButton("Cash-on-delivery");
        r1.setBounds(420,85,240,24);
		r1.setFont(new Font("Segoe UI",Font.PLAIN,18));
        r1.setForeground(Color.BLACK);
        r1.setFocusPainted(false);
        r1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        r1.setContentAreaFilled(false);
	    r1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		r1.addActionListener(this);
        p1.add(r1);	
		
		r2 = new JRadioButton();
        r2.setBounds(393,180,180,42);
        r2.setFocusPainted(false);
        r2.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        r2.setContentAreaFilled(false);
		r2.addActionListener(this);
	    r2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p1.add(r2);	
		
		r3 = new JRadioButton();
        r3.setBounds(618,180,180,42);
        r3.setFocusPainted(false);
        r3.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        r3.setContentAreaFilled(false);
	    r3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		r3.addActionListener(this);
        p1.add(r3);	
		
		r4 = new JRadioButton();
        r4.setBounds(465,240,180,43);
        r4.setFocusPainted(false);
        r4.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        r4.setContentAreaFilled(false);
		r4.addActionListener(this);
	    r4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p1.add(r4);	
		
		grp = new ButtonGroup();
		grp.add(r1);
		grp.add(r2);
		grp.add(r3);
		grp.add(r4);
	
	//Image	
		ImageIcon icon6 = new ImageIcon("Images/Online_Payment.png");
		l3 = new JLabel(icon6);
		l3.setBounds(25,235,350,222);
		p1.add(l3);
		
	    this.add(p1);
        setVisible(true);
	}
   
   public void actionPerformed(ActionEvent e) 
	{
	    if(e.getSource()==b1)
		{
			this.dispose();
			b.setVisible(true);
		}	
     if(r1.isSelected() || r2.isSelected() || r3.isSelected() || 
		r4.isSelected())
		{
			b5.setEnabled(true);
		}
		if(e.getSource()==b5)
		{
			JOptionPane.showConfirmDialog(this,"Are you Sure to Confirm Pay??");
			if(JOptionPane.YES_OPTION==0)
			{
				
				JOptionPane.showMessageDialog(this,"Payment Successfull");
				System.exit(0);
				//new Welcome();
			}
		}
	
	}
   
   
		
}
		