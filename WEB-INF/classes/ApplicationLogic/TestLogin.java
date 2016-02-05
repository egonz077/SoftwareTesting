package ApplicationLogic;

/**
 * Created by IntelliJ IDEA.
 * User: Team2 ScheduleMaker
 * Date: Dec 3, 2006
 * Time: 12:17:03 AM
 */
public class TestLogin {
    public static void main(String[] args) {
    String login = "1412412";
    String password = "abc123";
    Authentication smc = new Authentication();
    if (smc.isLoginValid(login, password))
    {
        // Valid login
        System.out.println("Valid login");
    }
    else
    {
        // Invalid login
        System.out.println("Invalid login");
    }
    }
}
