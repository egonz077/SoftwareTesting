package ApplicationLogic;

import Storage.DatabaseInterface;

/**
 * Created by IntelliJ IDEA.
 * User: alain
 * Date: Nov 8, 2006
 * Time: 6:29:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Authentication
{
    public void createSession()
    {}

    public void closeSession(String sessionID)
    {}

    public boolean isLoginValid(String pantherID, String password) {
        DatabaseInterface dbi = new DatabaseInterface();
        return dbi.isLoginValid(pantherID, password);
    }
    
}
