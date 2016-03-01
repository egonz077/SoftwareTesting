package ApplicationLogic;

import Storage.DatabaseStub;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Dominick Martelly on 2/29/2016 at 7:25 PM.
 *
 * This is the SubsystemTest Class for schedule maker to test the package AppLogic by specification
 */

public class SubsystemTest {

    public FrontendFacade client;

    @Before
    public void setUp() throws Exception {
        client = new FrontendFacade();
    }

    @After
    public void tearDown() throws Exception {
        client = null;
    }

    //Testing method login
    //Sunny-Day
    @Test
    public void SM_001L_Subsystem_TC001() throws Exception {
        //User name and password exists in database
        assertEquals("Logged In?", true, client.login("1412412", "abc123"));

    }

    @Test
    public void SM_001L_Subsystem_TC002() throws Exception {
        //User name and password exists in database
        assertEquals("Logged In?", true, client.login("2354235", "abc234"));

    }

    @Test
    public void SM_001L_Subsystem_TC003() throws Exception {
        //User name and password exists in database
        assertEquals("Logged In?", true, client.login("2234523", "abc345"));

    }

    //Rainy-Day
    @Test
    public void SM_001L_Subsystem_TC004() throws Exception {
        //User name doesn't exist, but password does
        assertEquals("Logged In?", false, client.login("445984253", "abc123"));

    }

    @Test
    public void SM_001L_Subsystem_TC005() throws Exception {
        //User name exists, but password does not
        assertEquals("Logged In?", false, client.login("2354235", "!@#$%"));

    }

    @Test
    public void SM_001L_Subsystem_TC006() throws Exception {
        //Neither User name or password exists in the database
        assertEquals("Logged In?", false, client.login("tumadre3", "1256738fjden"));
    }


    //Testing method createSchedule
    //Sunny-Day
    @Test
    public void SM_002CS_Subsystem_TC007() throws Exception {
        //Test schedule object
        DatabaseStub course = new DatabaseStub();
        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);

        Time time = new Time();
        time.setDays("1010000");
        time.setFrHr(8);
        time.setFrMn(0);
        time.setToHr(9);
        time.setToMn(15);

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

        Collection test = new ArrayList<Schedule>();
        test.add(schedule);

        //Client
        //Term (Spring 2007)
        String term = "Spring 2007";

        //Collection of courses
        Collection<String> courses = new ArrayList<String>();
        courses.add("HIS1010");

        //Campus (University, Biscane)
        String campus = "All";

        //SPDays (10100000)
        String SPdays = "1010000";

        Collection client = this.client.createSchedule(term, courses, campus, SPdays);

