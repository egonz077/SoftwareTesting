package Storage;

import java.util.ArrayList;
import java.util.Collection;

import ApplicationLogic.ScheduleOptions;

public class BackendFacade {

	// Initialize Array List
	ArrayList<String> listOfUsers, listOfPasswords;

	public BackendFacade() {

	}

	public boolean login(String pantherID, String pass) {
		return new DatabaseStub().login(pantherID, pass);
	}
	
	public Collection<Schedule> createSchedule(ScheduleOptions schOpt){
		return new DatabaseStub().createSchedule(schOpt);
	}
}
