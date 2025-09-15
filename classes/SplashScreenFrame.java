package classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplashScreenFrame extends JFrame {
    private int duration;

    public SplashScreenFrame(int duration) {
        this.duration = duration;
        initialize();
    }

    private void initialize() {
		
		
		setSize(1080,650);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		// Calculate top-left corner of the frame
		int x = (screenWidth - 1080) / 2;
		int y = (screenHeight - 650) / 2;
		
		setLocation(x,y);
        
		setTitle("Literay Delights-Explore World between the pages");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
        panel.setBackground(Color.white);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setContentPane(panel);

        ImageIcon icon = new ImageIcon("Images\\logo.jpg");
        JLabel label = new JLabel(icon);
        panel.add(label, BorderLayout.CENTER);

        Timer timer = new Timer(duration, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ((Timer)e.getSource()).stop();
				new Login();
				
				
            }
        });
		
          try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.setRepeats(false); // Stop the timer after one iteration
        timer.start();
        
        setVisible(true);
    }

}
