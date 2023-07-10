import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SwingChildTest{

	static class MainFrame extends JFrame 
	implements ActionListener{
		
		private JButton timeButton = new JButton("Show Time");
		private JButton greetButton = new JButton("Greet User");

		public MainFrame(){
			super("Hello JFC");
			setSize(400, 400);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout(new FlowLayout());
			add(timeButton);
			timeButton.addActionListener(this);
			add(greetButton);
			greetButton.addActionListener(this);
		}

		public void actionPerformed(ActionEvent ae){
			String text;
			if(ae.getSource() == timeButton){
				Date now = new Date();
				text = now.toString();
			}else{
				String user = System.getProperty("user.name");
				text = "Hello " + user;
			}
			JOptionPane.showMessageDialog(this, text, "Hello JFC", 				 	JOptionPane.INFORMATION_MESSAGE, null);
		}
	}

	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel(
			new com.sun.java.swing.plaf.motif.MotifLookAndFeel());
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
}


















