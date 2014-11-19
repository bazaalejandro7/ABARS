import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Class StudentProfileGui
//A Panel that displays the student's information

@SuppressWarnings("serial")
public class StudentProfileGUI extends JPanel {

	//Panel Data Fields
	private Student student;
	private final String[] labelPrefixes={"Username: ","Name: ","ID: "};
	private JLabel[] dataLabels=new JLabel[3];


	//Panel No argument constructor
	public StudentProfileGUI(){

	}

	//Main Panel Constructor with student input
	public StudentProfileGUI(Student student){
		JButton logoutButton;


		this.student=student;

		this.setLayout(new GridLayout(5,1));

		this.add(new JLabel("Student Information"));

		for(int i=0;i<dataLabels.length;i++){
			dataLabels[i]=new JLabel();
			this.add(dataLabels[i]);
		}


		logoutButton=new JButton("Logout");

		this.add(logoutButton);
		logoutButton.addActionListener(new LogoutListener());

		updateData();
	}


	public void setStudent(Student student){
		this.student=student;
		updateData();
	}

	//Method to update the data labels
	public void updateData(){
		dataLabels[0].setText(labelPrefixes[0]+student.getUsername());
		dataLabels[1].setText(labelPrefixes[1]+student.getName());
		dataLabels[2].setText(labelPrefixes[2]+student.getNumID());
	}
	
	class LogoutListener implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			System.exit(1);

		}
	}




}