package ApplicationLogic;
import static org.junit.Assert.*;

import org.junit.Test;

import Storage.ClassDetails;
import Storage.Course;
import Storage.Professor;
import Storage.Time;
public class ClassDetailsIsAtTimeTester {
	
	@Test
	public void SM_001CD_Unit_TC005()
	{
		Course course1 = new Course("History", "1000");
		Professor teacher1 = new Professor("123456789","John","Doe");
		Time time1 = new Time(7,00,9,00,"1010100");
		
		ClassDetails class1 = new ClassDetails(course1,"1000",teacher1,"101","FIU","Fall",time1);
		
		assertTrue("isAtTime returns true for 8 which is within the range of 7-9", class1.isAtTime(8));
	}
	@Test
	public void SM_001CD_Unit_TC006()
	{
		Course course1 = new Course("History", "1000");
		Professor teacher1 = new Professor("123456789","John","Doe");
		Time time1 = new Time(7,00,9,00,"1010100");
		
		ClassDetails class1 = new ClassDetails(course1,"1000",teacher1,"101","FIU","Fall",time1);
		
		assertFalse("isAtTime returns true for 8 which is within the range of 7-9", class1.isAtTime(10));
	}
	
}
