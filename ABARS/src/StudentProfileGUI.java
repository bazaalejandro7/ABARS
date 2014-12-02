import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



//Class StudentProfileGui
//A Panel that displays the student's information

@SuppressWarnings("serial")
public class StudentProfileGUI extends JPanel {
	/***
	 * Class for the Student Profile GUI
	 * <p>Displays Student information and Logout Button</p>
	 */
	//Panel Data Fields
	private Student student;
	private final String[] labelPrefixes={"Username: ","Name: ","ID: "};
	private JLabel[] dataLabels=new JLabel[3];
	private MainFrameGUI mainFrame;

	//Panel No argument constructor
	public StudentProfileGUI(){

	}

	//Main Panel Constructor with student input
	/***
	 * Constructor for the Student Profile GUI
	 * 
	 * @param Student student
	 */
	public StudentProfileGUI(Student student,MainFrameGUI mainFrame){
		JButton logoutButton,changePassButton;
		JPanel tempPanel=new JPanel();

		this.mainFrame=mainFrame;
		this.student=student;

		this.setLayout(new GridLayout(2,1));
		tempPanel.setLayout(new GridLayout(6,1));

		tempPanel.add(new JLabel("Student Information"));

		for(int i=0;i<dataLabels.length;i++){
			dataLabels[i]=new JLabel();
			tempPanel.add(dataLabels[i]);
		}

		changePassButton=new JButton("Change Password");
		logoutButton=new JButton("Logout");

		changePassButton.addActionListener(new ChangePasswordListener());

		tempPanel.add(changePassButton);
		tempPanel.add(logoutButton);
		logoutButton.addActionListener(new LogoutListener());

		this.add(tempPanel);
		this.add(new JLabel());
		updateData();
	}


	public void setStudent(Student student){
		this.student=student;
		updateData();
	}

	//Method to update the data labels
	/***
	 * Void method that updates the panel Labels
	 */
	private void updateData(){
		dataLabels[0].setText(labelPrefixes[0]+student.getUsername());
		dataLabels[1].setText(labelPrefixes[1]+student.getName());
		dataLabels[2].setText(labelPrefixes[2]+student.getNumID());
	}

	/***Logout listener Class
	 * <p>Shuts Down Program (Later Versions will Return to Login)</p>
	 * @author William Merritt
	 *
	 */

	class LogoutListener implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			//mainFrame.setVisible(false);
			mainFrame.logout();



		}
	}

	class ChangePasswordListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ChangePasswordPanel.changePasswordGui(student);
		}
	}



}