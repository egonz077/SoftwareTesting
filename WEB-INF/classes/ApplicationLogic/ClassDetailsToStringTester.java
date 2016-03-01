package ApplicationLogic;
import static org.junit.Assert.*;

import org.junit.Test;

import Storage.ClassDetails;
import Storage.Course;
import Storage.Professor;
import Storage.Time;
public class ClassDetailsToStringTester {

	@Test
	public void SM_001CD_Unit_TC009()
	{
		Course course1 = new Course("History", "1000");
		Professor teacher1 = new Professor("123456789","John","Doe");
		Time time1 = new Time(7,00,9,00,"1010100");
		
		ClassDetails class1 = new ClassDetails(course1,"1000",teacher1,"101","FIU","Fall",time1);
		
		System.out.print(class1.toString());
		assertEquals("Should print everything when campus and time are non-null", 
				"History1000" + "\n" + "1000" + "\n" +
					   "7:0-9:0" + "\n"
						+ "FIU" + "\n", class1.toString());
		
		
	}
	
	@Test
	public void SM_001CD_Unit_TC010()
	{
		Course course1 = new Course("History", "1000");
		Professor teacher1 = new Professor("123456789","John","Doe");
		Time time1 = null;
		
		ClassDetails class1 = new ClassDetails(course1,"1000",teacher1,"101","FIU","Fall",time1);
		
		assertEquals("Should omit time details since time is null", 
				"History1000" + "\n" + "1000" + "\n" 
							+ "FIU" + "\n", class1.toString());
	}
	
	@Test
	public void SM_001CD_Unit_TC011()
	{
		Course course1 = new Course("History", "1000");
		Professor teacher1 = new Professor("123456789","John","Doe");
		Time time1 = new Time(7,00,9,00,"1010100");
		
		ClassDetails class1 = new ClassDetails(course1,"1000",teacher1,"101",null,"Fall",time1);
		
		assertEquals("Should omit campus details since campus is null", 
				"History1000" + "\n" + "1000" + "\n" +
						   "7:0-9:0" + "\n", class1.toString());
	}
	
}
