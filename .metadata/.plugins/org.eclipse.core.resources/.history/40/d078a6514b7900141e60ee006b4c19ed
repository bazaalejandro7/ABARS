import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



/**
 * @author Matthew Alpert
 * @version 1.5
 * @created 16-Oct-2014 3:32:01 AM
 * This class creates a student object with various data fields.
 * It includes a personal information, transcript, courses currently
 * bid on, and a current schedule (after the auction has run).  
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
	private int dataRow;
	
	/**
	 * @author Matthew Alpert
	 * @param coursesTaken - ArrayList of type GradedCourse which hold a list of courses graded and taken. Used in transcript
	 * @param numID - the student's ID number
	 * @param numPoints - total number of points the student can use to bid on classes
	 * @param password - student's login password
	 * @param username - student's login username
	 * @param name - student's personal name
	 * @param address - student's personal address
	 * @param dataRow - for database use, indicates the row the student is located in
	 */
	public Student(ArrayList<GradedCourse> takenCourses, ArrayList<BidCourse> coursesBid, ArrayList<Course> scheduleCurrent,int numID, int numPoints,
			String password, String username, String name, String address, int dataRow) {
		
		this.numID = numID;
		this.numPoints = numPoints;
		this.password = password;
		this.username = username;
		this.name = name;
		this.address = address;
		
		
		bidCourses = new ArrayList<BidCourse>();
		for(int i = 0; i < coursesBid.size(); i++){
			bidCourses.add(coursesBid.get(i));
		}
		coursesTaken = new ArrayList<GradedCourse>();
		for(int i = 0; i < takenCourses.size(); i++){
			coursesTaken.add(takenCourses.get(i));
		}
		currentSchedule = new ArrayList<Course>();
		for(int i = 0; i < scheduleCurrent.size(); i++){
			currentSchedule.add(scheduleCurrent.get(i));
		}
		this.dataRow = dataRow;
		
	}

	/**
	 * @author Matthew Alpert
	 * @param course - the course the student is bidding on to take for the next semester, will add to the database
	 * @param bidPoints - number of points the student is using for the bid on the course, will add to the database
	 * @return boolean - whether or not the student has successfully added the class
	 * Edit 11/15/14 by Courtney Fennell - Change return value from void to boolean and fix a logical error.
	 * @throws IOException 
	 * @throws WriteException 
	 * @throws BiffException 
	 */
	public boolean addCourse(Course course, int bidPoints) throws IOException{
		if(!coursesTaken.contains(course) && bidPoints <= numPoints){
			bidCourses.add(new BidCourse(course.getCourseNum(), course.getCredits(),
					course.getCorequisite(), course.getPrerequisites(),
					course.getCourseDescription(), course.getDataColCourse(), bidPoints));
			numPoints-=bidPoints;
			
			writeDatabase(course.getDataColCourse(), bidPoints);
			writeDatabase(5, numPoints);
			
			return true;
			
		}else{
			return false;
		}
		
	}

	/**
	 * @author Matthew Alpert
	 * @param dropCourse - BidCourse object that the student wishes to drop their bid for
	 * @throws IOException 
	 */
	public void dropCourse(BidCourse dropCourse) throws IOException{
		numPoints += dropCourse.getBid();
		bidCourses.remove(dropCourse);

		writeDatabase(dropCourse.getDataColCourse(), dropCourse.getBid());
		writeDatabase(5, numPoints);
		
	}

	/**
	 * @author Matthew Alpert
	 * @return the currentSchedule of the student
	 * currentSchedule will only have Course objects inside it after the auction has run
	 */
	public ArrayList<Course> getCurrentSchedule() {
		return currentSchedule;
	}

	/**
	 * @author Matthew Alpert
	 * @param currentSchedule - sets the schedule that the student has been placed into to
	 * @throws IOException 
	 */
	public void setCurrentSchedule(ArrayList<Course> currentSchedule) throws IOException {
		this.currentSchedule = currentSchedule;
		for(int i  = 0; i < currentSchedule.size(); i++){
			writeDatabase(currentSchedule.get(i).getDataColCourse(), "I");
		}
	}

	/**
	 * @author Matthew Alpert
	 * @return current the number of points a student has to bid on courses
	 */
	public int getNumPoints() {
		return numPoints;
	}

	/**
	 * @author Matthew Alpert
	 * @param numPoints - current total number of points the student can use to bid on classes
	 * @throws IOException 
	 */
	public void setNumPoints(int numPoints) throws IOException {
		this.numPoints = numPoints;

		writeDatabase(5, numPoints);
	}

	/**
	 * @author Matthew Alpert
	 * @return the student's ID number
	 */
	public int getNumID() {
		return numID;
	}

	/**
	 * @author Matthew Alpert
	 * @return student's login password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @author Matthew Alpert
	 * @return student's login username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @author Matthew Alpert
	 * @return student's personal address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @author Matthew Alpert
	 * @param text - student's personal name
	 * @throws IOException 
	 */
	public void setName(String text) throws IOException {
		name = text;
		writeDatabase(3, text);
	}

	/**
	 * @author Matthew Alpert
	 * @return student's personal name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @author Matthew Alpert
	 * @param text - student's personal address
	 * @throws IOException 
	 */
	public void setAddress(String text) throws IOException {
		address = text;
		writeDatabase(4, text);
	}
	
	/**
	 * @author Matthew Alpert
	 * @return ArrayList of type GradedCourse which hold a list of courses graded and taken. Used in transcript
	 */
	public ArrayList<GradedCourse> getCoursesTaken(){
		return coursesTaken;
	}
	/**
	 * @author Courtney Fennell
	 * @return ArrayList of type BidCourse which hold a list of courses the student has bid on.
	 */
	public ArrayList<BidCourse> getBidCourses(){
		return bidCourses;
	}
	
	/**
	 * @author Matthew Alpert
	 * @param col - column to be written over
	 * @param newString - new string to be written (either a grade or I for in progress)
	 * @throws IOException
	 * 
	 */
	private void writeDatabase(int col, String newString) throws IOException{
		
		String[] curRow = new String[46];
		Scanner scan = new Scanner(new File("StudentDb.txt"));
		String temp = scan.nextLine() + "\n";
		
		for(int i = 1; i < dataRow; i++){
			temp += scan.nextLine() + "\n";
		}
		
		curRow = scan.nextLine().split("	");
		curRow[col] = newString;
		temp += curRow[0];
		
		for(int i = 1; i < 46; i++){
			temp += "	" + curRow[i];
		}
		
		while(scan.hasNextLine()){
			temp += "\n" + scan.nextLine();
		}
		scan.close();
		
		Scanner scanTemp = new Scanner(temp);
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("StudentDb.txt")));
		while(scanTemp.hasNextLine()){
			writer.write(scanTemp.nextLine());
			writer.newLine();
		}
		
		writer.close();
	}
	
	/**
	 * @author Matthew Alpert
	 * @param col - column to be written over
	 * @param numBid - number of bid points
	 * @throws IOException
	 */
	private void writeDatabase(int col, int numBid) throws IOException{

		String[] curRow = new String[46];
		Scanner scan = new Scanner(new File("StudentDb.txt"));
		String temp = scan.nextLine() + "\n";
		
		for(int i = 1; i < dataRow; i++){
			temp += scan.nextLine() + "\n";
		}
		
		curRow = scan.nextLine().split("	");
		curRow[col] = Integer.toString(numBid);
		temp += curRow[0];
		
		for(int i = 1; i < 46; i++){
			temp += "	" + curRow[i];
		}
		
		while(scan.hasNextLine()){
			temp += "\n" + scan.nextLine();
		}
		scan.close();
		
		Scanner scanTemp = new Scanner(temp);
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("StudentDb.txt")));
		while(scanTemp.hasNextLine()){
			writer.write(scanTemp.nextLine());
			writer.newLine();
		}
		
		writer.close();
	}
	
}//end Student