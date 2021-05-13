import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.entyties.UserDataSet;
import net.mike.notepad.dbase.services.DBService;
import net.mike.notepad.dbase.services.UserService;
import org.junit.*;

public class UserServiceTest {
    @Test
    public void addUserTest() {
       assert  new UserService().addUser("login1", "password1") == 1;
    }
    @Test
    public void isRregisteredTest() {
        assert new UserService().isRegistered("login1") == true;
        assert new UserService().isRegistered("login") == false;

    }
    @Test
    public void getUserTest() {
        UserDataSet user = new UserService().getUser(1);
        assert user.getEmail().equals("login1");
    }
    @Test
    public void getUserIdTest() {
        assert new UserService().getUserId("login1") == 1;
    }

    @Test
    public void updateNoteTest() {
        DBService.setHibernate_hbm2ddl_auto("update");
        UserService userService = new UserService();
        long id = userService.addUser("logmike2@gmail.com", "qwerty");
        userService.addNote(id,"tittleTest2", "textAreaTExt2");
        userService.updateNote(id, userService.getNote(id, "tittleTest2"), "update3", "updateText3");
         assert userService.getNote(id, "update3").getTittle().equals("update3");
    }
}
