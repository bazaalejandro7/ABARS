import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jxl.read.biff.BiffException;

/**
 * 
 * @author courtneyfennell
 *
 */
public class RegisterGUI extends JPanel {

	Student currStudent;
	ArrayList<GradedCourse> gradedCourses;
	ArrayList<Course> allCourses;
	int i = 0;
	CourseDatabase cd;
	
	//this is where a student can add a class
/**
 * 
 * @param student
 * @throws BiffException
 * @throws IOException
 */
	public RegisterGUI(Student student) throws BiffException, IOException{
		currStudent = student;
		cd = new CourseDatabase();
		allCourses = cd.getCourseList();
		gradedCourses = currStudent.getCoursesTaken();
		i = gradedCourses.size();

		//add layout manager
		this.setLayout(new GridLayout((allCourses.size()-gradedCourses.size()), 1));
		this.add(new JLabel("Course Name:"));
		this.add(new JLabel("Credits:"));

		//continue from same spot for the rest of the courses without grades
		for(;i<allCourses.size();i++){

			Course currCourse = allCourses.get(i);
			JLabel currLabel = new JLabel(currCourse.getCourseNum());


			this.add(currLabel);

			JLabel creditsLabel = new JLabel(Integer.toString(currCourse.getCredits()));
			this.add(creditsLabel);
		}
	}
}


