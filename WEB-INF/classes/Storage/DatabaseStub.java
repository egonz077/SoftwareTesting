package Storage;

import ApplicationLogic.ClassDetails;
import ApplicationLogic.Time;

import java.sql.*;
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

    public static class Course {

        public String subject;
        public String description;
        public String catlgNbr;
        public int units;

        public ClassDetails getClassesBySubject(String subject) {
            return null;
        }

        public Course(String subject, String catlgNbr) {
            this.subject = subject;
            this.catlgNbr = catlgNbr;
        }

        public Collection<ClassDetails> getClasses() {
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

        public ClassDetails getClasses(int units) {
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
         *
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
                if (!campus.isEmpty()) {
                    sql += "( campus=? ";
                    for (int i = 1; i < campus.size(); i++) {
                        sql += " OR campus=?";
                    }
                    sql += ")";
                }

                dbconn.setSQL(sql);
                dbconn.setString(1, subject);
                dbconn.setString(2, catlgNbr);
                dbconn.setString(3, term);

                for (int i = 0; i < campus.size(); i++) {
                    dbconn.setString(i + 4, (String) ((ArrayList) campus).get(i));
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

    /**
     * Created by IntelliJ IDEA.
     * User: Alain Esteva Ramirez
     * Date: Nov 13, 2006
     * Time: 5:28:19 PM
     */
    public static class DatabaseConnection {
        private static DatabaseConnection dbconn;
        private PreparedStatement pst;
        private Connection connection;

        private DatabaseConnection() {
            pst = null;
            String connectionURL = "jdbc:mysql://localhost:3306/schedule_maker?user=root&password=1234";
            //need to register the driver
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                //establishing the Connection...
                connection = DriverManager.getConnection(connectionURL);

            } catch (SQLException e) {
                System.out.println("DatabaseConnection: sqlexception");
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                System.out.println("DatabaseConnection: illegal access exception");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("DatabaseConnection: class not found exception");
                e.printStackTrace();
            } catch (InstantiationException e) {
                System.out.println("DatabaseConnection: instantiation exception");
                e.printStackTrace();
            }
        }

        public static DatabaseConnection getInstance() throws SQLException {
            if (dbconn == null)
                dbconn = new DatabaseConnection();
            return dbconn;
        }

        public PreparedStatement setSQL(String sql) throws SQLException {
            try {
                pst = connection.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return pst;
        }

        public void closeConnection() {
            try {
                if (pst != null)
                    pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void setInt(int index, int value) throws SQLException {
            pst.setInt(index, value);
        }

        public int getInt(int index) throws SQLException {
            return ((CallableStatement) pst).getInt(index);
        }

        public void setString(int index, String value) throws SQLException {
            pst.setString(index, value);
        }

        public String getString(int index) throws SQLException {
            return ((CallableStatement) pst).getString(index);
        }

        public ResultSet executeQuery() throws SQLException {
            ResultSet rset = pst.executeQuery();
            return (rset);
        }

        public int executeUpdate() throws SQLException {
            return (pst.executeUpdate());
        }

        public boolean execute() throws SQLException {
            return (pst.execute());
        }


    }

    /**
     * Created by IntelliJ IDEA.
     * User: Alain Esteva Ramirez
     * Date: Nov 13, 2006
     * Time: 5:28:19 PM
     */
    public static class UniversityConnection {
        private static UniversityConnection dbconn;
        private PreparedStatement pst;
        private Connection connection;

        private UniversityConnection() {
            pst = null;
            String connectionURL = "jdbc:mysql://localhost:3306/univdb?user=root&password=1234";
            //need to register the driver
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                //establishing the Connection...
                connection = DriverManager.getConnection(connectionURL);

            } catch (SQLException e) {
                System.out.println("UniversityConnection: sqlexception");
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                System.out.println("UniversityConnection: illegal access exception");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("UniversityConnection: class not found exception");
                e.printStackTrace();
            } catch (InstantiationException e) {
                System.out.println("UniversityConnection: instantiation exception");
                e.printStackTrace();
            }
        }

        public static UniversityConnection getInstance() throws SQLException {
            if (dbconn == null)
                dbconn = new UniversityConnection();
            return dbconn;
        }

        public PreparedStatement setSQL(String sql) throws SQLException {
            try {
                pst = connection.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return pst;
        }

        public void closeConnection() {
            try {
                if (pst != null)
                    pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void setInt(int index, int value) throws SQLException {
            pst.setInt(index, value);
        }

        public int getInt(int index) throws SQLException {
            return ((CallableStatement) pst).getInt(index);
        }

        public void setString(int index, String value) throws SQLException {
            pst.setString(index, value);
        }

        public String getString(int index) throws SQLException {
            return ((CallableStatement) pst).getString(index);
        }

        public ResultSet executeQuery() throws SQLException {
            ResultSet rset = pst.executeQuery();
            return (rset);
        }

        public int executeUpdate() throws SQLException {
            return (pst.executeUpdate());
        }

        public boolean execute() throws SQLException {
            return (pst.execute());
        }


    }
}
