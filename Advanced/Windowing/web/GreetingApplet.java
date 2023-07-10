package web;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GreetingApplet extends JApplet 
implements ActionListener{
	
	private JLabel outputLabel = new JLabel("Welcome Visitor");
	private JButton timeButton = new JButton("Show Time!");

	@Override
	public void init(){
		setLayout(new BorderLayout());
		outputLabel.setHorizontalAlignment(JLabel.CENTER);		
		outputLabel.setFont(new Font("Helvetica", Font.BOLD, 18));
		add(outputLabel, BorderLayout.NORTH);
		timeButton.addActionListener(this);
		JPanel p = new JPanel();
		p.add(timeButton);
		add(p, BorderLayout.SOUTH);
	}
		
	public void actionPerformed(ActionEvent ae){
		String pattern = this.getParameter("pattern");
		if(pattern == null)
			pattern = "HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date now = new Date();
		outputLabel.setText(sdf.format(now));
	}

	public void resetOutput(String text){
		outputLabel.setText(text);
	}
}















