import net.mike.notepad.entyties.Account;
import net.mike.notepad.entyties.Note;
import net.mike.notepad.entyties.UserProfile;
import net.mike.notepad.services.NotesService;

import java.util.List;

public class MainTest {
    public static void main(String... args) {
        UserProfile userProfile = new UserProfile(123, "email", "password");
        Account account = new Account(123, userProfile);
        Note n = new Note("first test tittle", "textarea of first note");
        Note n1 = new Note( "first tittle", "textarrea of first note");
        Note n2 = new Note("second tittle", "textarrea of second note");
        Note n3 = new Note("threetin tittle", "textarrea of threetin note");
        NotesService service = new NotesService(account);
        service.saveNote(n);
        service.saveNote(n1);
        service.saveNote(n2);
        service.saveNote(n3);
        for (Note note : account.getNotesList()) {
            System.out.println(note.getId());
        }
        System.out.println(account.getNotesList().size());
        System.out.println(n3.getId());
        service.removeNote(n3);
        for (Note note : account.getNotesList()) {
            System.out.println(note.getId());
        }
        System.out.println(account.getNotesList().size());
    }
}
