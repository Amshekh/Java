import java.util.*;
import java.awt.*;
import java.awt.event.*;

class AWTPaintTest{
	
	static class MainFrame extends Frame{
		
		public MainFrame(){
			super("Hello AWT");
			setSize(400, 400);
			enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		}

		@Override
		public void paint(Graphics g){
			//g.setColor(new Color(255, 0, 0));
			g.setColor(Color.RED);
			g.drawRect(60, 60, 195, 20);
			g.setColor(Color.BLUE);
			Date now = new Date();
			g.drawString(now.toString(), 65, 75);
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
		for(;;){
			Thread.sleep(1000);
			frame.repaint();
		}
	}
}












