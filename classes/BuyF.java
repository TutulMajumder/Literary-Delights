package classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class BuyF extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JButton b1,b2,b4,b5,b6,b7;
	JComboBox cb1;
	JPanel p1,p2,p3,p4,p5,p6;
	
	
	CardLayout cd;
	
	
	UponashF uponash;
	HomePage home;
	Login login;
	DramaF drama;
	ShortStoryF shortStory;
	PoetryF poetry;
	ThrillerF thriller;
	MysteryF mystery;
	int b=0;
	int c=0;
	String name="";
	
   public BuyF(UponashF uponash,HomePage home)
	{
		super(" Buy ");
		this.uponash=uponash;
		this.home=home;
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		
		setVisible(true);

		p1 = new JPanel();
		p1.setBounds(0,0,800,600);
		p1.setBackground(Color.WHITE);
		//p1.setBackground(Color.decode("#99eaff"));
		this.setLocationRelativeTo(null);
		p1.setLayout(null);
		
		cd = new CardLayout();
		
		p2 = new JPanel();
		p2.setBounds(30,100,300,250);
		p2.setBackground(Color.WHITE);
		//p2.setBackground(Color.decode("#99eaff"));
		p2.setLayout(cd);
		p1.add(p2);
		
		p3 = new JPanel();
		p3.setBounds(30,100,300,250);
		p3.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p3.setLayout(null);
		p2.add(p3);
		
		p4 = new JPanel();
		p4.setBounds(30,100,300,250);
		p4.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p4.setLayout(null);
		p2.add(p4);
		
		p5 = new JPanel();
		p5.setBounds(30,100,300,250);
		p5.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p5.setLayout(null);
		p2.add(p5);
		
		
		p6 = new JPanel();
		p6.setBounds(30,100,300,250);
		p6.setBackground(Color.WHITE);
		//p6.setBackground(Color.decode("#99eaff"));
		p6.setLayout(null);
		p2.add(p6);
		
	//JButton
        ImageIcon icon1 = new ImageIcon("./Images/back.png");
		b1 = new JButton(icon1);
		b1.setBounds(18,25,35,35);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent av)
			{
				setVisible(false);
				new UponashF(home,login);
			}
		});
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);	
		p1.add(b1);
		
		//ImageIcon icon2 = new ImageIcon("Images/buy-now-button.png");
		b2 = new JButton("Buy Now");
		b2.setBounds(520,450,150,35);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
        b2.setFocusPainted(false);
		p1.add(b2);
		
		ImageIcon icon3 = new ImageIcon("./Images/B7.jpg");
		b4 = new JButton(icon3);
        b4.setBounds(20,30,122,186);
	    //b4.addActionListener(this);
	    p3.add(b4);
		
		ImageIcon icon4 = new ImageIcon("./Images/B8.jpg");
		b5 = new JButton(icon4);
		b5.setBounds(20,30,122,186);
	    p4.add(b5);
	
		ImageIcon icon6 = new ImageIcon("./Images/B9.jpg");
		b6 = new JButton(icon6);
		b6.setBounds(20,30,122,186);
	    p5.add(b6);
		
		ImageIcon icon7 = new ImageIcon("./Images/B10.jpg");
		b7 = new JButton(icon7);
		b7.setBounds(20,30,122,186);
	    p6.add(b7);
		
		cd.addLayoutComponent(p3,"6");
		cd.addLayoutComponent(p4,"7");
		cd.addLayoutComponent(p5,"8");
		cd.addLayoutComponent(p6,"9");
		
	
		
		
				for(int i=0; i<home.info.length; i++)
				{
					
					if(home.info[i]!=null)
					{
						 String sp[] = home.info[i].split("/");
						 b = Integer.parseInt(sp[1]);
						 if(home.a==b)
						 {
						 name=sp[0];
						 c = Integer.parseInt(sp[2]);
						break;
						 }
					}
					
				}
		
		
		String quantity[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        cb1 = new JComboBox(quantity);
        cb1.setBounds(500, 241, 75, 26);
		cb1.addActionListener(this);
		p1.add(cb1);
		
	//JLabel
        l1 = new JLabel("Quantity");
        l1.setBounds(420, 230, 240, 40);
        l1.setFont(new Font("Serif", Font.BOLD, 18));
		p1.add(l1);
		
		
		l2= new JLabel();
		l2.setBounds(380,170,400,40);
		l2.setFont(new Font("Serif", Font.BOLD, 35));
		p1.add(l2);
		
		l3= new JLabel();
		l3.setBounds(80,380,250,30);
		l3.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l3);
		
		l4= new JLabel();
		l4.setBounds(80,430,220,30);
		l4.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l4);

		if(home.a==b)
		{
			l2.setText(name);
			l3.setText("Quantity : "+cb1.getSelectedItem().toString());
			l4.setText("Price : "+c+" TK");
			cd.show(p2,String.valueOf(home.a));
			
		}
		
		
		this.add(p1);
        
	}
	
	
	 public BuyF(DramaF drama,HomePage home)
	{
		super(" Buy ");
		this.drama=drama;
		this.home=home;
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		
		setVisible(true);

		p1 = new JPanel();
		p1.setBounds(0,0,800,600);
		p1.setBackground(Color.WHITE);
		//p1.setBackground(Color.decode("#99eaff"));
		this.setLocationRelativeTo(null);
		p1.setLayout(null);
		
		cd = new CardLayout();
		
		p2 = new JPanel();
		p2.setBounds(30,100,300,250);
		p2.setBackground(Color.WHITE);
		//p2.setBackground(Color.decode("#99eaff"));
		p2.setLayout(cd);
		p1.add(p2);
		
		p3 = new JPanel();
		p3.setBounds(30,100,300,250);
		p3.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p3.setLayout(null);
		p2.add(p3);
		
		p4 = new JPanel();
		p4.setBounds(30,100,300,250);
		p4.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p4.setLayout(null);
		p2.add(p4);
		
		p5 = new JPanel();
		p5.setBounds(30,100,300,250);
		p5.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p5.setLayout(null);
		p2.add(p5);
		
		
		p6 = new JPanel();
		p6.setBounds(30,100,300,250);
		p6.setBackground(Color.WHITE);
		//p6.setBackground(Color.decode("#99eaff"));
		p6.setLayout(null);
		p2.add(p6);
		
	//JButton
        ImageIcon icon1 = new ImageIcon("./Images/back.png");
		b1 = new JButton(icon1);
		b1.setBounds(18,25,35,35);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent av)
			{
				setVisible(false);
				new DramaF(home,login);
			}
		});
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);	
		p1.add(b1);
		
		//ImageIcon icon2 = new ImageIcon("Images/buy-now-button.png");
		b2 = new JButton("Buy Now");
		b2.setBounds(520,450,150,35);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
        b2.setFocusPainted(false);
		p1.add(b2);
		
		ImageIcon icon3 = new ImageIcon("./Images/B11.jpg");
		b4 = new JButton(icon3);
        b4.setBounds(20,30,122,186);
	    //b4.addActionListener(this);
	    p3.add(b4);
		
		ImageIcon icon4 = new ImageIcon("./Images/B12.jpg");
		b5 = new JButton(icon4);
		b5.setBounds(20,30,122,186);
	    p4.add(b5);
	
		ImageIcon icon6 = new ImageIcon("./Images/B13.jpg");
		b6 = new JButton(icon6);
		b6.setBounds(20,30,122,186);
	    p5.add(b6);
		
		ImageIcon icon7 = new ImageIcon("./Images/B23.jpg");
		b7 = new JButton(icon7);
		b7.setBounds(20,30,122,186);
	    p6.add(b7);
		
		cd.addLayoutComponent(p3,"11");
		cd.addLayoutComponent(p4,"12");
		cd.addLayoutComponent(p5,"13");
		cd.addLayoutComponent(p6,"14");
		
	
		
		
				for(int i=0; i<home.info.length; i++)
				{
					
					if(home.info[i]!=null)
					{
						 String sp[] = home.info[i].split("/");
						 b = Integer.parseInt(sp[1]);
						 if(home.a==b)
						 {
						 name=sp[0];
						 c = Integer.parseInt(sp[2]);
						break;
						 }
					}
					
				}
		
		
		String quantity[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        cb1 = new JComboBox(quantity);
        cb1.setBounds(500, 241, 75, 26);
		cb1.addActionListener(this);
		p1.add(cb1);
		
	//JLabel
        l1 = new JLabel("Quantity");
        l1.setBounds(420, 230, 240, 40);
        l1.setFont(new Font("Serif", Font.BOLD, 18));
		p1.add(l1);
		
		
		l2= new JLabel();
		l2.setBounds(380,170,500,40);
		l2.setFont(new Font("Serif", Font.BOLD, 35));
		p1.add(l2);
		
		l3= new JLabel();
		l3.setBounds(80,380,150,30);
		l3.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l3);
		
		l4= new JLabel();
		l4.setBounds(80,430,220,30);
		l4.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l4);

		if(home.a==b)
		{
			l2.setText(name);
			l3.setText("Quantity : "+cb1.getSelectedItem().toString());
			l4.setText("Price : "+c+" TK");
			cd.show(p2,String.valueOf(home.a));
			
		}
		
		
		this.add(p1);
        
	}
	
	 public BuyF(ShortStoryF shortStory,HomePage home)
	{
		super(" Buy ");
		this.shortStory=shortStory;
		this.home=home;
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		
		setVisible(true);

		p1 = new JPanel();
		p1.setBounds(0,0,800,600);
		p1.setBackground(Color.WHITE);
		//p1.setBackground(Color.decode("#99eaff"));
		this.setLocationRelativeTo(null);
		p1.setLayout(null);
		
		cd = new CardLayout();
		
		p2 = new JPanel();
		p2.setBounds(30,100,300,250);
		p2.setBackground(Color.WHITE);
		//p2.setBackground(Color.decode("#99eaff"));
		p2.setLayout(cd);
		p1.add(p2);
		
		p3 = new JPanel();
		p3.setBounds(30,100,300,250);
		p3.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p3.setLayout(null);
		p2.add(p3);
		
		p4 = new JPanel();
		p4.setBounds(30,100,300,250);
		p4.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p4.setLayout(null);
		p2.add(p4);
		
		p5 = new JPanel();
		p5.setBounds(30,100,300,250);
		p5.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p5.setLayout(null);
		p2.add(p5);
		
		
		p6 = new JPanel();
		p6.setBounds(30,100,300,250);
		p6.setBackground(Color.WHITE);
		//p6.setBackground(Color.decode("#99eaff"));
		p6.setLayout(null);
		p2.add(p6);
		
	//JButton
        ImageIcon icon1 = new ImageIcon("./Images/back.png");
		b1 = new JButton(icon1);
		b1.setBounds(18,25,35,35);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent av)
			{
				setVisible(false);
				new ShortStoryF(home,login);
			}
		});
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);	
		p1.add(b1);
		
		//ImageIcon icon2 = new ImageIcon("Images/buy-now-button.png");
		b2 = new JButton("Buy Now");
		b2.setBounds(520,450,150,35);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
        b2.setFocusPainted(false);
		p1.add(b2);
		
		ImageIcon icon3 = new ImageIcon("./Images/B24.jpg");
		b4 = new JButton(icon3);
        b4.setBounds(60,30,122,186);
	    //b4.addActionListener(this);
	    p3.add(b4);
		
		ImageIcon icon4 = new ImageIcon("./Images/B25.jpg");
		b5 = new JButton(icon4);
		b5.setBounds(60,30,122,186);
	    p4.add(b5);
	
		ImageIcon icon6 = new ImageIcon("./Images/B26.jpg");
		b6 = new JButton(icon6);
		b6.setBounds(60,30,122,186);
	    p5.add(b6);
		
		ImageIcon icon7 = new ImageIcon("./Images/B27.jpg");
		b7 = new JButton(icon7);
		b7.setBounds(60,30,122,186);
	    p6.add(b7);
		
		cd.addLayoutComponent(p3,"24");
		cd.addLayoutComponent(p4,"25");
		cd.addLayoutComponent(p5,"26");
		cd.addLayoutComponent(p6,"27");
		
	
		
		
				for(int i=0; i<home.info.length; i++)
				{
					
					if(home.info[i]!=null)
					{
						 String sp[] = home.info[i].split("/");
						 b = Integer.parseInt(sp[1]);
						 if(home.a==b)
						 {
						 name=sp[0];
						 c = Integer.parseInt(sp[2]);
						break;
						 }
					}
					
				}
		
		
		String quantity[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        cb1 = new JComboBox(quantity);
        cb1.setBounds(500, 241, 75, 26);
		cb1.addActionListener(this);
		p1.add(cb1);
		
	//JLabel
        l1 = new JLabel("Quantity");
        l1.setBounds(420, 230, 240, 40);
        l1.setFont(new Font("Serif", Font.BOLD, 18));
		p1.add(l1);
		
		
		l2= new JLabel();
		l2.setBounds(380,170,600,40);
		l2.setFont(new Font("Serif", Font.BOLD, 35));
		p1.add(l2);
		
		l3= new JLabel();
		l3.setBounds(80,380,150,30);
		l3.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l3);
		
		l4= new JLabel();
		l4.setBounds(80,430,220,30);
		l4.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l4);

		if(home.a==b)
		{
			l2.setText(name);
			l3.setText("Quantity : "+cb1.getSelectedItem().toString());
			l4.setText("Price : "+c+" TK");
			cd.show(p2,String.valueOf(home.a));
			
		}
		
		
		this.add(p1);
        
	}
	
	public BuyF(PoetryF poetry,HomePage home)
	{
		super(" Buy ");
		this.poetry=poetry;
		this.home=home;
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		
		setVisible(true);

		p1 = new JPanel();
		p1.setBounds(0,0,800,600);
		p1.setBackground(Color.WHITE);
		//p1.setBackground(Color.decode("#99eaff"));
		this.setLocationRelativeTo(null);
		p1.setLayout(null);
		
		cd = new CardLayout();
		
		p2 = new JPanel();
		p2.setBounds(30,100,300,250);
		p2.setBackground(Color.WHITE);
		//p2.setBackground(Color.decode("#99eaff"));
		p2.setLayout(cd);
		p1.add(p2);
		
		p3 = new JPanel();
		p3.setBounds(30,100,300,250);
		p3.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p3.setLayout(null);
		p2.add(p3);
		
		p4 = new JPanel();
		p4.setBounds(30,100,300,250);
		p4.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p4.setLayout(null);
		p2.add(p4);
		
		p5 = new JPanel();
		p5.setBounds(30,100,300,250);
		p5.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p5.setLayout(null);
		p2.add(p5);
		
		
		p6 = new JPanel();
		p6.setBounds(30,100,300,250);
		p6.setBackground(Color.WHITE);
		//p6.setBackground(Color.decode("#99eaff"));
		p6.setLayout(null);
		p2.add(p6);
		
	//JButton
        ImageIcon icon1 = new ImageIcon("./Images/back.png");
		b1 = new JButton(icon1);
		b1.setBounds(18,25,35,35);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent av)
			{
				setVisible(false);
				new PoetryF(home,login);
			}
		});
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);	
		p1.add(b1);
		
		//ImageIcon icon2 = new ImageIcon("Images/buy-now-button.png");
		b2 = new JButton("Buy Now");
		b2.setBounds(520,450,150,35);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
        b2.setFocusPainted(false);
		p1.add(b2);
		
		ImageIcon icon3 = new ImageIcon("./Images/B19.jpg");
		b4 = new JButton(icon3);
        b4.setBounds(20,30,122,186);
	    //b4.addActionListener(this);
	    p3.add(b4);
		
		ImageIcon icon4 = new ImageIcon("./Images/B20.jpg");
		b5 = new JButton(icon4);
		b5.setBounds(20,30,122,186);
	    p4.add(b5);
	
		ImageIcon icon6 = new ImageIcon("./Images/B22.jpg");
		b6 = new JButton(icon6);
		b6.setBounds(20,30,122,186);
	    p5.add(b6);
		
		ImageIcon icon7 = new ImageIcon("./Images/B3.jpg");
		b7 = new JButton(icon7);
		b7.setBounds(20,30,122,186);
	    p6.add(b7);
		
		cd.addLayoutComponent(p3,"19");
		cd.addLayoutComponent(p4,"20");
		cd.addLayoutComponent(p5,"21");
		cd.addLayoutComponent(p6,"22");
		
	
		
		
				for(int i=0; i<home.info.length; i++)
				{
					
					if(home.info[i]!=null)
					{
						 String sp[] = home.info[i].split("/");
						 b = Integer.parseInt(sp[1]);
						 if(home.a==b)
						 {
						 name=sp[0];
						 c = Integer.parseInt(sp[2]);
						break;
						 }
					}
					
				}
		
		
		String quantity[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        cb1 = new JComboBox(quantity);
        cb1.setBounds(500, 241, 75, 26);
		cb1.addActionListener(this);
		p1.add(cb1);
		
	//JLabel
        l1 = new JLabel("Quantity");
        l1.setBounds(420, 230, 240, 40);
        l1.setFont(new Font("Serif", Font.BOLD, 18));
		p1.add(l1);
		
		
		l2= new JLabel();
		l2.setBounds(350,170,500,40);
		l2.setFont(new Font("Serif", Font.BOLD, 35));
		p1.add(l2);
		
		l3= new JLabel();
		l3.setBounds(80,380,150,30);
		l3.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l3);
		
		l4= new JLabel();
		l4.setBounds(80,430,220,30);
		l4.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l4);

		if(home.a==b)
		{
			l2.setText(name);
			l3.setText("Quantity : "+cb1.getSelectedItem().toString());
			l4.setText("Price : "+c+" TK");
			cd.show(p2,String.valueOf(home.a));
			
		}
		
		
		this.add(p1);
        
	}
	
	public BuyF(ThrillerF thriller,HomePage home)
	{
		super(" Buy ");
		this.thriller=thriller;
		this.home=home;
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		
		setVisible(true);

		p1 = new JPanel();
		p1.setBounds(0,0,800,600);
		p1.setBackground(Color.WHITE);
		//p1.setBackground(Color.decode("#99eaff"));
		this.setLocationRelativeTo(null);
		p1.setLayout(null);
		
		cd = new CardLayout();
		
		p2 = new JPanel();
		p2.setBounds(30,100,300,250);
		p2.setBackground(Color.WHITE);
		//p2.setBackground(Color.decode("#99eaff"));
		p2.setLayout(cd);
		p1.add(p2);
		
		p3 = new JPanel();
		p3.setBounds(30,100,300,250);
		p3.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p3.setLayout(null);
		p2.add(p3);
		
		p4 = new JPanel();
		p4.setBounds(30,100,300,250);
		p4.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p4.setLayout(null);
		p2.add(p4);
		
		p5 = new JPanel();
		p5.setBounds(30,100,300,250);
		p5.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p5.setLayout(null);
		p2.add(p5);
		
		
		p6 = new JPanel();
		p6.setBounds(30,100,300,250);
		p6.setBackground(Color.WHITE);
		//p6.setBackground(Color.decode("#99eaff"));
		p6.setLayout(null);
		p2.add(p6);
		
	//JButton
        ImageIcon icon1 = new ImageIcon("./Images/back.png");
		b1 = new JButton(icon1);
		b1.setBounds(18,25,35,35);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent av)
			{
				setVisible(false);
				new ThrillerF(home,login);
			}
		});
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);	
		p1.add(b1);
		
		//ImageIcon icon2 = new ImageIcon("Images/buy-now-button.png");
		b2 = new JButton("Buy Now");
		b2.setBounds(520,450,150,35);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
        b2.setFocusPainted(false);
		p1.add(b2);
		
		ImageIcon icon3 = new ImageIcon("./Images/B28.jpg");
		b4 = new JButton(icon3);
        b4.setBounds(20,30,122,186);
	    //b4.addActionListener(this);
	    p3.add(b4);
		
		ImageIcon icon4 = new ImageIcon("./Images/B29.jpg");
		b5 = new JButton(icon4);
		b5.setBounds(20,30,122,186);
	    p4.add(b5);
	
		ImageIcon icon6 = new ImageIcon("./Images/B30.jpg");
		b6 = new JButton(icon6);
		b6.setBounds(20,30,122,186);
	    p5.add(b6);
		
		ImageIcon icon7 = new ImageIcon("./Images/B31.jpg");
		b7 = new JButton(icon7);
		b7.setBounds(20,30,122,186);
	    p6.add(b7);
		
		cd.addLayoutComponent(p3,"28");
		cd.addLayoutComponent(p4,"29");
		cd.addLayoutComponent(p5,"30");
		cd.addLayoutComponent(p6,"31");
		
	
		
		
				for(int i=0; i<home.info.length; i++)
				{
					
					if(home.info[i]!=null)
					{
						 String sp[] = home.info[i].split("/");
						 b = Integer.parseInt(sp[1]);
						 if(home.a==b)
						 {
						 name=sp[0];
						 c = Integer.parseInt(sp[2]);
						break;
						 }
					}
					
				}
		
		
		String quantity[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        cb1 = new JComboBox(quantity);
        cb1.setBounds(500, 241, 75, 26);
		cb1.addActionListener(this);
		p1.add(cb1);
		
	//JLabel
        l1 = new JLabel("Quantity");
        l1.setBounds(420, 230, 240, 40);
        l1.setFont(new Font("Serif", Font.BOLD, 18));
		p1.add(l1);
		
		
		l2= new JLabel();
		l2.setBounds(380,170,500,40);
		l2.setFont(new Font("Serif", Font.BOLD, 35));
		p1.add(l2);
		
		l3= new JLabel();
		l3.setBounds(80,380,150,30);
		l3.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l3);
		
		l4= new JLabel();
		l4.setBounds(80,430,220,30);
		l4.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l4);

		if(home.a==b)
		{
			l2.setText(name);
			l3.setText("Quantity : "+cb1.getSelectedItem().toString());
			l4.setText("Price : "+c+" TK");
			cd.show(p2,String.valueOf(home.a));
			
		}
		
		
		this.add(p1);
        
	}
	
	public BuyF(MysteryF mystery,HomePage home)
	{
		super(" Buy ");
		this.mystery=mystery;
		this.home=home;
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		
		setVisible(true);

		p1 = new JPanel();
		p1.setBounds(0,0,800,600);
		p1.setBackground(Color.WHITE);
		//p1.setBackground(Color.decode("#99eaff"));
		this.setLocationRelativeTo(null);
		p1.setLayout(null);
		
		cd = new CardLayout();
		
		p2 = new JPanel();
		p2.setBounds(30,100,300,250);
		p2.setBackground(Color.WHITE);
		//p2.setBackground(Color.decode("#99eaff"));
		p2.setLayout(cd);
		p1.add(p2);
		
		p3 = new JPanel();
		p3.setBounds(30,100,300,250);
		p3.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p3.setLayout(null);
		p2.add(p3);
		
		p4 = new JPanel();
		p4.setBounds(30,100,300,250);
		p4.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p4.setLayout(null);
		p2.add(p4);
		
		p5 = new JPanel();
		p5.setBounds(30,100,300,250);
		p5.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p5.setLayout(null);
		p2.add(p5);
		
		
		p6 = new JPanel();
		p6.setBounds(30,100,300,250);
		p6.setBackground(Color.WHITE);
		//p6.setBackground(Color.decode("#99eaff"));
		p6.setLayout(null);
		p2.add(p6);
		
	//JButton
        ImageIcon icon1 = new ImageIcon("./Images/back.png");
		b1 = new JButton(icon1);
		b1.setBounds(18,25,35,35);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent av)
			{
				setVisible(false);
				new MysteryF(home,login);
			}
		});
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);	
		p1.add(b1);
		
		//ImageIcon icon2 = new ImageIcon("Images/buy-now-button.png");
		b2 = new JButton("Buy Now");
		b2.setBounds(520,450,150,35);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
        b2.setFocusPainted(false);
		p1.add(b2);
		
		ImageIcon icon3 = new ImageIcon("./Images/B32.jpg");
		b4 = new JButton(icon3);
        b4.setBounds(20,30,122,186);
	    //b4.addActionListener(this);
	    p3.add(b4);
		
		ImageIcon icon4 = new ImageIcon("./Images/B33.jpg");
		b5 = new JButton(icon4);
		b5.setBounds(20,30,122,186);
	    p4.add(b5);
	
		ImageIcon icon6 = new ImageIcon("./Images/B35.jpg");
		b6 = new JButton(icon6);
		b6.setBounds(20,30,122,186);
	    p5.add(b6);
		
		ImageIcon icon7 = new ImageIcon("./Images/B18.jpg");
		b7 = new JButton(icon7);
		b7.setBounds(20,30,122,186);
	    p6.add(b7);
		
		cd.addLayoutComponent(p3,"32");
		cd.addLayoutComponent(p4,"33");
		cd.addLayoutComponent(p5,"34");
		cd.addLayoutComponent(p6,"35");
		
	
		
		
				for(int i=0; i<home.info.length; i++)
				{
					
					if(home.info[i]!=null)
					{
						 String sp[] = home.info[i].split("/");
						 b = Integer.parseInt(sp[1]);
						 if(home.a==b)
						 {
						 name=sp[0];
						 c = Integer.parseInt(sp[2]);
						break;
						 }
					}
					
				}
		
		
		String quantity[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        cb1 = new JComboBox(quantity);
        cb1.setBounds(500, 241, 75, 26);
		cb1.addActionListener(this);
		p1.add(cb1);
		
	//JLabel
        l1 = new JLabel("Quantity");
        l1.setBounds(420, 230, 240, 40);
        l1.setFont(new Font("Serif", Font.BOLD, 18));
		p1.add(l1);
		
		
		l2= new JLabel();
		l2.setBounds(380,170,350,40);
		l2.setFont(new Font("Serif", Font.BOLD,30));
		p1.add(l2);
		
		l3= new JLabel();
		l3.setBounds(80,380,150,30);
		l3.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l3);
		
		l4= new JLabel();
		l4.setBounds(80,430,220,30);
		l4.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l4);

		if(home.a==b)
		{
			l2.setText(name);
			l3.setText("Quantity : "+cb1.getSelectedItem().toString());
			l4.setText("Price : "+c+" TK");
			cd.show(p2,String.valueOf(home.a));
			
		}
		
		
		this.add(p1);
        
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==cb1)
		{
		     int count = Integer.parseInt(cb1.getSelectedItem().toString());
			 int price = c*count;
		     l4.setText("Price : "+price+" TK");
			 l3.setText("Quantity : "+cb1.getSelectedItem().toString());
		}
		
		if(e.getSource()==b2)
		{
			this.setVisible(false);
			new Payment(this);
		}
		
	}
	
}