        assertEquals("Collection:", true, compareCollectionofSchedule(test, client));
    }

    @Test
    public void SM_002CS_Subsystem_TC008() throws Exception {
        //Test schedule object
        Collection<Collection<ClassDetails>> c = new ArrayList<Collection<ClassDetails>>();

        DatabaseStub course = new DatabaseStub();
        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);

        Time time = new Time();
        time.setDays("1010000");
        time.setFrHr(8);
        time.setFrMn(0);
        time.setToHr(9);
        time.setToMn(15);

        ClassDetails classDetails = new ClassDetails();
        classDetails.setDatabaseStub(course);
        classDetails.setTime(time);
        classDetails.setCampus("University");
        classDetails.setTerm("Spring 2007");
        classDetails.setClassNbr("1010");

        Collection<ClassDetails> collectionOfClassDetails = new ArrayList<ClassDetails>();
        collectionOfClassDetails.add(classDetails);
        c.add(collectionOfClassDetails);

        //2nd Course
        DatabaseStub course1 = new DatabaseStub();
        course1.setCatlgNbr("2250");
        course1.setSubject("COP");
        course1.setUnits(0);

        Time time1 = new Time();
        time1.setDays("1010000");
        time1.setFrHr(11);
        time1.setFrMn(0);
        time1.setToHr(12);
        time1.setToMn(15);

        ClassDetails classDetails1 = new ClassDetails();
        classDetails1.setDatabaseStub(course1);
        classDetails1.setTime(time1);
        classDetails1.setCampus("University");
        classDetails1.setTerm("Spring 2007");
        classDetails1.setClassNbr("2250");

        Collection<ClassDetails> collectionOfClassDetails1 = new ArrayList<ClassDetails>();
        collectionOfClassDetails1.add(classDetails1);
        c.add(collectionOfClassDetails1);

        ArrayList list = (ArrayList) c;
        Schedule schedule = new Schedule(list);

        Collection test = new ArrayList<Schedule>();
        test.add(schedule);

        //Client
        //Term (Spring 2007)
        String term = "Spring 2007";

        //Collection of courses
        Collection<String> courses = new ArrayList<String>();
        courses.add("HIS1010");
        courses.add("COP2250");

        //Campus (University, Biscane)
        String campus = "University";

        //SPDays (10100000)
        String SPdays = "1010000";

        Collection client = this.client.createSchedule(term, courses, campus, SPdays);

        assertEquals("Collection:", true, compareCollectionofSchedule(test, client));
    }

    @Test
    public void SM_002CS_Subsystem_TC009() throws Exception {
        //Test schedule object
        Collection<Collection<ClassDetails>> c = new ArrayList<Collection<ClassDetails>>();

        DatabaseStub course = new DatabaseStub();
        course.setCatlgNbr("1010");
        course.setSubject("HIS");
        course.setUnits(0);

        Time time = new Time();
        time.setDays("1010000");
        time.setFrHr(8);
        time.setFrMn(0);
        time.setToHr(9);
        time.setToMn(15);

        ClassDetails classDetails = new ClassDetails();
        classDetails.setDatabaseStub(course);
        classDetails.setTime(time);
        classDetails.setCampus("University");
        classDetails.setTerm("Spring 2007");
        classDetails.setClassNbr("1010");

        Collection<ClassDetails> collectionOfClassDetails = new ArrayList<ClassDetails>();
        collectionOfClassDetails.add(classDetails);
        c.add(collectionOfClassDetails);

        //2nd Course
        DatabaseStub course1 = new DatabaseStub();
        course1.setCatlgNbr("2250");
        course1.setSubject("COP");
        course1.setUnits(0);

        Time time1 = new Time();
        time1.setDays("1010000");
        time1.setFrHr(11);
        time1.setFrMn(0);
        time1.setToHr(12);
        time1.setToMn(15);

        ClassDetails classDetails1 = new ClassDetails();
        classDetails1.setDatabaseStub(course1);
        classDetails1.setTime(time1);
        classDetails1.setCampus("University");
        classDetails1.setTerm("Spring 2007");
        classDetails1.setClassNbr("2250");

        Collection<ClassDetails> collectionOfClassDetails1 = new ArrayList<ClassDetails>();
        collectionOfClassDetails1.add(classDetails1);
        c.add(collectionOfClassDetails1);

        //3rd Course
        DatabaseStub course2 = new DatabaseStub();
        course2.setCatlgNbr("2049");
        course2.setSubject("PHY");
        course2.setUnits(0);

        Time time2 = new Time();
        time2.setDays("1010000");
        time2.setFrHr(9);
        time2.setFrMn(30);
        time2.setToHr(10);
        time2.setToMn(45);

        ClassDetails classDetails2 = new ClassDetails();
        classDetails2.setDatabaseStub(course2);
        classDetails2.setTime(time2);
        classDetails2.setCampus("University");
        classDetails2.setTerm("Spring 2007");
        classDetails2.setClassNbr("2049");

        Collection<ClassDetails> collectionOfClassDetails2 = new ArrayList<ClassDetails>();
        collectionOfClassDetails2.add(classDetails2);
        c.add(collectionOfClassDetails2);

        ArrayList list = (ArrayList) c;
        Schedule schedule = new Schedule(list);

        Collection test = new ArrayList<Schedule>();
        test.add(schedule);

        //Client
        //Term (Spring 2007)
        String term = "Spring 2007";

        //Collection of courses
        Collection<String> courses = new ArrayList<String>();
        courses.add("HIS1010");
        courses.add("COP2250");
        courses.add("PHY2049");

        //Campus (University, Biscane)
        String campus = "University";

        //SPDays (10100000)
        String SPdays = "1010000";

        Collection client = this.client.createSchedule(term, courses, campus, SPdays);

        assertEquals("Collection:", true, compareCollectionofSchedule(test, client));
    }

    //Rainy-Day
    @Test
    public void SM_002CS_Subsystem_TC010() throws Exception {
        //Test schedule object
        Collection test = new ArrayList();

        //Client
        //Term (Spring 2007)
        String term = "Spring 2007";

        //Collection of courses
        Collection<String> courses = new ArrayList<String>();
        courses.add("UnderWaterBasketWeaving101");

        //Campus (University, Biscane)
        String campus = "All";

        //SPDays (10100000)
        String SPdays = "1010000";

        Collection client = this.client.createSchedule(term, courses, campus, SPdays);
        assertEquals("Collection:", true, compareCollectionofSchedule(test, client));
    }

    @Test
    public void SM_002CS_Subsystem_TC011() throws Exception {
        //Test schedule object
        Collection test = new ArrayList();

        //Client
        //Term (Spring 2007)
        String term = "Spring 2007";

        //Collection of courses
        Collection<String> courses = new ArrayList<String>();
        courses.add("HIS1010");

        //Campus (University, Biscane)
        String campus = "Biscayne";

        //SPDays (10100000)
        String SPdays = "1010000";

        Collection client = this.client.createSchedule(term, courses, campus, SPdays);
        assertEquals("Collection:", true, compareCollectionofSchedule(test, client));
    }

    @Test
    public void SM_002CS_Subsystem_TC012() throws Exception {
        //Test schedule object
        Collection test = new ArrayList();

        //Client
        //Term (Spring 2007)
        String term = "Spring 2007";

        //Collection of courses
        Collection<String> courses = new ArrayList<String>();
        courses.add("HIS1010");

        //Campus (University, Biscane)
        String campus = "University";

        //SPDays (10100000)
        String SPdays = "0000000";

        Collection client = this.client.createSchedule(term, courses, campus, SPdays);

        assertEquals("Collection:", true, compareCollectionofSchedule(test, client));
    }


    //Testing method buildSchedules
    //Sunny-Day
    @Test
    public void SM_003BS_Subsystem_TC013() throws Exception {
        //Test String
        String Test =
                "<form id=\"form1\" method=\"post\" action=\"\"><h2>Schedule1</h2><table><tr><td>Hours</td><td>Monday</td><td>Tuesday</td><td>Wednesday</td><td>Thursday</td><td>Friday</td><td>Saturday</td><td>Sunday</td></tr><tr><td>0:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>1:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>2:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>3:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>4:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>5:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>6:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>7:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>8:00</td><td>HIS1010\n" +
                        "1010\n" +
                        "8:0-9:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>HIS1010\n" +
                        "1010\n" +
                        "8:0-9:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>9:00</td><td>HIS1010\n" +
                        "1010\n" +
                        "8:0-9:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>HIS1010\n" +
                        "1010\n" +
                        "8:0-9:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>10:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>11:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>12:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>13:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>14:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>15:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>16:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>17:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>18:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>19:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>20:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>21:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>22:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>23:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></table>";

        //Client Collection<Schedule> Object
        Collection<Schedule> collectionOfSchedules;
        FrontendFacade fc = new FrontendFacade();
        Collection<String> courses = new ArrayList<String>();
        //Form Courses
        courses.add("HIS1010");

        //Select days
        String SPDays = "";
        SPDays += "10100000";

        //Make collectionOfSchedules
        collectionOfSchedules = fc.createSchedule("Spring 2007", courses, "University", SPDays);

        int pg = 0;

        assertEquals("HTML String:", Test, client.buildSchedulesPage(collectionOfSchedules, pg));
    }

    @Test
    public void SM_003BS_Subsystem_TC014() throws Exception {
        //Test String
        String Test =
                "<form id=\"form1\" method=\"post\" action=\"\"><h2>Schedule1</h2><table><tr><td>Hours</td><td>Monday</td><td>Tuesday</td><td>Wednesday</td><td>Thursday</td><td>Friday</td><td>Saturday</td><td>Sunday</td></tr><tr><td>0:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>1:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>2:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>3:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>4:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>5:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>6:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>7:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>8:00</td><td>HIS1010\n" +
                        "1010\n" +
                        "8:0-9:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>HIS1010\n" +
                        "1010\n" +
                        "8:0-9:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>9:00</td><td>HIS1010\n" +
                        "1010\n" +
                        "8:0-9:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>HIS1010\n" +
                        "1010\n" +
                        "8:0-9:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>10:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>11:00</td><td>COP2250\n" +
                        "2250\n" +
                        "11:0-12:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>COP2250\n" +
                        "2250\n" +
                        "11:0-12:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>12:00</td><td>COP2250\n" +
                        "2250\n" +
                        "11:0-12:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>COP2250\n" +
                        "2250\n" +
                        "11:0-12:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>13:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>14:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>15:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>16:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>17:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>18:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>19:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>20:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>21:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>22:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>23:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></table>";

        //Client Collection<Schedule> Object
        Collection<String> courses = new ArrayList<String>();
        //Form Courses
        courses.add("HIS1010");
        courses.add("COP2250");
        //Select days
        String SPDays = "10100000";

        //Make collectionOfSchedules
        Collection<Schedule> collectionOfSchedules = client.createSchedule("Spring 2007", courses, "University", SPDays);

        //Page number
        int pg = 0;

        assertEquals("HTML String:", Test, client.buildSchedulesPage(collectionOfSchedules, pg));
    }

    @Test
    public void SM_003BS_Subsystem_TC015() throws Exception {
        //Test String
        String Test =
                "<form id=\"form1\" method=\"post\" action=\"\"><h2>Schedule3</h2><table><tr><td>Hours</td><td>Monday</td><td>Tuesday</td><td>Wednesday</td><td>Thursday</td><td>Friday</td><td>Saturday</td><td>Sunday</td></tr><tr><td>0:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>1:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>2:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>3:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>4:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>5:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>6:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>7:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>8:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>9:00</td><td>PHY2048\n" +
                        "2048\n" +
                        "9:30-10:45\n" +
                        "Biscayne\n" +
                        "</td><td>&nbsp;</td><td>PHY2048\n" +
                        "2048\n" +
                        "9:30-10:45\n" +
                        "Biscayne\n" +
                        "</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>10:00</td><td>PHY2048\n" +
                        "2048\n" +
                        "9:30-10:45\n" +
                        "Biscayne\n" +
                        "</td><td>&nbsp;</td><td>PHY2048\n" +
                        "2048\n" +
                        "9:30-10:45\n" +
                        "Biscayne\n" +
                        "</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>11:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>12:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>13:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>14:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>15:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>16:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>17:00</td><td>COP4338\n" +
                        "4338\n" +
                        "17:0-18:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>COP4338\n" +
                        "4338\n" +
                        "17:0-18:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>COP4338\n" +
                        "4338\n" +
                        "17:0-18:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>18:00</td><td>COP4338\n" +
                        "4338\n" +
                        "17:0-18:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>COP4338\n" +
                        "4338\n" +
                        "17:0-18:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>COP4338\n" +
                        "4338\n" +
                        "17:0-18:15\n" +
                        "University\n" +
                        "</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>19:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>20:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>21:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>22:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>23:00</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></table>";
        //Client Collection<Schedule> Object
        Collection<Schedule> collectionOfSchedules;
        FrontendFacade fc = new FrontendFacade();
        Collection<String> courses = new ArrayList<String>();
        //Form Courses
        courses.add("PHY2048");
        courses.add("COP4338");
        //University
        String university = "All";
        //Select days
        String SPDays = "10101000";
        //Make collectionOfSchedules
        collectionOfSchedules = fc.createSchedule("Spring 2007", courses, university, SPDays);

        int pg = 2;

        //Add courses PHY2048, COP4338, in all campuses, on days monday, wednesday, and friday, and show page 2
        assertEquals("HTML String:", Test, client.buildSchedulesPage(collectionOfSchedules, pg));
    }

    //Rainy-Day
    /*
     * This test passes a Collection of Schedules that contains only one schedule where the
     * term is Summer 2007, Courses Object containing HIS1010, in the campus University
     * On monday and wednesday, showing page 0
     */
    @Test
    public void SM_003BS_Subsystem_TC016() throws Exception {
        //Test String
        String test = null;

        //Client Collection<Schedule> Object
        Collection<Schedule> collectionOfSchedules;
        FrontendFacade fc = new FrontendFacade();
        Collection<String> courses = new ArrayList<String>();
        //Form Courses
        courses.add("HIS1010");
        //University
        String university = "University";
        //Select days
        String SPDays = "1010000";
        //Make collectionOfSchedules
        collectionOfSchedules = fc.createSchedule("Summer 2007", courses, university, SPDays);
        //Page number
        int pg = 0;

        try {
            client.buildSchedulesPage(collectionOfSchedules, pg);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("HTML String:", test, null);
        }
    }

    @Test
    public void SM_003BS_Subsystem_TC017() throws Exception {
        //Test String
        String test = null;

        //Client Collection<Schedule> Object
        Collection<Schedule> collectionOfSchedules;
        FrontendFacade fc = new FrontendFacade();
        Collection<String> courses = new ArrayList<String>();
        //Form Courses
        courses.add("HIS1010");
        //University
        String university = "University";
        //Select days
        String SPDays = "0000000";
        //Make collectionOfSchedules
        collectionOfSchedules = fc.createSchedule("Spring 2007", courses, university, SPDays);
        //Page number
        int pg = 0;

        try {
            client.buildSchedulesPage(collectionOfSchedules, pg);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("HTML String:", test, null);
        }
    }

    @Test
    public void SM_003BS_Subsystem_TC018() throws Exception {
        //Test String
        String test = null;

        //Client Collection<Schedule> Object
        Collection<Schedule> collectionOfSchedules;
        FrontendFacade fc = new FrontendFacade();
        Collection<String> courses = new ArrayList<String>();
        //Form Courses
        courses.add("ABCD123");
        //University
        String university = "University";
        //Select days
        String SPDays = "1010000";
        //Make collectionOfSchedules
        collectionOfSchedules = fc.createSchedule("Spring 2007", courses, university, SPDays);
        //Page number
        int pg = 0;

        try {
            client.buildSchedulesPage(collectionOfSchedules, pg);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("HTML String:", test, null);
        }
    }

    @Test
    public void SM_004BP_Subsystem_TC019() throws Exception {
        client.buildPage();
        fail("Not yet implemented");
    }

    @Test
    public void SM_005GSS_Subsystem_TC020() throws Exception {
        client.getSavedSchedules();
        fail("Not yet implemented");
    }

    @Test
    public void SM_006GB_Subsystem_TC021() throws Exception {
        client.getBalance();
        fail("Not yet implemented");
    }

    @Test
    public void SM_007LO_Subsystem_TC022() throws Exception {
        client.logout();
        fail("Not yet implemented");
    }

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
}
