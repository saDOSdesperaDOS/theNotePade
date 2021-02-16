import net.mike.notepad.entyties.Account;
import net.mike.notepad.entyties.Note;
import net.mike.notepad.entyties.UserProfile;
import net.mike.notepad.services.NotesService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainTest {
    public static void main(String... args) {
       UserProfile userProfile = new UserProfile(123, "email", "password");
       Account account = new Account(123, userProfile);
       Note note = new Note();
       Note note1 = new Note();
       //note.setDate();

        System.out.println(note.getDate());
        System.out.println(note.getDate());
    }
}
