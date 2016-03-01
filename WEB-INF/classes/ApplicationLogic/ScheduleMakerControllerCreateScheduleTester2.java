package ApplicationLogic;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Storage.ClassDetails;
import Storage.Course;
import Storage.DatabaseStub;
import Storage.Professor;
import Storage.Schedule;
import Storage.Time;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
public class ScheduleMakerControllerCreateScheduleTester2 {
	
	
	//Compare Methods
    private boolean compareCollectionofSchedule(Collection<Object> one, Collection<Object> two) {
        if (one != null) {
            if (two == null)
                return false;

            Iterator<Object> ScheduleIterator1 = one.iterator();
            Iterator<Object> ScheduleIterator2 = two.iterator();

            //Comparing all Schedule Objects
            if (ScheduleIterator1.hasNext() != ScheduleIterator2.hasNext())
                return false;
            while (ScheduleIterator1.hasNext()) {
                if (!ScheduleIterator2.hasNext())
                    return false;

                Object oneSchedule = ScheduleIterator1.next();
                Object twoSchedule = ScheduleIterator2.next();

                Schedule qwe = (Schedule) oneSchedule;
                Schedule asd = (Schedule) twoSchedule;

                if (!compareSchedules(qwe, asd)) {
                    System.out.println("compareSchedule Failed");
                    return false;
                }

                Collection<ClassDetails> wer = qwe.getClasses();
                Collection<ClassDetails> sdf = asd.getClasses();

                Iterator<ClassDetails> e1 = wer.iterator();
                Iterator<ClassDetails> e2 = sdf.iterator();

                while (e1.hasNext()) {
                    if (!e2.hasNext())
                        return false;

                    Object po = e1.next();
                    Object pe = e2.next();

                    Collection<ClassDetails> w = (Collection<ClassDetails>) po;
                    Collection<ClassDetails> q = (Collection<ClassDetails>) pe;

                    Iterator<ClassDetails> u1 = w.iterator();
                    Iterator<ClassDetails> u2 = q.iterator();

                    while (u1.hasNext()) {
                        if (!u2.hasNext())
                            return false;

                        ClassDetails classDetails1 = u1.next();
                        ClassDetails classDetails2 = u2.next();

                        if (!compareClassDetails(classDetails1, classDetails2)) {
                            System.out.println("compareClassDetails Failed");
                            return false;
                        }
                    }
                }
            }
        } else if (two != null)
            return false;
        return true;
    }

