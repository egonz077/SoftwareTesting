package ApplicationLogic;

import Storage.BackendFacade;
import Storage.Course;
import Storage.DatabaseStub;

import java.util.ArrayList;
import java.util.Iterator;


public class ClassDetails {

    private DatabaseStub db;
    private String classNbr;
    private Professor instructor;
    private String bldg_room;
    private String campus;
    private String term;
    private Time time;

    //constructor

    public ClassDetails() {

    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public ClassDetails(DatabaseStub db, String classNbr) {
        this.db = db;
        this.classNbr = classNbr;
    }

    public Professor getInstructor() {
        return null;
    }

    public boolean hasConflict(ClassDetails cd) {
        Time c1 = getTime();
        Time c2 = cd.getTime();
        //compare times
        String daysofC1 = c1.days;
        String daysofC2 = c2.days;
        //System.out.println(daysofC1);
        ArrayList<String> A1, A2;
        A1 = new ArrayList<String>();
        A2 = new ArrayList<String>();
        String[] days = new String[7];
        days[0] = "Mon";
        days[1] = "Tues";
        days[2] = "Wed";
        days[3] = "Thurs";
        days[4] = "Fri";
        days[5] = "Sat";
        days[6] = "Sun";

        for (int i = 0; i < 7; i++)
        {
            if (daysofC1.charAt(i) == '1')
            {
                String day = new String(days[i]);
                A1.add(day);
            }
        }

        for (int i = 0; i < 7; i++)
        {
            if (daysofC2.charAt(i) == '1')
            {
                String day = new String(days[i]);
                A2.add(day);
            }
        }
        Iterator<String> it1 = A1.iterator();
        Iterator<String> it2 = A2.iterator();
        while (it1.hasNext())
        {
            String d1 = it1.next();
            while (it2.hasNext())
            {
                String d2 = it2.next();

                if (d1.equals(d2))
                {
                    //both classes starts at same hour
                    if (c1.frHr == c2.frHr)
                    {
                        if (c1.frMn >= c2.frMn)
                            return true;
                    }
                    // c1 starts before c2
                    else if (c1.frHr < c2.frHr)
                    {
                        if (c1.toHr == c2.frHr)
                        {
                            if (c1.toMn >= c2.frMn)
                                return true;
                        }
                        else if (c1.toHr > c2.frHr)
                            return true;
                    }

                    //c1 starts after c2

                    else if (c1.frHr > c2.frHr)
                    {
                        if (c2.toHr == c1.frHr)
                        {
                            if (c2.toMn >= c1.frMn)
                                return true;
                        }
                        else if (c2.toHr > c1.frHr)
                            return true;
                    }
                }
            }
        }

        return false;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time t) {
        time = t;
    }

    public boolean isAtTime(int hour) {
        if(getTime().frHr <= hour && hour <= getTime().toHr)
            return true;
        else
            return false;
    }

    public boolean isAtDay(int day) {
        if(getTime().days.substring(day, day+1).equals("1"))
            return true;
        else
            return false;
    }

    public String toString() {
        String result = "";
        result += db.toString() + "\n" + classNbr + "\n";
        if (this.getTime() != null)
            result += "" + this.getTime().toString() + "\n";
//        if (instructor != null)
//            result += "" + instructor.toString();
//        if (bldg_room != null)
//            result += "" + bldg_room;
        if (campus != null)
            result += "" + campus + "\n";
//        if (term != null)
//            result += "" + term.toString();
        return result;
    }

    public String getDays() {
        return getTime().days;
    }


    //New Getters
    public DatabaseStub getCourse() {
        return db;
    }

    public String getClassNbr() {
        return classNbr;
    }

    public String getBldg_room() {
        return bldg_room;
    }

    public String getCampus() {
        return campus;
    }

    public String getTerm() {
        return term;
    }

    //New Setters
    public void setDatabaseStub(DatabaseStub databaseStub) {
        this.db = databaseStub;
    }

    public void setProfessor(Professor professor) {
        this.instructor = professor;
    }

    public void setClassNbr(String classNbr) {
        this.classNbr = classNbr;
    }

    public void setBldg_room(String bldg_room) {
        this.bldg_room = bldg_room;
    }
}
