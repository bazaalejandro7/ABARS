import java.util.ArrayList;

/**
 * 
 * @author Matthew Alpert
 * This class is a subclass of Course.
 * This class contains an additional attribute
 * called grade, which denotes the letter grade
 * received in a course.
 */
public class GradedCourse extends Course {

	String grade;

	/**
	 * @author Matthew Alpert
	 * @param grade - the letter grade received in a given course
	 */
	public GradedCourse(String courseNum, int credits, Course corequisite,
			ArrayList<Course> prerequisites, String courseDescription,
			int timeSlot, int dataColStudent, String grade) {
		super(courseNum, credits, corequisite, prerequisites,
				courseDescription, timeSlot, dataColStudent);
		this.grade = grade;
	}
	
	/**
	 * @author Matthew Alpert
	 * @return the letter grade received in the course.
	 */
	public String getGrade(){
		return grade;
	}

}
