
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LoginGUI extends JFrame{

	private Student student;
	private JTextField userField;
	private JPasswordField passField;

	/**This Class is a JFrame object that prompts the user for username and password
	 * 
	 * @author William Merritt
	 * @version 1.0
	 * 
	 * 
	 */
	/**Main Constructor: Creates and displays the Frame of the login
	 * 
	 */
	public LoginGUI(){
		JButton button=new JButton("Submit");
		JPanel panel=new JPanel();
		JPanel superPanel=new JPanel();
		userField=new JTextField();
		passField=new JPasswordField();
		
		button.addActionListener(new LoginButtonListener());
		passField.addActionListener(new LoginButtonListener());
		
		superPanel.setLayout(new BorderLayout());

		panel.setLayout(new GridLayout(4,1));
		
		panel.add(new JLabel("Enter Username"));
		panel.add(userField);
		panel.add(new JLabel("Password"));
		panel.add(passField);


		superPanel.add(panel,BorderLayout.CENTER);
		superPanel.add(button,BorderLayout.SOUTH);
		this.add(superPanel);
		this.setSize(180,180);
		this.setLocationRelativeTo(null);
		//
		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}

	/*** This is a method that will create an instance of the class and will return the User's object after a successful login
	 * 
	 * 
	 * @return User Object
	 */
	public static Student loginInStudent(){
		
		LoginGUI gui=new LoginGUI(); //Creating instance of class
		Student logedInStudent; //Declaring user variable
		
		do{ //Do loop waiting for successful login
			try {
				Thread.sleep(10); 
			} catch (InterruptedException e) {

			}
		}while (gui.getStudent()==null);
		
		logedInStudent=gui.getStudent(); //gets User from the loginGui object
		gui.dispose(); //disposes the gui
		return logedInStudent;
	}

	public Student getStudent(){
		return student;
	}
	
	/**
	 * Private Listener Class for the login Button
	 * 
	 * @author William Merritt
	 *
	 */
	private class LoginButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Student tempStudent;
			Login login=new Login(userField.getText(),new String(passField.getPassword()));
			tempStudent=login.ValidateLoginStudent();

			if(tempStudent!=null){
				student=tempStudent;
			}
			else{
				JOptionPane.showMessageDialog(null, "Incorrect Username/Password");
			}

		}
	}
}
