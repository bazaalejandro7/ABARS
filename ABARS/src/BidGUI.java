
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/**
 * Course: SE 300- 01
 * Term: Fall 2014
 * Final Project
 * @author courtneyfennell
 * @created November 7, 2014
 */

@SuppressWarnings("serial")
public class BidGUI extends JPanel {
	Student currStudent;
	ArrayList<BidCourse> bidCourses;
	JPanel innerPanel;

	/**This panel displays all of the classes that the student has bid for before the auction runs
	 * 
	 * @param student
	 * @throws BiffException
	 * @throws IOException
	 * 
	 * Edited: Matthew Alpert
	 * Changes: fixed issue with creation of the arrayList
	 */
	public BidGUI(Student student) throws IOException{
		//this is where a student can drop a class
		bidCourses = null;
		innerPanel = new JPanel();
		currStudent = student;
		
		try{
			bidCourses = currStudent.getBidCourses();
		}catch(Exception e){
			System.out.println("Error");
		}
		

		//add layout manager
		this.setLayout(new BoxLayout( this, BoxLayout.Y_AXIS));
		innerPanel.setLayout(new BoxLayout( innerPanel, BoxLayout.X_AXIS));
		
		//add components to inner panel
		innerPanel.add(Box.createVerticalStrut(2));
		innerPanel.add(new JLabel("Course Name:"));
		innerPanel.add(Box.createVerticalStrut(2));
		innerPanel.add(new JLabel("Credits:"));
		innerPanel.add(Box.createVerticalStrut(2));
		innerPanel.add(new JLabel("Bid:"));
		innerPanel.add(Box.createVerticalStrut(2));
		this.add(innerPanel);

		//display all courses
		for(int i = 0;i<bidCourses.size();i++){
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout( panel, BoxLayout.X_AXIS));
			BidCourse currCourse = bidCourses.get(i);
			JRadioButton currLabel = new JRadioButton(currCourse.getCourseNum());
			currLabel.addActionListener(new DropListener());
			currLabel.setActionCommand(Integer.toString(i));
			panel.add(Box.createVerticalStrut(2));
			panel.add(currLabel);
			panel.add(Box.createVerticalStrut(2));

			JLabel creditsLabel = new JLabel(Integer.toString(currCourse.getCredits()));
			panel.add(creditsLabel);
			panel.add(Box.createVerticalStrut(2));

			JLabel bidLabel = new JLabel(Integer.toString(currCourse.getBid()));
			panel.add(bidLabel);
			panel.add(Box.createVerticalStrut(2));
			this.add(panel);

		}


	}
	/**
	 * @author Courtney Fennell
	 * @return BidGUI - an updated version of the panel that this class sets up
	 * @throws BiffException
	 * @throws IOException
	 * @created November 10, 2014
	 */
	public BidGUI setupPanel() throws IOException{
		if(!currStudent.getBidCourses().isEmpty()){
			return new BidGUI(currStudent);
		}
		else{
			ImageIcon image = new ImageIcon(getClass().getResource("anykey.gif"));
			JOptionPane.showMessageDialog(null, 
					"I'm sorry there's nothing here. Try bidding on a class first.", 
					"Nothing is here", JOptionPane.PLAIN_MESSAGE , image);
			return null;
		}
	}


	/**
	 * This action listener listens for the class to be chosen
	 * @author courtneyfennell
	 *
	 */
	class DropListener implements ActionListener { // Inner class
		public void actionPerformed(ActionEvent e) {

			int action = Integer.parseInt(e.getActionCommand());
			BidCourse chosenCourse = bidCourses.get(action);

			try {
				currStudent.dropCourse(chosenCourse);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			ImageIcon image = new ImageIcon(getClass().getResource("zoidbergescape.gif"));
			JOptionPane.showMessageDialog(null, 
					"You have successfully dropped your class!", 
					"Drop Class Confimation", JOptionPane.PLAIN_MESSAGE , image);


		}
	}
}




