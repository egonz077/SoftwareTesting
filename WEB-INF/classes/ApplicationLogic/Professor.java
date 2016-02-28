package ApplicationLogic;


import ApplicationLogic.ClassDetails;
import ApplicationLogic.FacultyStaff;

public class Professor extends FacultyStaff {


    public Professor(String SSN, String firstName, String lastName)
    {
        super(SSN, firstName, lastName);
    }

    public ClassDetails[] getClasses()
    {
        return null;
    }

    //New constructor
    public Professor() {
        super();
    }
}
