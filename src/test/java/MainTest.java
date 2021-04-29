import net.mike.notepad.dbase.services.UserService;
import org.junit.*;

public class MainTest {
    public static void main(String... args) {
        UserService userService = new UserService();
        System.out.println(userService.addUser("login1", "password"));
        System.out.println(userService.getUserId("login1"));



    }
}
