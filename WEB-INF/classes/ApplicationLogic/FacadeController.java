package ApplicationLogic;

//From Authentication.java
import Storage.DatabaseInterface;

//From FormatPage.java
import Storage.ClassDetails;
import Storage.Schedule;
import java.util.ArrayList;
import java.util.Collection;

//From ScheduleMakerController.java
import Storage.Course;

public class FacadeController {
	
	
	public boolean login(String user, String pass){
		
		Boolean result;
		Authentication smc = new Authentication();
		   
	    result = smc.isLoginValid(user, pass);
	    
	    return result;
	}

}
