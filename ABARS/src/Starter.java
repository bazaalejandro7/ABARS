import java.io.IOException;

import jxl.read.biff.BiffException;

/**
 * 
 * @author Courtney Fennell
 * 
 * This class acts as a starter for the entire program. It starts the program by containing the main method and running it
 *
 */
public class Starter {

	public static void main(String[] args) throws BiffException, IOException {
		Student currStudent =LoginGUI.loginInStudent();
		//if(currStudent.isInstanceof(Student))
			new MainFrameGUI(currStudent);
		//else
			//new AdminGUI();
			

	}

}
