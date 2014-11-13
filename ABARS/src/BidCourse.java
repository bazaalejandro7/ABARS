import java.util.ArrayList;


/**
 * 
 * @author Matthew Alpert
 * Subclass of Course. Contains the points bid on
 * each course they wish to take. The higher the 
 * bid value, the better the chance to get into the course.
 */
public class BidCourse extends Course {

	private int bid;
	
	 /**
	  * @author Matthew Alpert
	  * @param bid - number of points the student is using for the bid on the course, will add to the database
	  * Creates a BidCourse object
	  */
	public BidCourse(String courseNum, int credits, Course corequisite,
			ArrayList<Course> prerequisites, String courseDescription,
			int timeSlot, int dataColStudent, int bid) {
		super(courseNum, credits, corequisite, prerequisites, courseDescription,
				timeSlot, dataColStudent);
		this.bid = bid;
	}

	/**
	 * @author Matthew Alpert
	 * @return number of points bid to a course
	 */
	public int getBid() {
		return bid;
	}

	/**
	 * @author Matthew Alpert
	 * @param number of points to bid on a course
	 */
	public void setBid(int bid) {
		this.bid = bid;
	}


}
