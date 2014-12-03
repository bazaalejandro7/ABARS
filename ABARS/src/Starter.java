import java.io.IOException;

/**
 * 
 * @author Courtney Fennell
 * 
 * This class acts as a starter for the entire program. It starts the program by containing the main method and running it
 *
 */
public class Starter {
	
	public static void main(String[] args) throws IOException {
		Starter start=new Starter();
		start.createLogin();
		
	}
	public Starter(){
		
	}
	
	public void createLogin(){
		new LoginGUI(this);
	}
	public void startMain(Student student){;
		try {
			new MainFrameGUI(student);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
