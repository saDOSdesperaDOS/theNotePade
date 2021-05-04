import net.mike.notepad.dbase.services.DBService;
import net.mike.notepad.dbase.services.UserService;

public class MainTest {
    public static void main(String... args) {
        DBService.setHibernate_hbm2ddl_auto("update");
        UserService userService = new UserService();
        long id = userService.addUser("login2", "password2");
        userService.addNote(1, "tittle 2", "textAre2");
    }


}