    private boolean compareClassDetails(ClassDetails oneClass, ClassDetails twoClass) {
        //Strings
        if (oneClass.getBldg_room() != null) {
            if (twoClass.getBldg_room() == null)
                return false;
            if (oneClass.getBldg_room().compareTo(twoClass.getBldg_room()) != 0)
                return false;
        } else if (twoClass.getBldg_room() != null)
            return false;

        if (oneClass.getTerm() != null) {
            if (twoClass.getTerm() == null)
                return false;
            if (oneClass.getTerm().compareTo(twoClass.getTerm()) != 0)
                return false;
        } else if (twoClass.getTerm() != null)
            return false;

        if (oneClass.getCampus() != null) {
            if (twoClass.getCampus() == null)
                return false;
            if (oneClass.getCampus().compareTo(twoClass.getCampus()) != 0)
                return false;
        } else if (twoClass.getCampus() != null)
            return false;

        if (oneClass.getClassNbr() != null) {
            if (twoClass.getClassNbr() == null)
                return false;
            if (oneClass.getClassNbr().compareTo(twoClass.getClassNbr()) != 0)
                return false;
        } else if (twoClass.getClassNbr() != null)
            return false;

        //Time - 1 string, 4 ints
        if (oneClass.getTime() != null) {
            if (twoClass.getTime() == null)
                return false;
            if (oneClass.getTime().days != null) {
                if (twoClass.getTime().days == null)
                    return false;
                if (oneClass.getTime().days.compareTo(twoClass.getTime().days) != 0)
                    return false;
            } else if (twoClass.getTime().days != null)
                return false;
            if (oneClass.getTime().frHr != twoClass.getTime().frHr)
                return false;
            if (oneClass.getTime().frMn != twoClass.getTime().frMn)
                return false;
            if (oneClass.getTime().toHr != twoClass.getTime().toHr)
                return false;
            if (oneClass.getTime().toMn != twoClass.getTime().toMn)
                return false;
        } else if (twoClass.getTime() != null)
            return false;

        //Course(DatabaseStub) - 3 strings, 1 int
        if (oneClass.getCourse() != null) {
            if (twoClass.getCourse() == null)
                return false;
            if (oneClass.getCourse().catlgNbr != null) {
                if (twoClass.getCourse().catlgNbr == null)
                    return false;
                if (oneClass.getCourse().catlgNbr.compareTo(twoClass.getCourse().catlgNbr) != 0)
                    return false;
            } else if (twoClass.getCourse().catlgNbr != null)
                return false;
            if (oneClass.getCourse().subject != null) {
                if (twoClass.getCourse().subject == null)
                    return false;
                if (oneClass.getCourse().subject.compareTo(twoClass.getCourse().subject) != 0)
                    return false;
            } else if (twoClass.getCourse().subject != null)
                return false;
            if (oneClass.getCourse().description != null) {
                if (twoClass.getCourse().description == null)
                    return false;
                if (oneClass.getCourse().description.compareTo(twoClass.getCourse().description) != 0)
                    return false;
            } else if (twoClass.getCourse().description != null)
                return false;
            if (oneClass.getCourse().units != twoClass.getCourse().units)
                return false;
        } else if (twoClass.getCourse() != null)
            return false;

        //Professor - Need super of FacultyStaff
        if (oneClass.getInstructor() != null) {
            if (twoClass.getInstructor() == null)
                return false;
            if (oneClass.getInstructor().getFirstName() != null) {
                if (twoClass.getInstructor().getFirstName() == null)
                    return false;
                if (oneClass.getInstructor().getFirstName().compareTo(oneClass.getInstructor().getFirstName()) != 0)
                    return false;
            } else if (twoClass.getInstructor().getFirstName() != null)
                return false;
            if (oneClass.getInstructor().getLastName() != null) {
                if (twoClass.getInstructor().getLastName() == null)
                    return false;
                if (oneClass.getInstructor().getLastName().compareTo(oneClass.getInstructor().getLastName()) != 0)
                    return false;
            } else if (twoClass.getInstructor().getLastName() != null)
                return false;
            if (oneClass.getInstructor().getSSN() != null) {
                if (twoClass.getInstructor().getSSN() == null)
                    return false;
                if (oneClass.getInstructor().getSSN().compareTo(oneClass.getInstructor().getSSN()) != 0)
                    return false;
            } else if (twoClass.getInstructor().getSSN() != null)
                return false;
        } else if (twoClass.getInstructor() != null)
            return false;
        return true;
    }

    private boolean compareSchedules(Schedule s1, Schedule s2) {
        //Compare ID
        if (s1.getId() != null && s2.getId() != null
                && s1.getId().compareTo(s2.getId()) != 0)
            return false;
        else if (!(s2.getId() == null))
            return false;

        //Compare PantherID
        if (s1.getId() != null && s2.getId() != null
                && s1.getPantherID().compareTo(s2.getPantherID()) != 0)
            return false;
        else if (!(s2.getPantherID() == null))
            return false;
        return true;
    }
    
    @Test
	public void SM_001SMC_Unit_TC008()
	{
		
		
		String term = "Spring 2007";
		Collection<String> courses = new ArrayList<String>();
		String campus = "University";
		String SPDays = "1010000";
		
		ScheduleMakerController test = new ScheduleMakerController();
		
		assertTrue("An empty schedule is returned when the user did not specify any courses in their schedule options", test.createSchedule(term, courses, campus, SPDays).isEmpty());
		
	}
	
	@Test
	public void SM_001SMC_Unit_TC009()
	{
		//Test schedule object
        DatabaseStub course = new DatabaseStub();
       
        
        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);
        
        Time time = new Time(8,00,9,15,"1010000");
        

        ClassDetails classDetails = new ClassDetails();
        classDetails.setDatabaseStub(course);
        classDetails.setTime(time);
        classDetails.setCampus("University");
        classDetails.setTerm("Spring 2007");
        classDetails.setClassNbr("1010");

        Collection<ClassDetails> collectionOfClassDetails = new ArrayList<ClassDetails>();
        collectionOfClassDetails.add(classDetails);

