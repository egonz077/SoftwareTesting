package ApplicationLogic;

import ApplicationLogic.Schedule;

import java.util.Currency;


public class Student
{
    private String SSN;

    public Student(String SSN) {
        this.SSN = SSN;
    }

    private String PantherID;
    private String firstName;
    private String lastName;

    public Student(String SSN, String pantherID, String firstName, String lastName)
    {
        this.SSN = SSN;
        PantherID = pantherID;
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

    public String getPantherID()
    {
        return PantherID;
    }

    public void setPantherID(String pantherID)
    {
        PantherID = pantherID;
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

    public Schedule getSavedSchedule()
    {
        return null;
    }

    public Currency getBalance()
    {
        return null;
    }

    public boolean isAdmitted()
    {
        return true;
    }

    public boolean hasClassesRegistered()
    {
        return true;
    }

    public boolean hasSavedSchedule()
    {
        return true;
    }

    public boolean hasCreatedSchedule()
    {
        return true;
    }

    public void saveSchedule(String scheduleID)
    {

    }

    public int numSavedSchedule()
    {
        return 0;
    }
}
