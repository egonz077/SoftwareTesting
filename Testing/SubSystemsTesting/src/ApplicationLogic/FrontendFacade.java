package ApplicationLogic;


import Storage.Schedule;
import java.util.Collection;


public class FrontendFacade {

	 String pantherID;
	 String password;

	/*Takes care of the login portion in loginvalidation.jsp*/
	public boolean login(String user, String pass){

		Boolean result;
		Authentication smc = new Authentication();

	    result = smc.isLoginValid(user, pass);

	    return result;
	}

	/*Takes care of the creation of a schedule in view_schedules.jsp*/
	public Collection<Schedule> createSchedule(ScheduleOptions schOpt){

		ScheduleMakerController smc = new ScheduleMakerController();

		return smc.createSchedule(schOpt);
	}

	/*Takes care of the creation of a schedule in view_schedules2.jsp*/
    public Collection<Schedule> createSchedule(String term, Collection<String> courses, String cmp, String SPDays){

		ScheduleMakerController smc = new ScheduleMakerController();

		return smc.createSchedule(term, courses, cmp, SPDays);
	}

	/*takes care of formatting the page and building the schedule in view_schedules.jsp and view_schedules.jsp2*/
	public String buildSchedulesPage(Collection<Schedule> schedules, int pg){

		FormatPage fp = new FormatPage();

		return fp.buildSchedulesPage(schedules, pg);
	}

}