        Collection<Collection<ClassDetails>> c = new ArrayList<Collection<ClassDetails>>();
        c.add(collectionOfClassDetails);

        ArrayList list = (ArrayList) c;
        Schedule schedule = new Schedule(list);

        Collection control = new ArrayList<Schedule>();
        control.add(schedule);

        //Client
        //Term (Spring 2007)
        String term = "Spring 2007";

        //Campus (University, Biscane)
        String campus = "University";
        String SPDays = "1010000";
        
        Collection<String> courses = new ArrayList<String>();
        courses.add("HIS1010");

        
		
		
		ScheduleMakerController driver = new ScheduleMakerController();
		
		Collection toTest = driver.createSchedule(term, courses, campus, SPDays);
		
		assertTrue("Only history class on university campus should be returned.", compareCollectionofSchedule(control,toTest));
		
	}
	
	@Test
	public void SM_001SMC_Unit_TC010()
	{
		//Test schedule object
        DatabaseStub course = new DatabaseStub();
       
        
        course.setCatlgNbr("2250");
        course.setSubject("COP");
        course.setUnits(0);
        
        Time time = new Time(15,30,16,45,"1010100");
        

        ClassDetails classDetails = new ClassDetails();
        classDetails.setDatabaseStub(course);
        classDetails.setTime(time);
        classDetails.setCampus("Biscayne");
        classDetails.setTerm("Spring 2007");
        classDetails.setClassNbr("2250");

        Collection<ClassDetails> collectionOfClassDetails = new ArrayList<ClassDetails>();
        collectionOfClassDetails.add(classDetails);

        Collection<Collection<ClassDetails>> c = new ArrayList<Collection<ClassDetails>>();
        c.add(collectionOfClassDetails);

        ArrayList list = (ArrayList) c;
        Schedule schedule = new Schedule(list);

        Collection control = new ArrayList<Schedule>();
        control.add(schedule);

        //Client
        //Term (Spring 2007)
        String term = "Spring 2007";

        //Campus (University, Biscane)
        String campus = "Biscayne";
        String SPDays = "1010100";
        
        Collection<String> courses = new ArrayList<String>();
        courses.add("COP2250");
        
		
		
		ScheduleMakerController driver = new ScheduleMakerController();
		
		Collection toTest = driver.createSchedule(term, courses, campus, SPDays);
		
		assertTrue("Only COP class on Biscayne campus should be returned.", compareCollectionofSchedule(control,toTest));
		
	}
	
	
	
	@Test
	public void SM_001SMC_Unit_TC011()
	{
		//Test schedule object
        DatabaseStub course = new DatabaseStub();
       
        
        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);
        
        Time time = new Time(8,00,9,15,"1010000");
        

        ClassDetails classDetails = new ClassDetails();
        classDetails.setDatabaseStub(course);
        classDetails.setTime(time);
        classDetails.setCampus("University");
        classDetails.setTerm("Spring 2007");
        classDetails.setClassNbr("1010");

        Collection<ClassDetails> collectionOfClassDetails = new ArrayList<ClassDetails>();
        collectionOfClassDetails.add(classDetails);

        Collection<Collection<ClassDetails>> c = new ArrayList<Collection<ClassDetails>>();
        c.add(collectionOfClassDetails);

        ArrayList list = (ArrayList) c;
        Schedule schedule = new Schedule(list);

        Collection control = new ArrayList<Schedule>();
        control.add(schedule);

        //Client
        //Term (Spring 2007)
        String term = "Spring 2007";

        //Campus (University, Biscane)
        String campus = "All";
        String SPDays = "1010000";
        
        Collection<String> courses = new ArrayList<String>();
        courses.add("HIS1010");
        
		
		
		ScheduleMakerController driver = new ScheduleMakerController();
		
		Collection toTest = driver.createSchedule(term, courses, campus, SPDays);
		
		assertTrue("Only history class on Monday and Wednesday should be returned.", compareCollectionofSchedule(control,toTest));
		
	}
	
	@Test
	public void SM_001SMC_Unit_TC012()
	{
		//Test schedule object
        DatabaseStub course = new DatabaseStub();
       
        
        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);
        
        Time time = new Time(18,25,19,40,"0101000");
        

        ClassDetails classDetails = new ClassDetails();
        classDetails.setDatabaseStub(course);
        classDetails.setTime(time);
        classDetails.setCampus("Biscayne");
        classDetails.setTerm("Spring 2007");
        classDetails.setClassNbr("1010");

        Collection<ClassDetails> collectionOfClassDetails = new ArrayList<ClassDetails>();
        collectionOfClassDetails.add(classDetails);

        Collection<Collection<ClassDetails>> c = new ArrayList<Collection<ClassDetails>>();
        c.add(collectionOfClassDetails);

        ArrayList list = (ArrayList) c;
        Schedule schedule = new Schedule(list);

        Collection control = new ArrayList<Schedule>();
        control.add(schedule);

        //Client
        //Term (Spring 2007)
        String term = "Spring 2007";

        //Campus (University, Biscane)
        String campus = "All";
        String SPDays = "1010000";
        
        Collection<String> courses = new ArrayList<String>();
        courses.add("HIS1010");
        
		
		
		ScheduleMakerController driver = new ScheduleMakerController();
		
		Collection toTest = driver.createSchedule(term, courses, campus, SPDays);
		
		assertFalse("Only history class on Monday and Wednesday should be returned, as opposed to history class on Tuesday, Thursday", compareCollectionofSchedule(control,toTest));
		
	}
	
	@Test
	public void SM_001SMC_Unit_TC013()
	{
		//Test schedule object
        DatabaseStub course = new DatabaseStub();
       
        
        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);
        
        Time time = new Time(8,00,9,15,"1010000");
        

        ClassDetails classDetails = new ClassDetails();
        classDetails.setDatabaseStub(course);
        classDetails.setTime(time);
        classDetails.setCampus("University");
        classDetails.setTerm("Spring 2007");
        classDetails.setClassNbr("1010");

        Collection<ClassDetails> collectionOfClassDetails = new ArrayList<ClassDetails>();
        collectionOfClassDetails.add(classDetails);

        Collection<Collection<ClassDetails>> c = new ArrayList<Collection<ClassDetails>>();
        c.add(collectionOfClassDetails);

        ArrayList list = (ArrayList) c;
        Schedule schedule = new Schedule(list);

        Collection control = new ArrayList<Schedule>();
        control.add(schedule);

        //Client
        //Term (Spring 2007)
        String term = "Spring 2007";

        //Campus (University, Biscane)
        String campus = "University";
        String SPDays = "1010000";
        
        Collection<String> courses = new ArrayList<String>();
        courses.add("HIS1010");
        
		
		
		ScheduleMakerController driver = new ScheduleMakerController();
		
		Collection toTest = driver.createSchedule(term, courses, campus, SPDays);
		
		assertTrue("Only history class on Spring 2007 should be returned.", compareCollectionofSchedule(control,toTest));
		
	}
	
	@Test
	public void SM_001SMC_Unit_TC014()
	{
		//Test schedule object
        DatabaseStub course = new DatabaseStub();
       
        
        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);
        
        Time time = new Time(8,00,9,15,"1010000");
        

        ClassDetails classDetails = new ClassDetails();
        classDetails.setDatabaseStub(course);
        classDetails.setTime(time);
        classDetails.setCampus("University");
        classDetails.setTerm("Fall 2007");
        classDetails.setClassNbr("1010");

        Collection<ClassDetails> collectionOfClassDetails = new ArrayList<ClassDetails>();
        collectionOfClassDetails.add(classDetails);

        Collection<Collection<ClassDetails>> c = new ArrayList<Collection<ClassDetails>>();
        c.add(collectionOfClassDetails);

        ArrayList list = (ArrayList) c;
        Schedule schedule = new Schedule(list);

        Collection control = new ArrayList<Schedule>();
        control.add(schedule);

        //Client
        //Term (Spring 2007)
        String term = "Spring 2007";

        //Campus (University, Biscane)
        String campus = "University";
        String SPDays = "1010000";
        
        Collection<String> courses = new ArrayList<String>();
        courses.add("HIS1010");
        
		
		
		ScheduleMakerController driver = new ScheduleMakerController();
		
		Collection toTest = driver.createSchedule(term, courses, campus, SPDays);
		
		assertFalse("Only history class on Spring 2007 should be returned, as opposed to History class on Fall 2007", compareCollectionofSchedule(control,toTest));
		
	}
    
    
    
}
