package ApplicationLogic;

import static org.junit.Assert.*;

import org.junit.Test;

import Storage.ClassDetails;
import Storage.Course;
import Storage.Professor;
import Storage.Time;
public class ClassDetailsIsAtDayTester {

	
	@Test
	public void SM_001CD_Unit_TC007()
	{
		Course course1 = new Course("History", "1000");
		Professor teacher1 = new Professor("123456789","John","Doe");
		Time time1 = new Time(7,00,9,00,"1010100");
		
		ClassDetails class1 = new ClassDetails(course1,"1000",teacher1,"101","FIU","Fall",time1);
		
		assertTrue("isAtDay returns true for 2 entered since class1 takes place on the 3rd day of the week (Wednesday)", class1.isAtDay(2));
	}
	@Test
	public void SM_001CD_Unit_TC008()
	{
		Course course1 = new Course("History", "1000");
		Professor teacher1 = new Professor("123456789","John","Doe");
		Time time1 = new Time(7,00,9,00,"1010100");
		
		ClassDetails class1 = new ClassDetails(course1,"1000",teacher1,"101","FIU","Fall",time1);
		
		assertFalse("isAtDay returns true for 2 entered since class1 takes place on the 3rd day of the week (Wednesday)", class1.isAtDay(3));
	}
}
