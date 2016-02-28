package ApplicationLogic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import Storage.DatabaseStub;
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

    //Testing method login
    //Sunny-Day
    @Test
    public void testLogin1() {
        //User name and password exists in database
        assertEquals("Logged In?", true, fc.login("1412412", "abc123"));

    }

    @Test
    public void testLogin2() {
        //User name and password exists in database
        assertEquals("Logged In?", true, fc.login("2354235", "abc234"));

    }

    @Test
    public void testLogin3() {
        //User name and password exists in database
        assertEquals("Logged In?", true, fc.login("2234523", "abc345"));

    }

    //Rainy-Day
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


    //Testing method createSchedule
    //Sunny-Day
    @Test
    public void testCreateSchedule1() {
        Collection<String> courses = new ArrayList<String>();
        courses.add("HIS1010");

        courses.add("COP2210");
        courses.add("COP3145");

        courses.add("COP4338");

        // System.out.println(fc.createSchedule("Spring 2007", courses, "All", "1111111"));

        assertEquals("Collection:", true,
                compareSchedule(new Schedule(courses), new Schedule(courses)));
    }

    @Test
    public void testCreateSchedule2() {
        fail("Need to Implement");
    }

    @Test
    public void testCreateSchedule3() {
        fail("Need to Implement");
    }

    //Rainy-Day
    @Test
    public void testCreateSchedule4() {
        fail("Need to Implement");
    }

    @Test
    public void testCreateSchedule5() {
        fail("Need to Implement");
    }

    @Test
    public void testCreateSchedule6() {
        fail("Need to Implement");
    }


    //Testing method buildSchedules
    //Sunny-Day
    @Test
    public void testBuildSchedulesPage1() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();
        course.setCatlgNbr("");
        course.setDescription("");
        course.setSubject("");
        course.setUnits(0);

        Professor teacher = new Professor();
        teacher.setFirstName("");
        teacher.setLastName("");
        teacher.setSSN("");

        Time time = new Time();
        time.setDays("");
        time.setFrHr(0);
        time.setFrMn(0);
        time.setToHr(0);
        time.setToMn(0);

        ClassDetails classDetails = new ClassDetails();
        classDetails.setDatabaseStub(course);
        classDetails.setProfessor(teacher);
        classDetails.setTime(time);
        classDetails.setCampus("");
        classDetails.setTerm("");
        classDetails.setBldg_room("");
        classDetails.setClassNbr("");

        Collection<ClassDetails> collectionOfClassDetails = null;
        collectionOfClassDetails.add(classDetails);

        Schedule schedule = new Schedule();
        schedule.setClasses(collectionOfClassDetails);
        schedule.setPantherID("");
        schedule.setId("");

        Collection<Schedule> collectionOfSchedules = null;
        collectionOfSchedules.add(schedule);

        int pg = 1;

        fc.buildSchedulesPage(collectionOfSchedules, pg);

        //Client call schedule object - incomplete
        Schedule schedule1 = new Schedule();

        Collection<Schedule> Client = null;
        Client.add(schedule1);

        assertEquals("HTML String:", true,
                fc.buildSchedulesPage(collectionOfSchedules, pg).compareTo());
    }

    @Test
    public void testBuildSchedulesPage2() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();
        course.setCatlgNbr("");
        course.setDescription("");
        course.setSubject("");
        course.setUnits(0);

        Professor teacher = new Professor();
        teacher.setFirstName("");
        teacher.setLastName("");
        teacher.setSSN("");

        Time time = new Time();
        time.setDays("");
        time.setFrHr(0);
        time.setFrMn(0);
        time.setToHr(0);
        time.setToMn(0);

        ClassDetails classDetails = new ClassDetails();
        classDetails.setDatabaseStub(course);
        classDetails.setProfessor(teacher);
        classDetails.setTime(time);
        classDetails.setCampus("");
        classDetails.setTerm("");
        classDetails.setBldg_room("");
        classDetails.setClassNbr("");

        Collection<ClassDetails> collectionOfClassDetails = null;
        collectionOfClassDetails.add(classDetails);

        Schedule schedule = new Schedule();
        schedule.setClasses(collectionOfClassDetails);
        schedule.setPantherID("");
        schedule.setId("");

        Collection<Schedule> Test = null;
        Test.add(schedule);

        //Client call schedule object - incomplete
        Schedule schedule1 = new Schedule();

        Collection<Schedule> Client = null;
        Client.add(schedule1);

        assertEquals("Collection:", true,
                compareCollectionofSchedule(Test, Client));
    }

    @Test
    public void testBuildSchedulesPage3() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();
        course.setCatlgNbr("");
        course.setDescription("");
        course.setSubject("");
        course.setUnits(0);

        Professor teacher = new Professor();
        teacher.setFirstName("");
        teacher.setLastName("");
        teacher.setSSN("");

        Time time = new Time();
        time.setDays("");
        time.setFrHr(0);
        time.setFrMn(0);
        time.setToHr(0);
        time.setToMn(0);

        ClassDetails classDetails = new ClassDetails();
        classDetails.setDatabaseStub(course);
        classDetails.setProfessor(teacher);
        classDetails.setTime(time);
        classDetails.setCampus("");
        classDetails.setTerm("");
        classDetails.setBldg_room("");
        classDetails.setClassNbr("");

        Collection<ClassDetails> collectionOfClassDetails = null;
        collectionOfClassDetails.add(classDetails);

        Schedule schedule = new Schedule();
        schedule.setClasses(collectionOfClassDetails);
        schedule.setPantherID("");
        schedule.setId("");

        Collection<Schedule> Test = null;
        Test.add(schedule);

        //Client call schedule object - incomplete
        Schedule schedule1 = new Schedule();

        Collection<Schedule> Client = null;
        Client.add(schedule1);

        assertEquals("Collection:", true,
                compareCollectionofSchedule(Test, Client));
    }

    //Rainy-Day
    @Test
    public void testBuildSchedulesPage4() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();
        course.setCatlgNbr("");
        course.setDescription("");
        course.setSubject("");
        course.setUnits(0);

        Professor teacher = new Professor();
        teacher.setFirstName("");
        teacher.setLastName("");
        teacher.setSSN("");

        Time time = new Time();
        time.setDays("");
        time.setFrHr(0);
        time.setFrMn(0);
        time.setToHr(0);
        time.setToMn(0);

        ClassDetails classDetails = new ClassDetails();
        classDetails.setDatabaseStub(course);
        classDetails.setProfessor(teacher);
        classDetails.setTime(time);
        classDetails.setCampus("");
        classDetails.setTerm("");
        classDetails.setBldg_room("");
        classDetails.setClassNbr("");

        Collection<ClassDetails> collectionOfClassDetails = null;
        collectionOfClassDetails.add(classDetails);

        Schedule schedule = new Schedule();
        schedule.setClasses(collectionOfClassDetails);
        schedule.setPantherID("");
        schedule.setId("");

        Collection<Schedule> Test = null;
        Test.add(schedule);

        //Client call schedule object - incomplete
        Schedule schedule1 = new Schedule();

        Collection<Schedule> Client = null;
        Client.add(schedule1);

        assertEquals("Collection:", true,
                compareCollectionofSchedule(Test, Client));
    }

    @Test
    public void testBuildSchedulesPage5() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();
        course.setCatlgNbr("");
        course.setDescription("");
        course.setSubject("");
        course.setUnits(0);

        Professor teacher = new Professor();
        teacher.setFirstName("");
        teacher.setLastName("");
        teacher.setSSN("");

        Time time = new Time();
        time.setDays("");
        time.setFrHr(0);
        time.setFrMn(0);
        time.setToHr(0);
        time.setToMn(0);

        ClassDetails classDetails = new ClassDetails();
        classDetails.setDatabaseStub(course);
        classDetails.setProfessor(teacher);
        classDetails.setTime(time);
        classDetails.setCampus("");
        classDetails.setTerm("");
        classDetails.setBldg_room("");
        classDetails.setClassNbr("");

        Collection<ClassDetails> collectionOfClassDetails = null;
        collectionOfClassDetails.add(classDetails);

        Schedule schedule = new Schedule();
        schedule.setClasses(collectionOfClassDetails);
        schedule.setPantherID("");
        schedule.setId("");

        Collection<Schedule> Test = null;
        Test.add(schedule);

        //Client call schedule object - incomplete
        Schedule schedule1 = new Schedule();

        Collection<Schedule> Client = null;
        Client.add(schedule1);

        assertEquals("Collection:", true,
                compareCollectionofSchedule(Test, Client));
    }

    @Test
    public void testBuildSchedulesPage6() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();
        course.setCatlgNbr("");
        course.setDescription("");
        course.setSubject("");
        course.setUnits(0);

        Professor teacher = new Professor();
        teacher.setFirstName("");
        teacher.setLastName("");
        teacher.setSSN("");

        Time time = new Time();
        time.setDays("");
        time.setFrHr(0);
        time.setFrMn(0);
        time.setToHr(0);
        time.setToMn(0);

        ClassDetails classDetails = new ClassDetails();
        classDetails.setDatabaseStub(course);
        classDetails.setProfessor(teacher);
        classDetails.setTime(time);
        classDetails.setCampus("");
        classDetails.setTerm("");
        classDetails.setBldg_room("");
        classDetails.setClassNbr("");

        Collection<ClassDetails> collectionOfClassDetails = null;
        collectionOfClassDetails.add(classDetails);

        Schedule schedule = new Schedule();
        schedule.setClasses(collectionOfClassDetails);
        schedule.setPantherID("");
        schedule.setId("");

        Collection<Schedule> Test = null;
        Test.add(schedule);

        //Client call schedule object - incomplete
        Schedule schedule1 = new Schedule();

        Collection<Schedule> Client = null;
        Client.add(schedule1);

        assertEquals("Collection:", true,
                compareCollectionofSchedule(Test, Client));
    }

    //Comaring
    private boolean compareCollectionofSchedule(Collection<Schedule> one, Collection<Schedule> Schedule two) {
        if (one.getId() != null && one.getId().compareTo(two.getId()) != 0)
            return false;
        if (one.getPantherID() != null && one.getPantherID().compareTo(two.getPantherID()) != 0)
            return false;

        if (one.getClasses() == null) {
            if (two.getClasses() != null)
                return false;

            //Comparing class details collection
            //Compare all possible Classes in one.schedule with another
        } else {
            if (two.getClasses() == null)
                return false;
            Iterator<ClassDetails> itr = one.getClasses().iterator();
            Iterator<ClassDetails> itr2 = one.getClasses().iterator();
            while (itr.hasNext()) {

                ClassDetails oneClass = itr.next();
                ClassDetails twoClass = itr2.next();

                //Strings
                if (oneClass.getDays() != null)
                    if (twoClass.getDays() == null)
                        return false;
                if (oneClass.getDays().compareTo(twoClass.getDays()) != 0)
                    return false;
                else if (twoClass.getDays() != null)
                    return false;

                if (oneClass.getBldg_room().compareTo(twoClass.getBldg_room()) != 0)
                    return false;
                if (oneClass.getCampus().compareTo(twoClass.getCampus()) != 0)
                    return false;
                if (oneClass.getClassNbr().compareTo(twoClass.getClassNbr()) != 0)
                    return false;

                //Time - 1 string, 4 ints
                if (oneClass.getTime().days.compareTo(twoClass.getTime().days) != 0)
                    return false;
                if (oneClass.getTime().frHr != twoClass.getTime().frHr)
                    return false;
                if (oneClass.getTime().frMn != twoClass.getTime().frMn)
                    return false;
                if (oneClass.getTime().toHr != twoClass.getTime().toHr)
                    return false;
                if (oneClass.getTime().toMn != twoClass.getTime().toMn)
                    return false;

                //Course - 3 strings, 1 int
                if (oneClass.getCourse().catlgNbr.compareTo(twoClass.getCourse().catlgNbr) != 0)
                    return false;
                if (oneClass.getCourse().subject.compareTo(twoClass.getCourse().subject) != 0)
                    return false;
                if (oneClass.getCourse().description.compareTo(twoClass.getCourse().description) != 0)
                    return false;
                if (oneClass.getCourse().units != twoClass.getCourse().units)
                    return false;

                //Professor - Need super of FacultyStaff
                if (oneClass.getInstructor().getFirstName().compareTo(twoClass.getInstructor().getFirstName()) != 0)
                    return false;
                if (oneClass.getInstructor().getSSN().compareTo(twoClass.getInstructor().getSSN()) != 0)
                    return false;
                if (oneClass.getInstructor().getLastName().compareTo(twoClass.getInstructor().getLastName()) != 0)
                    return false;
            }
        }
        return true;
    }

}
