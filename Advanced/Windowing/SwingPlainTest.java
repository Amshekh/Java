import javax.swing.*;

class SwingPlainTest{

	static class MainFrame extends JFrame{
		
		public MainFrame(){
			super("Hello JFC");
			setSize(400, 400);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}

	public static void main(String[] args) throws Exception{
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
}


















