import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.*;
import jxl.read.biff.BiffException;



/**
 * @author Matthew Alpert
 * @version 1.0
 * @created 16-Oct-2014 3:32:00 AM
 */
public class CourseDatabase {

	private ArrayList<Course> courseList;
	
	public CourseDatabase() throws BiffException, IOException{
		Workbook workbook = Workbook.getWorkbook(new File("Course Database.xls"));
		Sheet sheet = workbook.getSheet(0);
		
		courseList = new ArrayList<Course>();
		ArrayList<Course> prerequisiteCourse = new ArrayList<Course>();
		Course newCourse, corequisiteCourse;
		String prerequisite, corequisite, description;
		int timeSlot, credits, dataColStudent;
		Cell[] cur = sheet.getRow(1);
		int countRow = 1;
		
//		adding in all the courses in the database
		while(cur[0].getType() != CellType.EMPTY){
			corequisite = prerequisite = null;
			corequisiteCourse = null;
			prerequisiteCourse.clear();;
			credits = Integer.parseInt(cur[3].getContents());
			description = cur[1].getContents();
			timeSlot = 1;
			dataColStudent = countRow + 3;
			
//			checking for corequisite
			if(cur[4].getType() != CellType.EMPTY){
				corequisite = cur[4].getContents();
				corequisiteCourse = searchFor(corequisite);
			}
//			checking for prerequisites, max of 3 prerequisites
			if(cur[6].getType() != CellType.EMPTY){
				for(int i = 5; i <= 6; i++){
					prerequisite = cur[i].getContents();
					prerequisiteCourse.add(searchFor(prerequisite));
				}
//			}else if(cur[5].getType() != CellType.EMPTY){
//				for(int i = 5; i <= 6; i++){
//					prerequisite = cur[i].getContents();
//					prerequisiteCourse.add(searchFor(prerequisite));
//				}
			}else if(cur[5].getType() != CellType.EMPTY){
					prerequisite = cur[5].getContents();
					prerequisiteCourse.add(searchFor(prerequisite));
			}
			
//			add course to the database 
			newCourse = new Course(cur[0].getContents(), credits, corequisiteCourse, prerequisiteCourse, description, timeSlot, dataColStudent);
			courseList.add(newCourse);
			countRow++;
			cur = sheet.getRow(countRow);
		}
	}

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
	
	public Course getCourse(String courseName){
		return searchFor(courseName);
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}
	
	
}//end CourseDatabase