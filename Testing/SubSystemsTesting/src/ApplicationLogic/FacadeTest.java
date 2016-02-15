package ApplicationLogic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FacadeControllerTest {

	
	public FrontendFacade fc;
	@Before
	public void setUp() throws Exception {
		
		 fc = new FrontendFacade();
	}

	@After
	public void tearDown() throws Exception {
		
		fc = null;
	}

	@Test
	public void testLogin1() {
		
		assertEquals("Logged In?", true, fc.login("1412412", "abc123"));
		
	}
	@Test
	public void testLogin2() {
		
		assertEquals("Logged In?", true, fc.login("2354235", "abc234"));
		
	}
	@Test
	public void testLogin3() {
		
		assertEquals("Logged In?", true, fc.login("2234523", "abc345"));
		
	}
	
	@Test
	public void testLogin4() {
		//User name doesn't exist, but password does
		assertEquals("Logged In?", false, fc.login("445984253", "abc123"));
		
	}
	@Test
	public void testLogin5() {
		//User name exists, but password does not
		assertEquals("Logged In?", false, fc.login("2354235", "!@#$%"));
		
	}
	@Test
	public void testLogin6() {
		//Neither User name or password exists in the database
		assertEquals("Logged In?", false, fc.login("2yourmom23", "1256738fjden"));
	}
	/*
	

	@Test
	public void testCreateScheduleScheduleOptions1() {
		
		
		Collection<String> courses = new ArrayList<String>();
        courses.add("HIS1010");
        courses.add("STA3510");
        courses.add("COP2210");
        courses.add("COP3145");
        courses.add("PHY2048");
        courses.add("COP4338");
        
       //System.out.println(fc.createSchedule("Spring 2007", courses, "All", "1111111"));

		assertEquals("Collection:", "[Storage.Schedule@77afea7d, Storage.Schedule@161cd475, Storage.Schedule@532760d8, Storage.Schedule@57fa26b7, Storage.Schedule@5f8ed237, Storage.Schedule@2f410acf, Storage.Schedule@47089e5f, Storage.Schedule@4141d797, Storage.Schedule@68f7aae2, Storage.Schedule@4f47d241, Storage.Schedule@4c3e4790, Storage.Schedule@38cccef, Storage.Schedule@5679c6c6, Storage.Schedule@27ddd392, Storage.Schedule@19e1023e, Storage.Schedule@7cef4e59, Storage.Schedule@64b8f8f4, Storage.Schedule@2db0f6b2]", fc.createSchedule("Spring 2007", courses, "All", "1111111").toString());
	}
	
	@Test
	public void testCreateScheduleScheduleOptions2() {
		
		
		Collection<String> courses = new ArrayList<String>();
        courses.add("HIS1010");
     
        courses.add("COP2210");
        courses.add("COP3145");
      
        courses.add("COP4338");
        
      // System.out.println(fc.createSchedule("Spring 2007", courses, "All", "1111111"));

		assertEquals("Collection:", "[Storage.Schedule@2a3046da, Storage.Schedule@2a098129, Storage.Schedule@198e2867, Storage.Schedule@12f40c25, Storage.Schedule@3ada9e37, Storage.Schedule@5cbc508c, Storage.Schedule@3419866c, Storage.Schedule@63e31ee, Storage.Schedule@68fb2c38, Storage.Schedule@567d299b, Storage.Schedule@2eafffde, Storage.Schedule@59690aa4, Storage.Schedule@6842775d, Storage.Schedule@574caa3f, Storage.Schedule@64cee07, Storage.Schedule@1761e840, Storage.Schedule@6c629d6e, Storage.Schedule@5ecddf8f]", fc.createSchedule("Spring 2007", courses, "All", "1111111").toString());
	}
	
	@Test
	public void testCreateScheduleScheduleOptions3() {
		
		
		Collection<String> courses = new ArrayList<String>();
        
        courses.add("COP2210");
        
        
      // System.out.println(fc.createSchedule("Spring 2007", courses, "All", "1111111"));

		assertEquals("Collection:", "[Storage.Schedule@27abe2cd, Storage.Schedule@5f5a92bb]", fc.createSchedule("Spring 2007", courses, "All", "1111111").toString());
	}


	@Test
	public void testBuildSchedulesPage() {
		fail("Not yet implemented");
	}
	*/
}
