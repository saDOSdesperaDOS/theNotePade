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

        List<Note> noteList = service.getAccount().getNotesList();
        Note note = noteList.get(0);
        System.out.println(note.getTittle());
        service.updateNote(noteList.get(0), "andere tittle");
        System.out.println(noteList.get(0).getTittle());
        System.out.println(note.hashCode() == noteList.get(0).hashCode());
        System.out.println(note.getTittle().equals(noteList.get(0).getTittle()));
    }
}
