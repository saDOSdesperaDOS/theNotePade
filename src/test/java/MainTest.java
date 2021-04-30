import net.mike.notepad.dbase.dao.UserDao;
import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.entyties.UserDataSet;
import net.mike.notepad.dbase.services.DBService;
import net.mike.notepad.dbase.services.UserService;

public class MainTest {
    public static void main(String... args) {
        //UserServiceTest.addUserTest("admin", "admin123");
        UserService userService = new UserService();
        //userService.addUser("login1", "password1");
        System.out.println(userService.getUserId("login1"));

    }


}
