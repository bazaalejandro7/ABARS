
import java.util.ArrayList;



/**
 * Changelog: Matthew Alpert - getTranscript, bidCourses- 10/16/2014
 * @author William
 * @version 1.5
 * @created 16-Oct-2014 3:32:01 AM
 */
public class Student {

	/**
	 * Array of objects, first bracket is the rows and where the course object is held,
	 * second bracket is the number of columns and the number of points bid on the
	 * course. Only two columns, second number should never exceed 1 (0 is first
	 * column, 1 is second).
	 */
	private ArrayList<BidCourse> bidCourses;
	private ArrayList<GradedCourse> coursesTaken;
	private ArrayList<Course> currentSchedule;
	private int numID;
	private int numPoints;
	private String password;
	private String username;
	private String name, address;

	public Student(){
		bidCourses = new ArrayList<BidCourse>();
	}

	public Student(ArrayList<GradedCourse> coursesTaken, int numID, int numPoints,
			String password, String username, String name, String address) {
		this.coursesTaken = coursesTaken;
		this.numID = numID;
		this.numPoints = numPoints;
		this.password = password;
		this.username = username;
		this.name = name;
		this.address = address;
		bidCourses = new ArrayList<BidCourse>();
		currentSchedule = new ArrayList<Course>();
	}

	/**
	 * 
	 * @param courses    courses
	 * Matt:
	 * added bidPoints
	 * difficultly adding course and point value to 2d arraylist
	 */
	public void addCourse(Course course, int bidPoints){
		if(coursesTaken.contains(course) && bidPoints <= numPoints){
			bidCourses.add(new BidCourse(course.getCourseNum(), course.getCredits(),
					course.getCorequisite(), course.getPrerequisites(),
					course.getCourseDescription(), course.getTimeSlot(), course.getDataColCourse(), bidPoints));
		}else{
			//error message
		}
		
	}

	/**
	 * 
	 * @param courses    courses
	 */
	public void dropCourse(BidCourse dropCourse){
		numPoints += dropCourse.getBid();
		bidCourses.remove(dropCourse);
	}

	public ArrayList<Course> getCurrentSchedule() {
		return currentSchedule;
	}

	public void setCurrentSchedule(ArrayList<Course> currentSchedule) {
		this.currentSchedule = currentSchedule;
	}

	public int getNumPoints() {
		return numPoints;
	}

	public void setNumPoints(int numPoints) {
		this.numPoints = numPoints;
	}

	public int getNumID() {
		return numID;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public String getAddress() {
		return address;
	}

	public void setName(String text) {
		// TODO Auto-generated method stub
		name = text;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public void setAddress(String text) {
		// TODO Auto-generated method stub
		address = text;
	}
	public ArrayList<GradedCourse> getCoursesTaken(){
		System.out.println(coursesTaken);
		return coursesTaken;
	}

	
}//end Student