package Storage;


public class FacultyStaff {
	
	private String SSN;
	private String firstName;
	private String lastName;

    public FacultyStaff(String SSN, String firstName, String lastName)
    {
        this.SSN = SSN;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getSSN()
    {
        return SSN;
    }

    public void setSSN(String SSN)
    {
        this.SSN = SSN;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
}
