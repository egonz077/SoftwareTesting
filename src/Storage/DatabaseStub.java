package Storage;

import ApplicationLogic.ClassDetails;

import java.util.ArrayList;
import java.util.Collection;

public class DatabaseStub {

    public String subject;
    public String description;
    public String catlgNbr;
    public int units;

    //ssn, pantherID, password
    private final String[][] studentDatabase = {
            {"154345234", "2234523", "abc345"},
            {"134523135", "2354235", "abc234"},
            {"123456789", "1412412", "abc123"}
    };
    //courseid, classNbr, subject, catlgNbr, term, campus, sect, from, to, days
    private final String[][] classDatabase = {
            {"1", "10772", "COP", "2210", "Spring 2007", "Biscayne",   "B51", "11:00:00", "12:15:00", "1010000"},
            {"1", "17736", "COP", "2210", "Spring 2007", "Biscayne",   "B52", "07:50:00", "09:05:00", "1010101"},
            {"2", "13136", "COP", "2250", "Spring 2007", "University", "U02", "15:30:00", "16:45:00", "1010100"},
            {"2", "14210", "COP", "2250", "Spring 2007", "University", "U01", "11:00:00", "12:15:00", "1010000"},
            {"2", "14211", "COP", "2250", "Spring 2007", "Biscayne",   "B51", "15:30:00", "16:45:00", "1010100"},
            {"3", "10777", "COP", "3175", "Spring 2007", "University", "U01", "18:25:00", "19:40:00", "1010000"},
            {"3", "10778", "COP", "3175", "Spring 2007", "University", "U02", "09:30:00", "10:45:00", "1010000"},
            {"4", "34567", "COP", "3175", "Spring 2007", "University", "U01", "14:00:00", "15:15:00", "1010100"},
            {"4", "34568", "COP", "3175", "Spring 2007", "Biscayne",   "B01", "09:30:00", "10:45:00", "1010100"},
            {"4", "34569", "COP", "3175", "Spring 2007", "University", "U02", "15:30:00", "16:45:00", "1010000"},
            {"5", "24536", "HIS", "1010", "Spring 2007", "University", "U01", "08:00:00", "09:15:00", "1010000"},
            {"5", "24537", "HIS", "1010", "Spring 2007", "University", "U02", "18:25:00", "19:40:00", "0101000"},
            {"6", "65476", "STA", "3510", "Spring 2007", "University", "U01", "17:00:00", "18:15:00", "1010000"},
            {"7", "26543", "PHY", "2048", "Spring 2007", "University", "U01", "11:00:00", "12:15:00", "1010100"},
            {"7", "26544", "PHY", "2048", "Spring 2007", "University", "B01", "14:00:00", "15:15:00", "1010100"},
            {"7", "26545", "PHY", "2048", "Spring 2007", "Biscayne",   "U02", "09:30:00", "10:45:00", "1010000"},
            {"7", "26546", "PHY", "2048", "Spring 2007", "University", "B02", "17:00:00", "18:15:00", "1010000"},
            {"8", "36543", "PHY", "2049", "Spring 2007", "Biscayne",   "U01", "15:30:00", "16:45:00", "1010000"},
            {"8", "36544", "PHY", "2049", "Spring 2007", "University", "U02", "09:30:00", "10:45:00", "1010000"},
            {"8", "36545", "PHY", "2049", "Spring 2007", "Biscayne",   "B01", "19:50:00", "21:15:00", "1010000"},
            {"9", "76546", "COP", "4338", "Spring 2007", "University", "U01", "17:00:00", "18:15:00", "1010100"},
            {"9", "76547", "COP", "4338", "Spring 2007", "Biscayne",   "B01", "09:30:00", "10:45:00", "1010000"}
    };

    public DatabaseStub() {

    }

    public DatabaseStub(String subject, String catlgNbr) {
        this.subject = subject;
        this.catlgNbr = catlgNbr;
    }

    public boolean isLoginValid(String pantherID, String pass) {
        for (String[] aStudentDatabase : studentDatabase)
            if (aStudentDatabase[1].compareTo(pantherID) == 0)
                if (aStudentDatabase[2].compareTo(pass) == 0)
                    return true;
        return false;
    }

