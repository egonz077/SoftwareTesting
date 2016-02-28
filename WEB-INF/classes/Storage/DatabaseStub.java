package Storage;

import ApplicationLogic.ClassDetails;
import ApplicationLogic.Time;

import java.util.ArrayList;
import java.util.Collection;

public class DatabaseStub {

    public String subject;
    public String description;
    public String catlgNbr;
    public int units;

    //ssn, pantherID, password
    String[][] studentDatabase = {
            {"154345234", "2234523", "abc345"},
            {"134523135", "2354235", "abc234"},
            {"123456789", "1412412", "abc123"}
    };
    //courseid, classNbr, subject, catlgNbr, term, campus, sect, from, to, days
    String[][] classDatabase = {
            {"1", "10772", "COP", "2210", "Spring 2007", "Biscayne",   "B51", "11:00:00", "12:15:00", "1010000"},
            {"1", "17736", "COP", "2210", "Spring 2007", "Biscayne",   "B52", "7:50:00 ", "9:05:00",  "1010101"},
            {"2", "13136", "COP", "2250", "Spring 2007", "University", "U02", "15:30:00", "16:45:00", "1010100"},
            {"2", "14210", "COP", "2250", "Spring 2007", "University", "U01", "11:00:00", "12:15:00", "1010000"},
            {"2", "14211", "COP", "2250", "Spring 2007", "Biscayne",   "B51", "15:30:00", "16:45:00", "1010100"},
            {"3", "10777", "COP", "3175", "Spring 2007", "University", "U01", "18:25:00", "19:40:00", "1010000"},
            {"3", "10778", "COP", "3175", "Spring 2007", "University", "U02", "9:30:00 ", "10:45:00", "1010000"},
            {"4", "34567", "COP", "3175", "Spring 2007", "University", "U01", "14:00:00", "15:15:00", "1010100"},
            {"4", "34568", "COP", "3175", "Spring 2007", "Biscayne",   "B01", "9:30:00 ", "10:45:00", "1010100"},
            {"4", "34569", "COP", "3175", "Spring 2007", "University", "U02", "15:30:00", "16:45:00", "1010000"},
            {"5", "24536", "HIS", "1010", "Spring 2007", "University", "U01", "08:00:00", "09:15:00", "1010000"},
            {"5", "24537", "HIS", "1010", "Spring 2007", "University", "U02", "18:25:00", "19:40:00", "0101000"},
            {"6", "65476", "STA", "3510", "Spring 2007", "University", "U01", "17:00:00", "18:15:00", "1010000"},
            {"7", "26543", "PHY", "2048", "Spring 2007", "University", "U01", "11:00:00", "12:15:00", "1010100"},
            {"7", "26544", "PHY", "2048", "Spring 2007", "University", "B01", "14:00:00", "15:15:00", "1010100"},
            {"7", "26545", "PHY", "2048", "Spring 2007", "Biscayne",   "U02", "9:30:00" , "10:45:00", "1010000"},
            {"7", "26546", "PHY", "2048", "Spring 2007", "University", "B02", "17:00:00", "18:15:00", "1010000"},
            {"8", "36543", "PHY", "2049", "Spring 2007", "Biscayne",   "U01", "15:30:00", "16:45:00", "1010000"},
            {"8", "36544", "PHY", "2049", "Spring 2007", "University", "U02", "9:30:00" , "10:45:00", "1010000"},
            {"8", "36545", "PHY", "2049", "Spring 2007", "Biscayne",   "B01", "19:50:00", "21:15:00", "1010000"},
            {"9", "76546", "COP", "4338", "Spring 2007", "University", "U01", "17:00:00", "18:15:00", "1010100"},
            {"9", "76547", "COP", "4338", "Spring 2007", "Biscayne",   "B01", "9:30:00" , "10:45:00", "1010000"}
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
        for (String[] aClassDatabase : classDatabase)
            if (aClassDatabase[2].compareTo(subject) == 0 &&
                    aClassDatabase[3].compareTo(catlgNbr) == 0 &&
                    aClassDatabase[4].compareTo(term) == 0) {
                boolean c = true;
                for (int i = 0; i < campus.size(); i++)
                    if (aClassDatabase[5].compareTo((String) ((ArrayList) campus).get(i)) != 0 || aClassDatabase[5] != "All")
                        c = false;
                if (c) {
                    ClassDetails tmp = new ClassDetails(this, aClassDatabase[3]);
                    tmp.setCampus(aClassDatabase[5]);
                    tmp.setTerm(aClassDatabase[4]);
                    tmp.setTime(new Time(aClassDatabase[7], aClassDatabase[8], aClassDatabase[9]));
                    result.add(tmp);
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
}
