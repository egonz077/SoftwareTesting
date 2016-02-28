package ApplicationLogic;

import Storage.BackendFacade;

import java.util.Collection;

public class FrontendFacade {

    /*Takes care of the login portion in loginvalidation.jsp*/
    public boolean login(String user, String pass) {
        return new Authentication().isLoginValid(user, pass);
    }

    /*Takes care of the creation of a schedule in view_schedules.jsp
        This metoid is never called by the client
    public Collection<Schedule> createSchedule(ScheduleOptions schOpt) {
        return new ScheduleMakerController().createSchedule(schOpt);
    }
    */

    /*Takes care of the creation of a schedule in view_schedules2.jsp*/
    public Collection<Schedule> createSchedule(String term, Collection<String> courses, String cmp, String SPDays) {
        return new ScheduleMakerController().createSchedule(term, courses, cmp, SPDays);
    }

    /*takes care of formatting the page and building the schedule in view_schedules.jsp and view_schedules.jsp2*/
    public String buildSchedulesPage(Collection<Schedule> schedules, int pg) {
        return new FormatPage().buildSchedulesPage(schedules, pg);
    }

}
