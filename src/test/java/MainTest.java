import net.mike.notepad.entyties.Account;
import net.mike.notepad.entyties.Note;
import net.mike.notepad.entyties.UserProfile;
import net.mike.notepad.services.NotesService;

import java.util.List;

public class MainTest {
    public static void main(String... args) {
        UserProfile userProfile = new UserProfile(123, "email", "password");
        Account account = new Account(123, userProfile);
        Note n = new Note(12, "first test tittle", "textarea of first note");
        Note n1 = new Note(13,  "first tittle", "textarrea of first note");
        Note n2 = new Note(14,"second tittle", "textarrea of second note");
       // Note n3 = new Note(15,"threetin tittle", "textarrea of threetin note");
        NotesService service = new NotesService(account);
        service.saveNote(n);
        service.saveNote(n1);
        service.saveNote(n2);
        //service.saveNote(n3);

        List<Note> noteList = service.getAccount().getNotesList();
        Note note = noteList.get(0);
        System.out.println(note.getId());
    }
}
