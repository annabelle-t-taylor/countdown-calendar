import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class myCalendar{
	public static void main(String[] args){
		JFrame frame = new JFrame("Countdown Calendar");
		frame.setPreferredSize(new Dimension(1000,555));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		
		Dimension sizeOfDate = new Dimension(135,75);
		daysOfWeek header = new daysOfWeek();
		header.setPreferredSize(sizeOfDate);
		
		day sun = new day("Sunday");
			sun.setPreferredSize(sizeOfDate);
			header.add(sun);
		day mon = new day("Monday");
			mon.setPreferredSize(sizeOfDate);
			header.add(mon);
		day tues = new day("Tuesday");
			tues.setPreferredSize(sizeOfDate);
			header.add(tues);
		day wed = new day("Wednesday");
			wed.setPreferredSize(sizeOfDate);
			header.add(wed);
		day thurs = new day("Thursday");
			thurs.setPreferredSize(sizeOfDate);
			header.add(thurs);
		day fri = new day("Friday");
			fri.setPreferredSize(sizeOfDate);
			header.add(fri);
		day sat = new day("Saturday");
			sat.setPreferredSize(sizeOfDate);
			header.add(sat);
		frame.add(header, BorderLayout.NORTH);
		
		daysOfWeek body = new daysOfWeek();
		// adding dates; these can be changed to whatever you want
		int startDate = 2;
		int endDate = 23;
		
		for (int date = startDate; date < endDate; date++) {
			day temp = new day("" + date);
			temp.setPreferredSize(new Dimension(135,150));
			body.add(temp);
		}
		
		frame.add(body, BorderLayout.CENTER);
		frame.setResizable(false);
		frame.pack();
	}
}