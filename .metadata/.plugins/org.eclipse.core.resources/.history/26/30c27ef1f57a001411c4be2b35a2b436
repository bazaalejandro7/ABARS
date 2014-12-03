import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

public class ScheduleGUI extends JPanel {

	private Student student;
	private ArrayList<Course> courses;


	/**Constructor for the Schedule GUI 
	 * 
	 * @param Student student
	 */
	public ScheduleGUI(Student student){
		DefaultTableModel model;
		JTable table;
		String [] columns={"Course ID","Credits"};
		JScrollPane scroll;

		this.setStudent(student);
		model=new DefaultTableModel(this.getCourseData(),columns);
		table=new JTable(model);
		scroll=new JScrollPane(table);
		this.add(scroll);
	}

	public void setStudent(Student student){
		this.student=student;
		courses=student.getCurrentSchedule();
	}
	public Student getStudent(){
		return student;
	}

	/**Private method that returns the data for the Schedule Table
	 * 
	 * @return
	 */
	private Object[][] getCourseData(){

		Object[][] returnArray;
		if(courses==null||courses.size()!=0){
			returnArray =new Object[courses.size()][2];
			for(int i=0;i<courses.size();i++){
				returnArray[i][0]=courses.get(i).getCourseNum();
				returnArray[i][1]=courses.get(i).getCredits();
			}
		}
		else{
			returnArray=new String[1][2];
			returnArray[0][0]="No Current Classes";
			returnArray[0][1]="N/A";
		}

		return returnArray;
	}

}
