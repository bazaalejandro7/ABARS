import java.io.IOException;

import javax.swing.JScrollPane;

/**
 * Course: SE 300- 01
 * Term: Fall 2014
 * Final Project
 * @author courtneyfennell
 * @created November 11, 2014
 */
@SuppressWarnings("serial")
public class RegisterPaneGUI extends JScrollPane {
	/**this constructor creates the Scroll pane for the register panel.
	 * 
	 * @param student
	 * @throws BiffException
	 * @throws IOException
	 */
	public RegisterPaneGUI(Student student) throws IOException{
		RegisterGUI register = new RegisterGUI(student);
		this.getViewport().add(register);
	}
}
