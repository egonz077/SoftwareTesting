package pack;

/**
 * Created by IntelliJ IDEA.
 * User: alain
 * Date: Dec 2, 2006
 * Time: 3:18:20 PM
 */
public class UserData {

    String username;
    String email;
    int age;

    public void setUsername( String value )
    {
        username = value;
    }

    public void setEmail( String value )
    {
        email = value;
    }

    public void setAge( int value )
    {
        age = value;
    }

    public String getUsername() { return username; }

    public String getEmail() { return email; }

    public int getAge() { return age; }

}
