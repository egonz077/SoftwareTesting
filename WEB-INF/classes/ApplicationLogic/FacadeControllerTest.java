package ApplicationLogic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FacadeControllerTest {

	
	public FacadeController fc;
	@Before
	public void setUp() throws Exception {
		
		 fc = new FacadeController();
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

	@Test
	public void testCreateScheduleScheduleOptions() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateScheduleStringCollectionOfStringStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuildSchedulesPage() {
		fail("Not yet implemented");
	}

}
