import net.mike.notepad.entyties.Account;
import net.mike.notepad.entyties.NoteDataSet;
import net.mike.notepad.entyties.UserProfile;

public class MainTest {
    public static void main(String... args) {
       UserProfile userProfile = new UserProfile(123, "email", "password");
       Account account = new Account(123, userProfile);
       NoteDataSet noteDataSet = new NoteDataSet();
       NoteDataSet noteDataSet1 = new NoteDataSet();
       //note.setDate();

        System.out.println(noteDataSet.getDate());
        System.out.println(noteDataSet.getDate());
    }
}
