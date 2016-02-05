package Storage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: alain
 * Date: Nov 13, 2006
 * Time: 6:25:00 PM
 */
public class DatabaseInterface {

    public Student getStudent(String pantherID) {
        Student result = null;

        try
        {
            DatabaseConnection dbconn = DatabaseConnection.getInstance();
            dbconn.setSQL("SELECT * FROM student INNER JOIN member ON student.ssn=member.ssn WHERE ssn = ?");
            dbconn.setString(1, pantherID);
            ResultSet rs = dbconn.executeQuery();
            if (rs != null && rs.next())
            {
                result = new Student(rs.getString("ssn"));

                result.setFirstName(rs.getString("firstname"));
                result.setLastName(rs.getString("lastname"));
                result.setPantherID(rs.getString("pantherID"));
            }
        }
        catch (SQLException e)
        {
            System.out.println("DatabaseInterface: sql exception");
            e.printStackTrace();
        }

        return result;
    }

    public Collection getStudents() {
        Vector result = new Vector();
        try
        {
            DatabaseConnection dbconn = DatabaseConnection.getInstance();
            dbconn.setSQL("SELECT * FROM student INNER JOIN member ON student.ssn=member.ssn");
            ResultSet rs = dbconn.executeQuery();
            Student tmp;
            while (rs.next())
            {
                tmp = new Student(rs.getString("ssn"));
                tmp.setFirstName(rs.getString("firstname"));
                tmp.setLastName(rs.getString("lastname"));
                tmp.setPantherID(rs.getString("pantherID"));
                result.addElement(tmp);
            }
        }
        catch (SQLException e)
        {
            System.out.println("DatabaseInterface: sql exception");
            e.printStackTrace();
        }

        return result;
    }

    public void createSchedule(Schedule s) {
        try
        {
            DatabaseConnection dbconn = DatabaseConnection.getInstance();

            dbconn.setSQL("INSERT INTO schedule(id, pantherID) VALUES(?, ?)");
            dbconn.setString(1, s.getId());
            dbconn.setString(2, s.getPantherID());

            dbconn.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void editStudent(Student s) {
        try
        {
            DatabaseConnection dbconn = DatabaseConnection.getInstance();

            dbconn.setSQL("UPDATE student SET pantherID=? WHERE ssn=?");
            dbconn.setString(1, s.getPantherID());
            dbconn.setString(2, s.getSSN());

            dbconn.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteStudent(Student s) {
        try
        {
            DatabaseConnection dbconn = DatabaseConnection.getInstance();

            dbconn.setSQL("DELETE FROM student WHERE ssn=?");
            dbconn.setString(1, s.getPantherID());

            dbconn.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public boolean isLoginValid(String pantherID, String password) {
        try
        {
            UniversityConnection dbconn = UniversityConnection.getInstance();

            dbconn.setSQL("SELECT * FROM student WHERE pantherID=? AND password=?");
            dbconn.setString(1, pantherID);
            dbconn.setString(2, password);

            ResultSet rs = dbconn.executeQuery();
            int count = 0;
            if (rs.next())
                count++;
            if(count > 0)
                return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

}
