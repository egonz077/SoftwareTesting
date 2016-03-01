package Storage;

import ApplicationLogic.ClassDetails;
import ApplicationLogic.Time;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


public class Course {

	public String subject;
	public String description;
	public String catlgNbr;
	public int units;

	public ClassDetails getClassesBySubject(String subject)
	{
        return null;
    }

    public Course(String subject, String catlgNbr) {
        this.subject = subject;
        this.catlgNbr = catlgNbr;
    }

    public Collection<ClassDetails> getClasses()
	{
        Collection<ClassDetails> result = new ArrayList<ClassDetails>();
        try {
            UniversityConnection dbconn = UniversityConnection.getInstance();
            dbconn.setSQL("SELECT * FROM classes INNER JOIN course ON course.courseid=classes.courseid WHERE subject=? AND catlgNbr=?");
            dbconn.setString(1, subject);
            dbconn.setString(2, catlgNbr);
            ResultSet rs = dbconn.executeQuery();
            ClassDetails tmp;
            while (rs.next()) {
                tmp = new ClassDetails(new DatabaseStub(subject, catlgNbr), rs.getString("classNbr"));
                //tmp.setFirstName(rs.getString("firstname"));
                result.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println("getClasses(): sql exception");
            e.printStackTrace();
        }

        return result;
    }

	public ClassDetails getClasses( int units)
	{
        return null;
    }

    public String getCatlgNbr() {
        return catlgNbr;
    }

    public String getSubject() {
        return subject;
    }

    public String toString() {
        return getSubject() + getCatlgNbr();
    }

    /**
     * In this method, we return the classes searched for in the university database,
     * given a certain course. To Unit_Sub our method, we created a stub which is normally
     * commented out - but will be uncommented and the remainder code commented - to
     * Unit_Sub the output with a given stub database.
     * @param term
     * @param campus
     * @return Collection<ClassDetails>
     */
    public Collection<ClassDetails> getClasses(String term, Collection<String> campus) {
        Collection<ClassDetails> result = new ArrayList<ClassDetails>();

        // StubDB stub = new StubDB();
        // if(this.subject.equals("HIS") && this.catlgNbr.equals("1010"))
        //     return stub.getClasses1(this);
        // else if(this.subject.equals("STA") && this.catlgNbr.equals("3510"))
        //     return stub.getClasses2(this);
        // else
        //     return new ArrayList<ClassDetails>();

       try {
           UniversityConnection dbconn = UniversityConnection.getInstance();
           String sql = "SELECT * FROM classes INNER JOIN course ON course.courseid=classes.courseid WHERE subject=? AND catlgNbr=? AND term=? AND ";
           if(!campus.isEmpty()) {
               sql += "( campus=? ";
               for(int i=1; i < campus.size(); i++) {
                   sql += " OR campus=?";
               }
               sql += ")";
           }

           dbconn.setSQL(sql);
           dbconn.setString(1, subject);
           dbconn.setString(2, catlgNbr);
           dbconn.setString(3, term);

           for(int i=0; i < campus.size(); i++) {
               dbconn.setString(i+4, (String) ((ArrayList)campus).get(i));
           }
           ResultSet rs = dbconn.executeQuery();
           ClassDetails tmp;
           while (rs.next()) {
               tmp = new ClassDetails(new DatabaseStub(subject, catlgNbr), rs.getString("classNbr"));
               tmp.setCampus(rs.getString("campus"));
               tmp.setTerm(rs.getString("term"));
               tmp.setTime(new Time(rs.getString("from"), rs.getString("to"), rs.getString("days")));
               result.add(tmp);
           }
       } catch (SQLException e) {
           System.out.println("getClasses(): sql exception");
           //e.printStackTrace();
       }

       return result;
    }

}
