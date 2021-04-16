import net.mike.notepad.dbase.entyties.Account;
import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.entyties.UserDataSet;
import net.mike.notepad.dbase.services.NotesService;

public class MainTest {
    public static void main(String... args) {
      //saveServiceTest(); ok
        //updateServiceTest(); ok
        //removeServiceTest(); ok




    }

    static void saveServiceTest() {
        UserDataSet userDataSet = new UserDataSet(123, "email", "password");
        Account account = new Account(123, userDataSet);
        NoteDataSet noteDataSet = new NoteDataSet();
        noteDataSet.setTittle("333333333333");
        noteDataSet.setTextArea("aaaaaaaaaaaaaaaaaa");
        //note.setDate();
        NotesService service = new NotesService(account);
        //test save service
        System.out.println(service.getNotesList().size());
        service.saveNote(noteDataSet);
        System.out.println(service.getNotesList().size());
    }

    static void updateServiceTest() {
        UserDataSet userDataSet = new UserDataSet(123, "email", "password");
        Account account = new Account(123, userDataSet);
        NotesService service = new NotesService(account);
        NoteDataSet noteDataSet = service.getNotesList().get(service.getNotesList().size() - 1);
        //test update service
        System.out.println("old tittle - " + noteDataSet.getTittle());
        System.out.println("old textarea - " + noteDataSet.getTextArea());
        service.updateNote(noteDataSet, "2222222222", "bbbbbbbbbbbb");
        System.out.println("new tittle - " + noteDataSet.getTittle());
        System.out.println("new textarea - " + noteDataSet.getTittle());
    }

    static void removeServiceTest() {
        UserDataSet userDataSet = new UserDataSet(123, "email", "password");
        Account account = new Account(123, userDataSet);
        NotesService service = new NotesService(account);
        NoteDataSet noteDataSet = service.getNotesList().get(service.getNotesList().size() - 1);
        System.out.println(service.getNotesList().size());
        service.removeNote(noteDataSet);
        System.out.println(service.getNotesList().size());
    }


}
