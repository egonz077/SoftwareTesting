package ApplicationLogic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FacadeTest {

	
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
		assertEquals("Logged In?", false, fc.login("tumadre3", "1256738fjden"));
	}

	

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

		assertEquals("Collection:", true, fc.createSchedule("Spring 2007", courses, "All", "1111111").toString());
	}
	
	@Test
	public void testCreateScheduleScheduleOptions2() {
		
		
		Collection<String> courses = new ArrayList<String>();
        courses.add("HIS1010");
     
        courses.add("COP2210");
        courses.add("COP3145");
      
        courses.add("COP4338");
        
      // System.out.println(fc.createSchedule("Spring 2007", courses, "All", "1111111"));

		assertEquals("Collection:", true, fc.createSchedule("Spring 2007", courses, "All", "1111111").toString());
	}
	
	@Test
	public void testCreateScheduleScheduleOptions3() {
		
		
		Collection<String> courses = new ArrayList<String>();
        
        courses.add("COP2210");
        
        
      // System.out.println(fc.createSchedule("Spring 2007", courses, "All", "1111111"));

		assertEquals("Collection:", true, fc.createSchedule("Spring 2007", courses, "All", "1111111").toString());
	}


	@Test
	public void testBuildSchedulesPage() {
		fail("Not yet implemented");
	}

}
