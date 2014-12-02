
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePasswordPanel extends JPanel {
	

	private static final long serialVersionUID = -6432397431815207144L;
	private JPasswordField[] passFields=new JPasswordField[3];
	private Student student;
	private JFrame thisFrame;
	
	public static void changePasswordGui(Student student){
		JFrame frame=new JFrame();
		frame.add(new ChangePasswordPanel(student,frame));
		frame.setSize(200, 350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private ChangePasswordPanel(Student student,JFrame frame){
		
		JPanel fieldPanel=new JPanel();
		String[] prompts={"Enter Current Password","Enter New Password","Re-enter New Password"};
		JButton button =new JButton("Enter");
		
		this.thisFrame=frame;
		this.student=student;
		
		//Setting Layouts
		this.setLayout(new BorderLayout());
		fieldPanel.setLayout(new GridLayout(6,1));
		
		for(int i=0;i<passFields.length;i++){
			fieldPanel.add(new JLabel(prompts[i]));
			passFields[i]=new JPasswordField();
			fieldPanel.add(passFields[i]);
		}
		this.add(fieldPanel,BorderLayout.CENTER);
		
		button.addActionListener(new ChangePasswordListener());
		this.add(button,BorderLayout.SOUTH);
		
	}
	class ChangePasswordListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(new String(passFields[1].getPassword()).equals(new String(passFields[2].getPassword()))){
				if(!student.getPassword().equals(new String(passFields[0].getPassword()))){
					JOptionPane.showMessageDialog(null, "ERROR: Incorrect Password");
				}
				else{
					JOptionPane.showMessageDialog(null, "Password Successfully Changed");
					student.setPassword(new String (passFields[1].getPassword()));
					thisFrame.dispose();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "ERROR: Entered Password do not match");
			}
		}
	}
	
}