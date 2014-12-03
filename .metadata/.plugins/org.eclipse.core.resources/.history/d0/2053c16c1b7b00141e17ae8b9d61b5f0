import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Matthew Alpert
 * @version 1.5
 * @created 16-Oct-2014 3:32:00 AM
 * 
 * This class utilizes the open source API JExcel.
 * Using JExcel, this class reads in and creates all
 * the course objects in the database.
 */
public class CourseDatabase {

	private ArrayList<Course> courseList;
	
	/**
	 * @author Matthew Alpert
	 * @throws BiffException
	 * @throws IOException
	 * Constructs the course database
	 */
	public CourseDatabase() throws IOException{
		
		
		File file = new File("CourseDb.txt");
		Scanner scan = new Scanner(file);
		
		String line;
		String[] curRow = new String[6];
		scan.nextLine(); //sets the scanner at the correct position in the database
		
		courseList = new ArrayList<Course>();
		ArrayList<Course> prerequisiteCourse = new ArrayList<Course>();
		Course newCourse, corequisiteCourse;
		String prerequisite, corequisite, description;
		int credits, dataColStudent;
		int countRow = 1;
		
		String nullString = "null"; //null in the database means there is not a corequisite or prerequisite in that slot
		
//		adding in all the courses in the database
		while(scan.hasNextLine()){
			corequisite = prerequisite = null;
			corequisiteCourse = null;
			prerequisiteCourse.clear();
			
			line = scan.nextLine();
			curRow = line.split("	"); //items are separated by tabs
			
			credits = Integer.parseInt(curRow[1]); //set course credits
			description = curRow[5]; //set course description
			dataColStudent = countRow + 3;
			
//			checking for corequisite
			if(!curRow[2].equals(nullString)){
				corequisite = curRow[2];
				corequisiteCourse = searchFor(corequisite);
			}
//			checking for prerequisites, max of 2 prerequisites
			if(!curRow[4].equals(nullString)){ //this looks to see if the course has 2 prerequisites
				for(int i = 3; i <= 4; i++){
					prerequisite = curRow[i];
					prerequisiteCourse.add(searchFor(prerequisite));
				}
			}else if(!curRow[3].equals(nullString)){ //this looks to see if the course has 1 prerequisite
					prerequisite = curRow[3];
					prerequisiteCourse.add(searchFor(prerequisite));
			}
			
//			add course to the database 
			newCourse = new Course(curRow[0], credits, corequisiteCourse, prerequisiteCourse, description, dataColStudent);
			courseList.add(newCourse);
			countRow++;
		}
		scan.close();
	}

	/**
	 * @author Matthew Alpert
	 * @param someCourse - a given course name (example: SE 300)
	 * @return the course object with the same given name, otherwise return null.
	 * This method searches for the course object inside the database.
	 */
	private Course searchFor(String someCourse){

		int i = 0;

		while(!(courseList.get(i).getCourseNum().equals(someCourse)) && i<courseList.size()){
			i++;
		}

		if(i == courseList.size()){
			return null;
		}else{
			return courseList.get(i);
		}
	}

	/**
	 * @author Matthew Alpert
	 * @param courseName - a given course name (example: SE 300)
	 * @return course object or null. 
	 */
	public Course getCourse(String courseName){
		return searchFor(courseName);
	}

	/**
	 * @author Matthew Alpert
	 * @return all the courses listed in the course database
	 */
	public ArrayList<Course> getCourseList() {
		return courseList;
	}
	
	
}//end CourseDatabase