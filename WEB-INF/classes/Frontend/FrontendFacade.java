package Frontend;

import ApplicationLogic.Authentication;
import ApplicationLogic.FormatPage;
import ApplicationLogic.Schedule;
import ApplicationLogic.ScheduleMakerController;

import java.util.Collection;

public class FrontendFacade {

    /*Takes care of the login portion in loginvalidation.jsp*/
    public boolean login(String user, String pass) {
        return new Authentication().isLoginValid(user, pass);
    }

    /*Takes care of the creation of a schedule in view_schedules2.jsp*/
    public Collection<Schedule> createSchedule(String term, Collection<String> courses, String campus, String SPDays) {
        return new ScheduleMakerController().createSchedule(term, courses, campus, SPDays);
    }

    /*takes care of formatting the page and building the schedule in view_schedules.jsp and view_schedules.jsp2*/
    public String buildSchedulesPage(Collection<Schedule> schedules, int pg) {
        return new FormatPage().buildSchedulesPage(schedules, pg);
    }

    /*takes care of building a page*/
    public void buildPage() {
        new FormatPage().buildPage();
    }

    /*gets supposed saved schedule*/
    public void getSavedSchedules() {
        new ScheduleMakerController().getSavedSchedule();

    }

    /*get supposed balance from smc*/
    public void getBalance() {
        new ScheduleMakerController().getBalance();

    }

    /*does supposed logout for Authentiation*/
    public void logout() {

    }
}
