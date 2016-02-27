package ApplicationLogic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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


    @Test
    public void testCreateScheduleScheduleOptions1() {


        Collection<String> courses = new ArrayList<String>();
        courses.add("HIS1010");
        courses.add("STA3510");
        courses.add("COP2210");
        courses.add("COP3145");
        courses.add("PHY2048");
        courses.add("COP4338");


        //System.out.println(fc.createSchedule("Spring 2007", courses, "All", "1111111"));

        assertEquals("Collection:", true,
                compareSchedule(new Schedule(courses), new Schedule(courses)));
    }

    @Test
    public void testCreateScheduleScheduleOptions2() {


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
    public void testCreateScheduleScheduleOptions3() {


        Collection<String> courses = new ArrayList<String>();

        courses.add("COP2210");


        // System.out.println(fc.createSchedule("Spring 2007", courses, "All", "1111111"));

        assertEquals("Collection:", true,
                compareSchedule(new Schedule(courses), new Schedule(courses)));
    }


    @Test
    public void testBuildSchedulesPage() {
        fail("Not yet implemented");
    }

    private boolean compareSchedule(Schedule one, Schedule two) {
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