    public Collection<ClassDetails> getClasses(String term, Collection<String> campus) {
        Collection<ClassDetails> result = new ArrayList<ClassDetails>();
        for (String[] aClassDatabase : classDatabase) {
            if (aClassDatabase[2].compareTo(subject) == 0 &&
                    aClassDatabase[3].compareTo(catlgNbr) == 0 &&
                    aClassDatabase[4].compareTo(term) == 0) {
                boolean c = true;
                if (campus.size() == 1) {
                    if (aClassDatabase[5].compareTo((String) ((ArrayList) campus).get(0)) != 0)
                        c = false;
                }
                if (c) {
                    ClassDetails tmp = new ClassDetails(this, aClassDatabase[3]);
                    tmp.setCampus(aClassDatabase[5]);
                    tmp.setTerm(aClassDatabase[4]);
                    tmp.setTime(new Time(aClassDatabase[7], aClassDatabase[8], aClassDatabase[9]));
                    result.add(tmp);
                }
            }
        }
        return result;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCatlgNbr(String catlgNbr) {
        this.catlgNbr = catlgNbr;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return subject + catlgNbr;
    }

    public static class FacultyStaff {

        private String SSN;
        private String firstName;
        private String lastName;

        public FacultyStaff(String SSN, String firstName, String lastName) {
            this.SSN = SSN;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getSSN() {
            return SSN;
        }

        public void setSSN(String SSN) {
            this.SSN = SSN;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }


        //Newly created Constructor
        public FacultyStaff() {

        }
    }

    public static class Professor extends FacultyStaff {


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

    public static class Schedule {


        private  String id;
        private  String pantherID;
        private Collection<ClassDetails> classes;

        public Schedule(String pantherID)
        {
            this.pantherID = pantherID;
        }

        public Schedule(Collection classes) {
            this.classes = classes;
        }

        public String getId()
        {
            return id;
        }

        public void setId(String id)
        {
            this.id = id;
        }

        public String getPantherID()
        {
            return pantherID;
        }

        public void setPantherID(String pantherID)
        {
            this.pantherID = pantherID;
        }

        public Collection<ClassDetails> getClasses()
        {
            return classes;
        }

        public void combine (String id)
        {}

        public void addClass (String id)
        {}

        public void deleteClass (String id)
        {}

        public void addClass(Collection<ClassDetails> classes) {
        }

        //New setter and constructor
        public void setClasses(Collection<ClassDetails> classes) {
            this.classes = classes;
        }

        public Schedule() {

        }
    }

    /**
     * Created by IntelliJ IDEA.
     * User: alain
     * Date: Nov 8, 2006
     * Time: 6:18:54 PM
     */
    public static class ScheduleOptions
    {
        String term;
        String course1, course2, course3, course4, course5, course6;
        String campus;
        String m, t, w, th, f, s, su;
        Integer gap;

        public String getTerm() {
            return term;
        }

        public void setTerm(String term) {
            this.term = term;
        }

        public String getCampus() {
            return campus;
        }

        public void setCampus(String campus) {
            this.campus = campus;
        }

        public String getCourse1() {
            return course1;
        }

        public void setCourse1(String course1) {
            this.course1 = course1;
        }

        public String getCourse2() {
            return course2;
        }

        public void setCourse2(String course2) {
            this.course2 = course2;
        }

        public String getCourse3() {
            return course3;
        }

        public void setCourse3(String course3) {
            this.course3 = course3;
        }

        public String getCourse4() {
            return course4;
        }

        public void setCourse4(String course4) {
            this.course4 = course4;
        }

        public String getCourse5() {
            return course5;
        }

        public void setCourse5(String course5) {
            this.course5 = course5;
        }

        public String getCourse6() {
            return course6;
        }

        public void setCourse6(String course6) {
            this.course6 = course6;
        }

        public Integer getGap() {
            return gap;
        }

        public void setGap(Integer gap) {
            this.gap = gap;
        }

        public String getM() {
            return m;
        }

        public void setM(String m) {
            this.m = m;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getW() {
            return w;
        }

        public void setW(String w) {
            this.w = w;
        }

        public String getTh() {
            return th;
        }

        public void setTh(String th) {
            this.th = th;
        }

        public String getF() {
            return f;
        }

        public void setF(String f) {
            this.f = f;
        }

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }

        public String getSu() {
            return su;
        }

        public void setSu(String su) {
            this.su = su;
        }

        //New Constructor
        public ScheduleOptions(String term, String course1, String course2, String course3, String course4, String course5, String course6, String campus, String m, String t, String w, String th, String f, String s, String su, Integer gap)
        {
            this.term = term;
            this.course1 = course1;
            this.course2 = course2;
            this.course3 = course3;
            this.course4 = course4;
            this.course5 = course5;
            this.course6 = course6;
            this.campus = campus;
            this.m = m;
            this.t= t;
            this.w = w;
            this.th = th;
            this.f = f;
            this.s = s;
            this.su = su;
            this.gap = gap;
        }

    }

    public static class Time {

        public int frHr;
        public int frMn;
        public int toHr;
        public int toMn;
        public String days;

        public Time(String from, String to, String days) {
            this.frHr = new Integer(from.substring(0,2));
            this.frMn = new Integer(from.substring(3,5));
            this.toHr = new Integer(to.substring(0,2));
            this.toMn = new Integer(to.substring(3,5));
            this.days = days;
        }

        public Time(int from_hour, int from_minutes, int to_hour, int to_minutes, String days) {
            this.frHr = from_hour;
            this.frMn = from_minutes;
            this.toHr = to_hour;
            this.toMn = to_minutes;
            this.days = days;
        }

        public Time() {

        }

        public String toString() {
            return frHr + ":" + frMn + "-" + toHr + ":" + toMn;
        }

        public String getFromTime() {
            return String.valueOf(frHr)+String.valueOf(frMn);
        }

        public String getToTime() {
            return String.valueOf(toHr)+String.valueOf(toMn);
        }
    }
}
