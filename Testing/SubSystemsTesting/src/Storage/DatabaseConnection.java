package Storage;

import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 * User: Alain Esteva Ramirez
 * Date: Nov 13, 2006
 * Time: 5:28:19 PM
 */
public class DatabaseConnection {
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

    public static DatabaseConnection getInstance() throws SQLException{
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
