import java.util.ArrayList;

/**
 * 
 * @author Matthew Alpert
 *
 */
public class GradedCourse extends Course {

	String grade;

	public GradedCourse(String courseNum, int credits, Course corequisite,
			ArrayList<Course> prerequisites, String courseDescription,
			int timeSlot, int dataColStudent, String grade) {
		super(courseNum, credits, corequisite, prerequisites,
				courseDescription, timeSlot, dataColStudent);
		this.grade = grade;
	}
	
	public String getGrade(){
		return grade;
	}

}
