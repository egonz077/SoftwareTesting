package Storage;

import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 * User: Alain Esteva Ramirez
 * Date: Nov 13, 2006
 * Time: 5:28:19 PM
 */
public class UniversityConnection {
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

    public static UniversityConnection getInstance() throws SQLException{
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

    public void setInt( int index, int value ) throws SQLException
    {
        pst.setInt( index, value );
    }

    public int getInt( int index ) throws SQLException
    {
        return ((CallableStatement)pst).getInt( index );
    }

    public void setString( int index, String value ) throws SQLException
    {
        pst.setString( index, value );
    }

    public String getString( int index ) throws SQLException
    {
        return ((CallableStatement)pst).getString( index );
    }

    public ResultSet executeQuery() throws SQLException
    {
        ResultSet rset = pst.executeQuery();
        return(rset);
    }

    public int executeUpdate() throws SQLException
    {
        return( pst.executeUpdate() );
    }

    public boolean execute() throws SQLException
    {
        return( pst.execute() );
    }


}
