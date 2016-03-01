package ApplicationLogic;

import Storage.DatabaseStub;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by Omar on 2/29/2016 at 7:25 PM.
 * <p/>
 * This is the UnitTest Class for schedule maker
 */
public class UnitTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void SM_001CD_Unit_TC001() {
        DatabaseStub course1 = new DatabaseStub("History", "1000");
        Professor teacher1 = new Professor("123456789", "John", "Doe");
        Time time1 = new Time(6, 30, 7, 30, "1010100");

        DatabaseStub course2 = new DatabaseStub("Psychology", "2000");
        Professor teacher2 = new Professor("987654321", "Mary", "Smith");
        Time time2 = new Time(6, 30, 7, 30, "1010100");

        ClassDetails class1 = new ClassDetails(course1, "1000", teacher1, "101", "FIU", "Fall", time1);
        ClassDetails class2 = new ClassDetails(course2, "2000", teacher2, "102", "FIU", "Fall", time2);

        assertTrue("hasConflict should return true for two classes starting at exact same time", class1.hasConflict(class2));
    }

    @Test
    public void SM_001CD_Unit_TC002() {
        DatabaseStub course1 = new DatabaseStub("History", "1000");
        Professor teacher1 = new Professor("123456789", "John", "Doe");
        Time time1 = new Time(6, 30, 8, 0, "1010100");

        DatabaseStub course2 = new DatabaseStub("Psychology", "2000");
        Professor teacher2 = new Professor("987654321", "Mary", "Smith");
        Time time2 = new Time(7, 0, 9, 0, "1010100");

        ClassDetails class1 = new ClassDetails(course1, "1000", teacher1, "101", "FIU", "Fall", time1);
        ClassDetails class2 = new ClassDetails(course2, "2000", teacher2, "102", "FIU", "Fall", time2);

        assertTrue("hasConflict should return true for when class1 end time overlaps with class2 beginning time", class1.hasConflict(class2));
    }

    @Test
    public void SM_001CD_Unit_TC003() {
        DatabaseStub course1 = new DatabaseStub("History", "1000");
        Professor teacher1 = new Professor("123456789", "John", "Doe");
        Time time1 = new Time(7, 0, 9, 0, "1010100");

        DatabaseStub course2 = new DatabaseStub("Psychology", "2000");
        Professor teacher2 = new Professor("987654321", "Mary", "Smith");
        Time time2 = new Time(6, 30, 8, 0, "1010100");

        ClassDetails class1 = new ClassDetails(course1, "1000", teacher1, "101", "FIU", "Fall", time1);
        ClassDetails class2 = new ClassDetails(course2, "2000", teacher2, "102", "FIU", "Fall", time2);

        assertTrue("hasConflict should return true for when class2 end time overlaps with class1 beginning time", class1.hasConflict(class2));
    }

    @Test
    public void SM_001CD_Unit_TC004() {
        DatabaseStub course1 = new DatabaseStub("History", "1000");
        Professor teacher1 = new Professor("123456789", "John", "Doe");
        Time time1 = new Time(7, 0, 9, 0, "1010100");

        DatabaseStub course2 = new DatabaseStub("Psychology", "2000");
        Professor teacher2 = new Professor("987654321", "Mary", "Smith");
        Time time2 = new Time(10, 0, 11, 0, "1010100");

        ClassDetails class1 = new ClassDetails(course1, "1000", teacher1, "101", "FIU", "Spring 2007", time1);
        ClassDetails class2 = new ClassDetails(course2, "2000", teacher2, "102", "FIU", "Spring 2007", time2);

        assertFalse("hasConflict should return false for two unconflicting classes ", class1.hasConflict(class2));
    }

    @Test
    public void SM_001CD_Unit_TC005() {
        DatabaseStub course1 = new DatabaseStub("History", "1000");
        Professor teacher1 = new Professor("123456789", "John", "Doe");
        Time time1 = new Time(7, 0, 9, 0, "1010100");

        ClassDetails class1 = new ClassDetails(course1, "1000", teacher1, "101", "FIU", "Fall", time1);

        assertTrue("isAtTime returns true for 8 which is within the range of 7-9", class1.isAtTime(8));
    }

    @Test
    public void SM_001CD_Unit_TC006() {
        DatabaseStub course1 = new DatabaseStub("History", "1000");
        Professor teacher1 = new Professor("123456789", "John", "Doe");
        Time time1 = new Time(7, 0, 9, 0, "1010100");

        ClassDetails class1 = new ClassDetails(course1, "1000", teacher1, "101", "FIU", "Fall", time1);

        assertFalse("isAtTime returns true for 8 which is within the range of 7-9", class1.isAtTime(10));
    }

    @Test
    public void SM_001CD_Unit_TC007() {
        DatabaseStub course1 = new DatabaseStub("History", "1000");
        Professor teacher1 = new Professor("123456789", "John", "Doe");
        Time time1 = new Time(7, 0, 9, 0, "1010100");

        ClassDetails class1 = new ClassDetails(course1, "1000", teacher1, "101", "FIU", "Fall", time1);

        assertTrue("isAtDay returns true for 2 entered since class1 takes place on the 3rd day of the week (Wednesday)", class1.isAtDay(2));
    }

    @Test
    public void SM_001CD_Unit_TC008() {
        DatabaseStub course1 = new DatabaseStub("History", "1000");
        Professor teacher1 = new Professor("123456789", "John", "Doe");
        Time time1 = new Time(7, 0, 9, 0, "1010100");

        ClassDetails class1 = new ClassDetails(course1, "1000", teacher1, "101", "FIU", "Fall", time1);

        assertFalse("isAtDay returns true for 2 entered since class1 takes place on the 3rd day of the week (Wednesday)", class1.isAtDay(3));
    }

    @Test
    public void SM_001CD_Unit_TC009() {
        DatabaseStub course1 = new DatabaseStub("History", "1000");
        Professor teacher1 = new Professor("123456789", "John", "Doe");
        Time time1 = new Time(7, 0, 9, 0, "1010100");

        ClassDetails class1 = new ClassDetails(course1, "1000", teacher1, "101", "FIU", "Fall", time1);

        System.out.print(class1.toString());
        assertEquals("Should print everything when campus and time are non-null",
                "History1000" + "\n" + "1000" + "\n" +
                        "7:0-9:0" + "\n"
                        + "FIU" + "\n", class1.toString());


    }

    @Test
    public void SM_001CD_Unit_TC010() {
        DatabaseStub course1 = new DatabaseStub("History", "1000");
        Professor teacher1 = new Professor("123456789", "John", "Doe");
        Time time1 = null;

        ClassDetails class1 = new ClassDetails(course1, "1000", teacher1, "101", "FIU", "Fall", time1);

        assertEquals("Should omit time details since time is null",
                "History1000" + "\n" + "1000" + "\n"
                        + "FIU" + "\n", class1.toString());
    }

    @Test
    public void SM_001CD_Unit_TC011() {
        DatabaseStub course1 = new DatabaseStub("History", "1000");
        Professor teacher1 = new Professor("123456789", "John", "Doe");
        Time time1 = new Time(7, 0, 9, 0, "1010100");

        ClassDetails class1 = new ClassDetails(course1, "1000", teacher1, "101", null, "Fall", time1);

        assertEquals("Should omit campus details since campus is null",
                "History1000" + "\n" + "1000" + "\n" +
                        "7:0-9:0" + "\n", class1.toString());
    }

    @Test
    public void SM_002SMC_Unit_TC001() {


        ScheduleOptions sched = new ScheduleOptions(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

        ScheduleMakerController test = new ScheduleMakerController();

        assertTrue("An empty schedule is returned when the user did not specify any courses in their schedule options", test.createSchedule(sched).isEmpty());

    }

    @Test
    public void SM_002SMC_Unit_TC002() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();


        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);

        Time time = new Time(8, 0, 9, 15, "1010000");


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


        ScheduleOptions sched = new ScheduleOptions(term, "HIS1010", "", "", "", "", "", campus, "1", "0", "1", "0", "0", "0", "0", 1);
        ScheduleMakerController driver = new ScheduleMakerController();

        Collection toTest = driver.createSchedule(sched);

        assertTrue("Only history class on university campus should be returned.", compareCollectionofSchedule(control, toTest));

    }

    @Test
    public void SM_002SMC_Unit_TC003() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();


        course.setCatlgNbr("2250");
        course.setSubject("COP");
        course.setUnits(0);

        Time time = new Time(15, 30, 16, 45, "1010100");


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


        ScheduleOptions sched = new ScheduleOptions(term, "COP2250", "", "", "", "", "", campus, "1", "0", "1", "0", "1", "0", "0", 1);
        ScheduleMakerController driver = new ScheduleMakerController();

        Collection toTest = driver.createSchedule(sched);

        assertTrue("Only COP class on Biscayne campus should be returned.", compareCollectionofSchedule(control, toTest));

    }


    @Test
    public void SM_002SMC_Unit_TC004() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();


        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);

        Time time = new Time(8, 0, 9, 15, "1010000");


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


        ScheduleOptions sched = new ScheduleOptions(term, "HIS1010", "", "", "", "", "", campus, "1", "0", "1", "0", "0", "0", "0", 1);
        ScheduleMakerController driver = new ScheduleMakerController();

        Collection toTest = driver.createSchedule(sched);

        assertTrue("Only history class on Monday and Wednesday should be returned.", compareCollectionofSchedule(control, toTest));

    }

    @Test
    public void SM_002SMC_Unit_TC005() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();


        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);

        Time time = new Time(18, 25, 19, 40, "0101000");


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


        ScheduleOptions sched = new ScheduleOptions(term, "HIS1010", "", "", "", "", "", campus, "1", "0", "1", "0", "0", "0", "0", 1);
        ScheduleMakerController driver = new ScheduleMakerController();

        Collection toTest = driver.createSchedule(sched);

        assertFalse("Only history class on Monday and Wednesday should be returned, as opposed to history class on Tuesday, Thursday", compareCollectionofSchedule(control, toTest));

    }

    @Test
    public void SM_002SMC_Unit_TC006() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();


        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);

        Time time = new Time(8, 0, 9, 15, "1010000");


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


        ScheduleOptions sched = new ScheduleOptions(term, "HIS1010", "", "", "", "", "", campus, "1", "0", "1", "0", "0", "0", "0", 1);
        ScheduleMakerController driver = new ScheduleMakerController();

        Collection toTest = driver.createSchedule(sched);

        assertTrue("Only history class on Spring 2007 should be returned.", compareCollectionofSchedule(control, toTest));

    }

    @Test
    public void SM_002SMC_Unit_TC007() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();


        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);

        Time time = new Time(8, 0, 9, 15, "1010000");


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


        ScheduleOptions sched = new ScheduleOptions(term, "HIS1010", "", "", "", "", "", campus, "1", "0", "1", "0", "0", "0", "0", 1);
        ScheduleMakerController driver = new ScheduleMakerController();

        Collection toTest = driver.createSchedule(sched);

        assertFalse("Only history class on Spring 2007 should be returned, as opposed to History class on Fall 2007", compareCollectionofSchedule(control, toTest));

    }

    @Test
    public void SM_002SMC_Unit_TC008() {


        String term = "Spring 2007";
        Collection<String> courses = new ArrayList<String>();
        String campus = "University";
        String SPDays = "1010000";

        ScheduleMakerController test = new ScheduleMakerController();

        assertTrue("An empty schedule is returned when the user did not specify any courses in their schedule options", test.createSchedule(term, courses, campus, SPDays).isEmpty());

    }

    @Test
    public void SM_002SMC_Unit_TC009() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();


        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);

        Time time = new Time(8, 0, 9, 15, "1010000");


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

        assertTrue("Only history class on university campus should be returned.", compareCollectionofSchedule(control, toTest));

    }

    @Test
    public void SM_002SMC_Unit_TC010() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();


        course.setCatlgNbr("2250");
        course.setSubject("COP");
        course.setUnits(0);

        Time time = new Time(15, 30, 16, 45, "1010100");


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

        assertTrue("Only COP class on Biscayne campus should be returned.", compareCollectionofSchedule(control, toTest));

    }


    @Test
    public void SM_002SMC_Unit_TC011() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();


        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);

        Time time = new Time(8, 0, 9, 15, "1010000");


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

        assertTrue("Only history class on Monday and Wednesday should be returned.", compareCollectionofSchedule(control, toTest));

    }

    @Test
    public void SM_002SMC_Unit_TC012() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();


        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);

        Time time = new Time(18, 25, 19, 40, "0101000");


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

        assertFalse("Only history class on Monday and Wednesday should be returned, as opposed to history class on Tuesday, Thursday", compareCollectionofSchedule(control, toTest));

    }

    @Test
    public void SM_002SMC_Unit_TC013() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();


        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);

        Time time = new Time(8, 0, 9, 15, "1010000");


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

        assertTrue("Only history class on Spring 2007 should be returned.", compareCollectionofSchedule(control, toTest));

    }

    @Test
    public void SM_002SMC_Unit_TC014() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();


        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);

        Time time = new Time(8, 0, 9, 15, "1010000");


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

        assertFalse("Only history class on Spring 2007 should be returned, as opposed to History class on Fall 2007", compareCollectionofSchedule(control, toTest));

    }

    @Test
    public void SM_001_SMC_Unit_TC_015() {
        fail("Not yet implemented");
    }

    @Test
    public void SM_001_SMC_Unit_TC_016() {
        fail("Not yet implemented");
    }

    @Test
    public void SM_001_SMC_Unit_TC_017() {
        fail("Not yet implemented");
    }

    @Test
    public void SM_001_SMC_Unit_TC_018() {
        fail("Not yet implemented");
    }

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

}