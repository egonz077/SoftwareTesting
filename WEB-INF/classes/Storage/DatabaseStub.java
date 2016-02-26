package Storage;

import ApplicationLogic.ClassDetails;
import ApplicationLogic.Time;

import java.util.ArrayList;
import java.util.Collection;

public class DatabaseStub {

    public String subject;
    public String catlgNbr;

    //ssn, pantherID, password
    String[][] studentDatabase = {
            {"154345234", "2234523", "abc345"},
            {"134523135", "2354235", "abc234"},
            {"123456789", "1412412", "abc123"}
    };
    //courseid, classNbr, subject, catlgNbr, term, campus, sect, from, to, days
    String[][] classDatabase = {
            {"5", "24536", "HIS", "1010", "Spring 2007", "University", "U01", "08:00:00", "09:15:00", "1010000"},
            {"5", "24537", "HIS", "1010", "Spring 2007", "University", "U01", "18:25:00", "19:40:00", "0101000"}
    };

    public DatabaseStub() {

    }

    public DatabaseStub(String subject, String catlgNbr) {
        this.subject = subject;
        this.catlgNbr = catlgNbr;
    }

    public boolean isLoginValid(String pantherID, String pass) {
        for (int i = 0; i < studentDatabase.length; i++)
            if (studentDatabase[i][1].compareTo(pantherID) == 0)
                if (studentDatabase[i][2].compareTo(pass) == 0)
                    return true;
        return false;
    }

    public Collection<ClassDetails> getClasses(String term, Collection<String> campus) {
        Collection<ClassDetails> result = new ArrayList<ClassDetails>();
        for (int i = 0; i < classDatabase.length; i++)
            if (classDatabase[i][2].compareTo(subject) == 0 &&
                    classDatabase[i][3].compareTo(catlgNbr) == 0 &&
                    classDatabase[i][4].compareTo(term) == 0) {
                ClassDetails tmp = new ClassDetails(this, classDatabase[i][3]);
                tmp.setCampus(classDatabase[i][5]);
                tmp.setTerm(classDatabase[i][4]);
                tmp.setTime(new Time(classDatabase[i][7], classDatabase[i][8], classDatabase[i][9]));
                result.add(tmp);
            }
        return result;
    }
}