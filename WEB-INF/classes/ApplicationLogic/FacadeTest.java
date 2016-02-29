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
    public void testLogin1() {
        //User name and password exists in database
        assertEquals("Logged In?", true, client.login("1412412", "abc123"));

    }

    @Test
    public void testLogin2() {
        //User name and password exists in database
        assertEquals("Logged In?", true, client.login("2354235", "abc234"));

    }

    @Test
    public void testLogin3() {
        //User name and password exists in database
        assertEquals("Logged In?", true, client.login("2234523", "abc345"));

    }

    //Rainy-Day
    @Test
    public void testLogin4() {
        //User name doesn't exist, but password does
        assertEquals("Logged In?", false, client.login("445984253", "abc123"));

    }

    @Test
    public void testLogin5() {
        //User name exists, but password does not
        assertEquals("Logged In?", false, client.login("2354235", "!@#$%"));

    }

    @Test
    public void testLogin6() {
        //Neither User name or password exists in the database
        assertEquals("Logged In?", false, client.login("tumadre3", "1256738fjden"));
    }


    //Testing method createSchedule
    //Sunny-Day
    @Test
    public void testCreateSchedule1() {
        //Test schedule object
        DatabaseStub course = new DatabaseStub("Subject", "catlgNbr");
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

        Collection<ClassDetails> collectionOfClassDetails = new ArrayList<ClassDetails>();
        collectionOfClassDetails.add(classDetails);

        Collection<Collection<ClassDetails>> c = new ArrayList<Collection<ClassDetails>>();
        c.add(collectionOfClassDetails);

        ArrayList list = (ArrayList) c;

        Schedule schedule = new Schedule(list);
        //schedule.setClasses(collectionOfClassDetails);
        //schedule.setPantherID("");
        //schedule.setId("");

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
        // System.out.println(Client.createSchedule("Spring 2007", courses, "All", "1111111"));
        assertEquals("Collection:", true,
                compareCollectionofSchedule(test, client));
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
    public void SM_001BS_Subsystem_TC013() {
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
        Collection collectionOfSchedules;
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
    public void SM_001BS_Subsystem_TC014() {
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
        Collection collectionOfSchedules = client.createSchedule("Spring 2007", courses, "University", SPDays);

        //Page number
        int pg = 0;

        assertEquals("HTML String:", Test, client.buildSchedulesPage(collectionOfSchedules, pg));
    }

    @Test
    public void SM_001BS_Subsystem_TC015() {
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
        Collection collectionOfSchedules;
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
    public void SM_001BS_Subsystem_TC016() {
        //Test String
        String Test =
                "No Schedule Found";

        //Client Collection<Schedule> Object
        Collection collectionOfSchedules;
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
        //if (collectionOfSchedules < 1)
        //Page number
        int pg = 0;

        assertEquals("HTML String:", Test, client.buildSchedulesPage(collectionOfSchedules, pg));
    }

    @Test
    public void SM_001BS_Subsystem_TC017() {
        //Test String
        String Test =
                "No Schedule Found";

        //Client Collection<Schedule> Object
        Collection collectionOfSchedules;
        FrontendFacade fc = new FrontendFacade();
        Collection<String> courses = new ArrayList<String>();
        //Form Courses
            /*No Courses added*/
        //University
        String university = "University";
        //Select days
        String SPDays = "1010000";
        //Make collectionOfSchedules
        collectionOfSchedules = fc.createSchedule("Spring 2007", courses, university, SPDays);
        //Page number
        int pg = 0;


        assertEquals("HTML String:", Test, client.buildSchedulesPage(collectionOfSchedules, pg));
    }

    @Test
    public void SM_001BS_Subsystem_TC018() {
        //Test String
        String Test =
                "No Schedule Found";

        //Client Collection<Schedule> Object
        Collection collectionOfSchedules;
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


        assertEquals("HTML String:", Test, client.buildSchedulesPage(collectionOfSchedules, pg));
    }

    //Comaring Collections of schedules
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

                if (!compareSchedules(qwe, asd))
                    return false;

                Collection wer = qwe.getClasses();
                Collection sdf = asd.getClasses();

                Iterator e1 = wer.iterator();
                Iterator e2 = sdf.iterator();

                while (e1.hasNext()) {
                    if (!e2.hasNext())
                        return false;

                    Object po = e1.next();
                    Object pe = e2.next();

                    Collection<ClassDetails> w = (Collection<ClassDetails>) po;
                    Collection<ClassDetails> q = (Collection<ClassDetails>) pe;

                    Iterator u1 = w.iterator();
                    Iterator u2 = q.iterator();

                    while (u1.hasNext()) {
                        if (!u2.hasNext())
                            return false;

                        ClassDetails classDetails1 = (ClassDetails) u1.next();
                        ClassDetails classDetails2 = (ClassDetails) u2.next();

                        if (!compareClassDetails(classDetails1, classDetails2))
                            return false;

                    }
                }
            }
        }
        return true;
    }

    private boolean compareClassDetails(ClassDetails oneClass, ClassDetails twoClass) {
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
