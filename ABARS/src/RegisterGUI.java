import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;


//import sun.awt.RepaintArea;
import jxl.read.biff.BiffException;

/**
 * Course: SE 300- 01
 * Term: Fall 2014
 * Final Project
 * @author courtneyfennell
 * @created October 29, 2014
 */
@SuppressWarnings("serial")
public class RegisterGUI extends JPanel {

	Student currStudent;
	ArrayList<GradedCourse> gradedCourses;
	ArrayList<Course> allCourses;
	int i = 0;
	CourseDatabase cd;

	//this is where a student can add a class
	/** This constructor creates the panel that displays all the classes a student can choose to register for
	 * 
	 * @param student
	 * @throws BiffException
	 * @throws IOException
	 */
	public RegisterGUI(Student student) throws BiffException, IOException{
		JPanel labelPanel=new JPanel();
		
		currStudent = student;
		cd = new CourseDatabase();
		allCourses = cd.getCourseList();
		gradedCourses = currStudent.getCoursesTaken();
		i = gradedCourses.size();
		
		//add layout manager
		this.setLayout(new GridLayout(30, 1));
		labelPanel.setLayout(new GridLayout(1,3));
		//TODO figure out how to set the layout so that it works for all students

		labelPanel.add(new JLabel("Course Name:"));
		labelPanel.add(new JLabel("Credits:"));
		labelPanel.add(new JLabel("Course Description"));
		this.add(labelPanel);
		//continue from same spot for the rest of the courses without grades
		for(;i<allCourses.size();i++){
			JPanel tempPanel=new JPanel();
			
			Course currCourse = allCourses.get(i);
			JRadioButton currLabel = new JRadioButton(currCourse.getCourseNum());
			JButton currButton=new JButton("Description");
			
			tempPanel.setLayout(new GridLayout(1,3));
			
			currLabel.addActionListener(new Listener());
			currLabel.setActionCommand(Integer.toString(i));

			currButton.addActionListener(new DescriptionListener(currCourse));

			tempPanel.add(currLabel);

			JLabel creditsLabel = new JLabel(Integer.toString(currCourse.getCredits()));
			tempPanel.add(creditsLabel);
			
			//TODO get the buttons to add correctly
			tempPanel.add(currButton);
			this.add(tempPanel);
		}
	}


	class Listener implements ActionListener { // Inner class
		public void actionPerformed(ActionEvent e) {

			int action = Integer.parseInt(e.getActionCommand());
			Course chosenCourse = allCourses.get(action);
		
			String text = String.format("You have %d points.\nEnter the number of points you want to bid:", currStudent.getNumPoints());
			String input = JOptionPane.showInputDialog(text);

					if (input !=null) {
						boolean success=false;
						try {
							success = currStudent.addCourse(chosenCourse,Integer.parseInt(input));
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(success){
							ImageIcon image = new ImageIcon(getClass().getResource("zoidberg.jpg"));
							JOptionPane.showMessageDialog(null, 
									"You have successfully added your class!", 
									"Add Class Confimation", JOptionPane.PLAIN_MESSAGE , image);

						}
						else{
							ImageIcon image = new ImageIcon(getClass().getResource("127.gif"));
							JOptionPane.showMessageDialog(null, 
									"I'm sorry, you cannot add that class", 
									"Add Class Error", JOptionPane.PLAIN_MESSAGE , image);
						}
					
					}
		}

	}
	class DescriptionListener implements ActionListener{
		private Course course;
		
		public DescriptionListener(Course course){
			this.course=course;
		}
		
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "<html><body><p style='width: 200px;'>"+String.format("%s: %s", course.getCourseNum(),course.getCourseDescription())+"</body></html>");
		}
		
	}
}

