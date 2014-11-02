import java.util.ArrayList;


/**
 * 
 * @author Matthew Alpert
 * Subclass of Course. Contains the points bid on
 * each course they wish to take.
 */
public class BidCourse extends Course {

	private int bid;



	public BidCourse(String courseNum, int credits, Course corequisite,
			ArrayList<Course> prerequisites, String courseDescription,
			int timeSlot, int dataColStudent, int bid) {
		super(courseNum, credits, corequisite, prerequisites, courseDescription,
				timeSlot, dataColStudent);
		this.bid = bid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}


}
