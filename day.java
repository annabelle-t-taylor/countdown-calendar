import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.swing.event.*;

public class day extends JPanel{
	String dayName;

	public day (String dayName) {
		this.dayName = dayName;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if (dayName.contains("day")) {
			setBackground(new Color(137,207,240));
			Font f = new Font("TimesRoman", Font.PLAIN, 20);
			Dimension d = this.getSize();
			g.setColor(Color.black);
			g.setFont(f);
			drawCenteredString(dayName, d.width, d.height, g);
		}
		
		else {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 10)); 
			g.drawString(dayName,5,17);
			setBackground(new Color(255,255,255));
			//setBackground(new Color(155,155,155));
			if (checkDate() == false) {
				g.setColor( Color.RED );
				g.drawLine(0,0, this.getWidth(),this.getHeight());
				g.drawLine(0,this.getHeight(), this.getWidth(), 0);
			}
			
			/*
				In order to make this display textboxes for all dates, regardless of whether a day has passed, comment out the above "if" statement and make the following
				two commends exist outside of the "else" statement.
			*/
			
			else {
				createTextAreas("day"+this.dayName.toString() + ".txt");	
			}
		}
	}
	
	//http://www.java2s.com/Tutorial/Java/0261__2D-Graphics/Centertext.htm
	public void drawCenteredString(String s, int w, int h, Graphics g) {
		FontMetrics fm = g.getFontMetrics();
		int x = (w - fm.stringWidth(s)) / 2;
		int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2)-5;
		g.drawString(s, x, y);
	}

	
	public void createTextAreas(String fileName) {
		final JTextArea textArea = new JTextArea(10,8);
		textArea.setEditable(true);
		File file = new File(fileName);
		
		try {
			String thisLine = null;
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((thisLine = br.readLine()) != null) {
				textArea.append(thisLine +"\n");
			}
		} catch (IOException e) {}
		this.add(textArea);
		
		textArea.getDocument().addDocumentListener(new DocumentListener()
		{
			public void changedUpdate(DocumentEvent arg0) 
            {

            }
            public void insertUpdate(DocumentEvent arg0) 
            {
				FileWriter writer = null;
				try {
				  writer = new FileWriter("day"+dayName.toString() + ".txt");
				  textArea.write(writer);
				} catch (IOException exception){}
            }

            public void removeUpdate(DocumentEvent arg0) 
            {
                FileWriter writer = null;
				try {
				  writer = new FileWriter("day"+dayName.toString() + ".txt");
				  textArea.write(writer);
				} catch (IOException exception){}
            }
			
		});
	}
	
	public boolean checkDate() {
		Date date = new Date(); // your date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayNumber = Integer.parseInt(dayName);
		
		if(dayNumber < day)
			return false;
		else
			return true;
		
	}
	
	public String getNewText(JTextArea current){
		return current.getText();
	}
}