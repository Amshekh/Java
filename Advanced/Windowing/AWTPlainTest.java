import java.awt.*;
import java.awt.event.*;

class AWTPlainTest{
	
	static class MainFrame extends Frame{
		
		public MainFrame(){
			super("Hello AWT");						// Check point 1.
			setSize(400, 400);						// size of window (width height)
			enableEvents(AWTEvent.WINDOW_EVENT_MASK);			// Check point 5.			
		}

		@Override
		public void processWindowEvent(WindowEvent we){				// Check point 2.
			if(we.getID() == WindowEvent.WINDOW_CLOSING)			// Check point 3.
				System.exit(0);
			super.processWindowEvent(we);					// Check point 4.
		}
	}

	public static void main(String[] args) throws Exception{
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
}

/* Comments about this programme :-

*** soemthing Important ***
	For creating the window frame we have extend java.awt.Frame class

POINTS :-
	1. Here we are calling the constructor of a super class (Frame class ) which will create a frame.
	2. We are overriding the processWindowEvent() method because after every event raised this method get called.
	3. Here we are checking the event . If event for Close the window.

		getID() = Every event has a id so we are getting the ID of current event
		WindowEvent.WINDOW_CLOSING = event raised for Closing window

	4. Here we are calling the processWindowEvent() of super class because we are handling only closing event so other event
	     should also be handled so we are calling the super class constructor.

	5. Here we are enabling the all event which releated to window.
*/