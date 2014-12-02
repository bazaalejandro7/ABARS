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

<<<<<<< HEAD
	public static void main(String[] args) throws BiffException, IOException {
		//if(currStudent.isInstanceof(Student))
			//new MainFrameGUI(currStudent);
		//else
			//new AdminGUI();
			
	}
	
=======

>>>>>>> origin/master
	public Starter(){
		
	}
	
	public void createLogin(){
		new LoginGUI(this);
	}
	public void startMain(Student student){;
		try {
			new MainFrameGUI(student);
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
=======

>>>>>>> origin/master
	}
}
