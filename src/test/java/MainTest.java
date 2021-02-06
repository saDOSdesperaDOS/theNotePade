import net.mike.notepad.entyties.Account;
import net.mike.notepad.entyties.Note;
import net.mike.notepad.entyties.UserProfile;
import net.mike.notepad.services.HibernateSessionFactoryUtil;
import net.mike.notepad.services.NotesService;
import org.hibernate.Session;

import java.util.List;

public class MainTest {
    public static void main(String... args) {
       UserProfile userProfile = new UserProfile(123, "email", "password");
        Account account = new Account(123, userProfile);
        Note n = new Note(12, "4444 test tittle", "textarea of fife note");
        Note n1 = new Note(13,  "5 tittle", "textarrea of 6 note");
        Note n2 = new Note(14,"6 tittle", "textarrea of seven note");
       // Note n3 = new Note(15,"threetin tittle", "textarrea of threetin note");
       NotesService service = new NotesService(account);
       /* service.saveNote(n);
        service.saveNote(n1);
        service.saveNote(n2);*/
        //service.saveNote(n3);
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        System.out.println("Connect estabilished");

        List<Note> noteList = service.getNotesList();
        Note note = noteList.get(0);
        System.out.println(note.getTextArea().equals(service.find(12).getTextArea()));
        session.close();
        System.out.println("Connect eclose");
    }
}
