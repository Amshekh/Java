import java.util.*;
import java.awt.*;
import java.awt.event.*;

class AWTChildTest{
	
	static class MainFrame extends Frame 
	implements ActionListener{
		
		private Button timeButton = new Button("Show Time");
		private Button greetButton = new Button("Greet User");

		public MainFrame(){
			super("Hello AWT");
			setSize(400, 400);
			enableEvents(AWTEvent.WINDOW_EVENT_MASK);
			//add(timeButton, BorderLayout.NORTH);
			setLayout(new FlowLayout());
			add(timeButton);
			timeButton.addActionListener(this);
			add(greetButton);
			greetButton.addActionListener(this);
		}

		public void actionPerformed(ActionEvent ae){
			if(ae.getSource() == timeButton){
				Date now = new Date();
				setTitle(now.toString());
			}else{
				String user = System.getProperty("user.name");
				setTitle("Hello " + user);
			}
		}

		@Override
		public void processWindowEvent(WindowEvent we){
			if(we.getID() == WindowEvent.WINDOW_CLOSING)
				System.exit(0);
			super.processWindowEvent(we);
		}
	}

	public static void main(String[] args) throws Exception{
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
}












