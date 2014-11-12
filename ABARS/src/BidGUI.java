
import java.io.IOException;

import javax.swing.JPanel;

import jxl.read.biff.BiffException;
/**
 * 
 * @author courtneyfennell
 *
 */

@SuppressWarnings("serial")
public class BidGUI extends JPanel {
	Student currStudent;
	
	/**
	 * 
	 * @param student
	 * @throws BiffException
	 * @throws IOException
	 */
	public BidGUI(Student student) throws BiffException, IOException{
	//this is where a student can drop a class
		
		currStudent = student;
	
	}
}
