import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class daysOfWeek extends JPanel{
	public void chooseLayout(){
		this.setLayout(new GridLayout(0,7));
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setBackground(new Color(0,0,150));
	}
}