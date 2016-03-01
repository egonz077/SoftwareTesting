package ApplicationLogic;

import static org.junit.Assert.*;

import org.junit.Test;

import Storage.ClassDetails;
import Storage.Course;
import Storage.Professor;
import Storage.Time;

/*
 * hasConflict method has been edited to print its two days arrays for testing purposes
 */
public class ClassDetailsConflictTester {

	
	
	
	@Test
	public void SM_001CD_Unit_TC001()
	{
		Course course1 = new Course("History", "1000");
		Professor teacher1 = new Professor("123456789","John","Doe");
		Time time1 = new Time(6,30,7,30,"1010100");
		
		Course course2 = new Course("Psychology", "2000");
		Professor teacher2 = new Professor("987654321","Mary","Smith");
		Time time2 = new Time(6,30,7,30,"1010100");
		
		ClassDetails class1 = new ClassDetails(course1,"1000",teacher1,"101","FIU","Fall",time1);
		ClassDetails class2 = new ClassDetails(course2, "2000", teacher2,"102","FIU","Fall", time2);
		
		assertTrue("hasConflict should return true for two classes starting at exact same time", class1.hasConflict(class2));
	}
	
	@Test
	public void SM_001CD_Unit_TC002()
	{
		Course course1 = new Course("History", "1000");
		Professor teacher1 = new Professor("123456789","John","Doe");
		Time time1 = new Time(6,30,8,00,"1010100");
		
		Course course2 = new Course("Psychology", "2000");
		Professor teacher2 = new Professor("987654321","Mary","Smith");
		Time time2 = new Time(7,00,9,00,"1010100");
		
		ClassDetails class1 = new ClassDetails(course1,"1000",teacher1,"101","FIU","Fall",time1);
		ClassDetails class2 = new ClassDetails(course2, "2000", teacher2,"102","FIU","Fall", time2);
		
		assertTrue("hasConflict should return true for when class1 end time overlaps with class2 beginning time", class1.hasConflict(class2));
	}
	
	@Test
	public void SM_001CD_Unit_TC003()
	{
		Course course1 = new Course("History", "1000");
		Professor teacher1 = new Professor("123456789","John","Doe");
		Time time1 = new Time(7,00,9,00,"1010100");
		
		Course course2 = new Course("Psychology", "2000");
		Professor teacher2 = new Professor("987654321","Mary","Smith");
		Time time2 = new Time(6,30,8,00,"1010100");
		
		ClassDetails class1 = new ClassDetails(course1,"1000",teacher1,"101","FIU","Fall",time1);
		ClassDetails class2 = new ClassDetails(course2, "2000", teacher2,"102","FIU","Fall", time2);
		
		assertTrue("hasConflict should return true for when class2 end time overlaps with class1 beginning time", class1.hasConflict(class2));
	}
	@Test
	public void SM_001CD_Unit_TC004()
	{
		Course course1 = new Course("History", "1000");
		Professor teacher1 = new Professor("123456789","John","Doe");
		Time time1 = new Time(7,00,9,00,"1010100");
		
		Course course2 = new Course("Psychology", "2000");
		Professor teacher2 = new Professor("987654321","Mary","Smith");
		Time time2 = new Time(10,00,11,00,"1010100");
		
		ClassDetails class1 = new ClassDetails(course1,"1000",teacher1,"101","FIU","Spring 2007",time1);
		ClassDetails class2 = new ClassDetails(course2, "2000", teacher2,"102","FIU","Spring 2007", time2);
		
		assertFalse("hasConflict should return false for two unconflicting classes ", class1.hasConflict(class2));
	}
	
	
	
}
