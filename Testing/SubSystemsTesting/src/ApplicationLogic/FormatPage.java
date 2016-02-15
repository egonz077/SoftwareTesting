package ApplicationLogic;

import Storage.ClassDetails;
import Storage.Schedule;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: alain
 * Date: Nov 5, 2006
 * Time: 12:38:57 PM
 */
public class FormatPage {
    public void createPage() { /*to be implemented*/ }

    public void createPage(Schedule schedule[]) { /*to be implemented*/ }

    public void buildPage() { /*to be implemented*/ }

    public void requestPage(String pageName) { /*to be implemented*/ }

    public String buildSchedulesPage(Collection<Schedule> schedules, int page) {
        String htmlBlock = "";
        int i = 1;
        htmlBlock += "<form id=\"form1\" method=\"post\" action=\"\">";
        //out.println("<form id=\"form1\" method=\"post\" action=\"\">");
        Schedule s = (Schedule) ((ArrayList) schedules).get(page);
        htmlBlock += "<h2>Schedule" + (page+1) + "</h2>";
        //////out.println("<h2>Schedule" + (page + 1) + "</h2>");
        htmlBlock += printCalendar(scheduleCalendar(s));
        printCalendar(scheduleCalendar(s));
        return htmlBlock;
    }

    private String[][] scheduleCalendar(Schedule s) {
        String days[] = new String[]{"Hours", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        Collection<ClassDetails> c = s.getClasses();
        String calendar[][] = new String[25][8];
        for (int i = 0; i < 25; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if(j==0 && i>0)
                    calendar[i][0] = "" + (i - 1) + ":00";
                else if(i==0)
                    calendar[0][j] = days[j];
                else
                    calendar[i][j] = "&nbsp;";
            }
        }

        char d[];
        for (Object it : (ArrayList) c)
        {
            ClassDetails classDetails = (ClassDetails) ((ArrayList) it).get(0);
            for (int i = classDetails.getTime().frHr; i <= classDetails.getTime().toHr; i++)
            {
                d = classDetails.getTime().days.toCharArray();
                for (int j=0; j < d.length; j++) {
                   if(d[j] == '1')
                    calendar[i+1][j+1] = classDetails.toString();
                }
            }
        }


        return calendar;
    }

    public String printCalendar(String calendar[][]) {
        String htmlBlock = "";
        htmlBlock += "<table>";

        for (int i = 0; i < calendar.length; i++)
        {
            htmlBlock += "<tr>";
            for (int j = 0; j < calendar[0].length; j++)
            {
                htmlBlock += "<td>" + calendar[i][j] + "</td>";
            }
            htmlBlock += "</tr>";
        }
        htmlBlock += "</table>";
        return htmlBlock;
    }
}
