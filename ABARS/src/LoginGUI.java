
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LoginGUI extends JFrame{

	private Student student;
	private JTextField userField;
	private JPasswordField passField;


	public LoginGUI(){
		JButton button=new JButton("Submit");
		JPanel panel=new JPanel();

		userField=new JTextField();
		passField=new JPasswordField();

		button.addActionListener(new LoginButtonListener());
		passField.addActionListener(new LoginButtonListener());
		
		panel.setLayout(new GridLayout(5,1));
		panel.add(new JLabel("Enter Username"));
		panel.add(userField);
		panel.add(new JLabel("Password"));
		panel.add(passField);
		panel.add(button);

		add(panel);

		this.setSize(200,300);
		this.setLocationRelativeTo(null);
		//
		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}


	public static Student loginInStudent(){
		LoginGUI gui=new LoginGUI();
		Student logedInStudent;
		
		do{
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

			}
		}while (gui.getStudent()==null);
		
		logedInStudent=gui.getStudent();
		gui.dispose();
		return logedInStudent;
	}

	public Student getStudent(){
		return student;
	}
	public class LoginButtonListener implements ActionListener{
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
