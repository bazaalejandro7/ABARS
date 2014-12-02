import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author courtneyfennell
 *
 */
public class JUnitCourtney {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Class set up");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Class tear down");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("Test setup");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("Test teardown");
	}

	@Test
	public void testStudentDatabse() {
		try {
			new StudentDatabase();
		} catch (IOException |  IndexOutOfBoundsException e) {
			System.out.println("StudentDatabse test failed");
			fail("The student database was not successfully generated");
		}
		

	}
	@Test
	public void testValidate() {
		StudentDatabase studentDB = null;
		try {
			studentDB = new StudentDatabase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(studentDB.Validate("painT", "Eagles"), null);
		
	}
}
