import java.io.IOException;

import jxl.read.biff.BiffException;

/**
 * 
 * @author Matthew
 * @date October 30, 2014
 * Make a Login object with the username and password as parameters
 * Then use the ValidateLogin method
 */
public class Login {
	
	private String username, password;
	
	public Login(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	
	/**
	 * 
	 * @return the student associated with the input login information
	 */
	public Student ValidateLoginStudent(){

		StudentDatabase studentDB = null;
		try {
			studentDB = new StudentDatabase();
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		
		return studentDB.Validate(username, password);
		
	}
	
	
	/**
	 * 
	 * @return true if the input login information is valid, and false if the input login information is false
	 */
	public boolean ValidateLoginBoolean(){
		
		StudentDatabase studentDB = null;
		try {
			studentDB = new StudentDatabase();
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		
		if(studentDB.Validate(username, password) != null){
			return true;
		}else{
			return false;
		}
			
	}
}
