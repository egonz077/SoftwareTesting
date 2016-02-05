package ApplicationLogic;

import java.util.ArrayList;
import java.util.Collection;


public class TestSchedule {

    public static void main(String[] args) {

        Collection<String> courses = new ArrayList<String>();
        courses.add("HIS1010");
        courses.add("STA3510");

        ScheduleMakerController smc = new ScheduleMakerController();
        //
        // This is a driver program used to test the output of our class search algorithm
        // for create schedule. We are sending Spring 2007 as the semester, courses is the
        // collection of courses being searched, All represents the campus being searched,
        // and 1010100 specifies class on MWF only. The expected output of this function
        // is the same as the first test case Team2_CreateSchedule_T1_SD.
        //
        Collection schedules = smc.createSchedule("Spring 2007", courses, "All", "1010100");
        if (schedules.size() > 0)
        {
            FormatPage fp = new FormatPage();

            System.out.println(schedules.toString());
            System.out.println(fp.buildSchedulesPage(schedules, 0));
        }

    }
}
