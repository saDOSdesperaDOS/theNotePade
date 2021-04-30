import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.services.UserService;
import org.junit.*;

import java.util.logging.Logger;

public class UserServiceTest {
    @Test
    public static void addUserTest(String login, String password) {
        long userId = new UserService().addUser(login, password);
        if (userId == 0 ) {
            Logger.getGlobal().warning("UserService#addUser - test failed");
            return;
        }
        Logger.getGlobal().info("UserService#addUser - test pass. userId: " + userId + " ,login: " + login + " ,password: " + password );
    }
    @Test
    public static void addNoteTest(long userId, String tittle, String textArea) {
        UserService userService = new UserService();
        userService.addUser("admin", "admin123");
        userService.addNote(userId, tittle, textArea);


    }

}
