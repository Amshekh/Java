import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SwingPaintTest{

	static class MainFrame extends JFrame{
		
		public MainFrame(){
			super("Hello JFC");
			setSize(400, 400);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setContentPane(new PaintPanel());
		}
	}

	static class PaintPanel extends JPanel{
		
		@Override
		public void paintComponent(Graphics g){
			g.setColor(Color.RED);
			g.drawRect(60, 60, 195, 20);
			g.setColor(Color.BLUE);
			Date now = new Date();
			g.drawString(now.toString(), 65, 75);
		}
	}

	public static void main(String[] args) throws Exception{
		final MainFrame frame = new MainFrame();
		frame.setVisible(true);
		Runnable activity = new Runnable(){
			public void run(){
				frame.repaint();
			}
		};
		for(;;){
			Thread.sleep(1000);
			SwingUtilities.invokeLater(activity);
		}
	}
}


















