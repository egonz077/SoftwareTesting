package Storage;

import java.util.ArrayList;
import java.util.Collection;

import ApplicationLogic.ScheduleOptions;

public class DatabaseStub extends ScheduleOptions implements Comparable<ScheduleOptions>{
	String[] listOfUsers, listOfPasswords;

	public DatabaseStub() {
		listOfUsers = new String[3];
		listOfPasswords = new String[3];

		listOfUsers[0]=("1412412");
		listOfUsers[1]=("2354235");
		listOfUsers[2]=("2234523");
		
		listOfPasswords[0]=("abc123");
		listOfPasswords[1]=("abc234");
		listOfPasswords[2]=("abc345");
	}

	public boolean login(String pantherID, String pass) {

		for (int i = 0; i < listOfUsers.length; i++) {
			if (this.listOfUsers[i].compareTo(pantherID) == 0) {
				if (this.listOfPasswords[i].compareTo(pass) == 0) {
					return true;
				} else
					return false;
			}
		}
		return false;
	}
	
	public Collection<Schedule> createSchedule(ScheduleOptions schOpt) {
        Collection<Schedule> schedules = new ArrayList<Schedule>();

        //get courses
        Collection<String> courses = new ArrayList<String>();
        if (schOpt.getCourse1() != null && !schOpt.getCourse1().trim().equals(""))
            courses.add(schOpt.getCourse1());
        if (schOpt.getCourse2() != null && !schOpt.getCourse2().trim().equals(""))
            courses.add(schOpt.getCourse2());
        if (schOpt.getCourse3() != null && !schOpt.getCourse3().trim().equals(""))
            courses.add(schOpt.getCourse3());
        if (schOpt.getCourse4() != null && !schOpt.getCourse4().trim().equals(""))
            courses.add(schOpt.getCourse4());
        if (schOpt.getCourse5() != null && !schOpt.getCourse5().trim().equals(""))
            courses.add(schOpt.getCourse5());
        if (schOpt.getCourse6() != null && !schOpt.getCourse6().trim().equals(""))
            courses.add(schOpt.getCourse6());
//        courses.add(schOpt.getCourse4());
//        courses.add(schOpt.getCourse5());
//        courses.add(schOpt.getCourse6());
        if (courses.size() <= 0)
            return schedules;

        //get campus
        Collection<String> campus = new ArrayList<String>();
        if (schOpt.getCampus().equals("All"))
        {
            campus.add("Biscayne");
            campus.add("University");
        }
        else
            campus.add(schOpt.getCampus());

        //get term
        String term = schOpt.getTerm();

        //get preferred days
        String SPDays = "";
        if (schOpt.getM() != null)
            SPDays += schOpt.getM();
        else
            SPDays += "1";
        if (schOpt.getT() != null)
            SPDays += schOpt.getT();
        else
            SPDays += "1";
        if (schOpt.getW() != null)
            SPDays += schOpt.getW();
        else
            SPDays += "1";
        if (schOpt.getTh() != null)
            SPDays += schOpt.getTh();
        else
            SPDays += "1";
        if (schOpt.getF() != null)
            SPDays += schOpt.getF();
        else
            SPDays += "1";
        if (schOpt.getS() != null)
            SPDays += schOpt.getS();
        else
            SPDays += "1";
        if (schOpt.getSu() != null)
            SPDays += schOpt.getSu();
        else
            SPDays += "1";

        Course course_tmp;
        Collection<Collection<ClassDetails>> course_collection = new ArrayList<Collection<ClassDetails>>();

        for (Object c : courses)
        {
            course_tmp = new Course(((String) c).substring(0, 3), ((String) c).substring(3));
            Collection<ClassDetails> classes_tmp = course_tmp.getClasses(term, campus);
            if (classes_tmp.size() > 0)
            {

                char[] days = SPDays.toCharArray();
                Collection<ClassDetails> returnClasses = new ArrayList<ClassDetails>();
                boolean daymatches;

                for (Object cd : classes_tmp)
                {
                    daymatches = false;
                    char[] cdays = ((ClassDetails) cd).getDays().toCharArray();
                    for (int i = 0; i < 7; i++)
                    {
                        if (cdays[i] == '1')
                        {
                            if (cdays[i] == days[i])
                                daymatches = true;
                            else
                            {
                                daymatches = false;
                                break;
                            }
                        }
                    }

                    if (daymatches)
                        returnClasses.add((ClassDetails) cd);

                }
                if (!returnClasses.isEmpty())
                    course_collection.add(returnClasses);
            }
        }

        if (!course_collection.isEmpty())
            findSchedule(course_collection, course_collection.size() - 1, schedules);

        return schedules;
    }

	@Override
	public int compareTo(ScheduleOptions schedule1) {
		if (this.getCourse1().compareTo(schedule1.getCourse1()) == 0)
		return 0;
	}
}
