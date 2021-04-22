import net.mike.notepad.dbase.dao.NoteDao;
import net.mike.notepad.dbase.services.DBService;
import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.services.NotesService;
import net.mike.notepad.dbase.services.UserService;
import net.mike.notepad.view.EmailCheckView;
import org.hibernate.Session;

public class MainTest {
    public static void main(String... args) {
        //DBServiceTest();
        //getNoteListTest();
        //saveServiceTest();
      //updateServiceTest();
      //removeServiceTest();
        /*DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        NoteDao noteDao = new NoteDao(session);
        System.out.println(noteDao.getId("333333333333"));*/
        UserService userService = new UserService();
        //userService.addUser("bnfg@gmail.com", "pas1234");
       // userService.addUser("drgv@ewrg.com", "erhrrth");
        //userService.addUser("bms39rus@gmail.com", "erhfbhgtrrth");
        EmailCheckView checkView = new EmailCheckView();
        checkView.check("bms39rus@gmail.com");
        checkView.send("bms39rus@gmail.com");

    }

    static void DBServiceTest() {
        DBService dbService = new DBService();
        dbService.printConnectInfo();

    }

    static void getNoteListTest() {
        NoteDataSet noteDataSet = new NoteDataSet();
        noteDataSet.setTittle("333333333333");
        noteDataSet.setTextArea("aaaaaaaaaaaaaaaaaa");
        NotesService service = new NotesService();
        service.saveNote(noteDataSet);
        System.out.println(service.getNotesList().size());
    }

    static void saveServiceTest() {
        NoteDataSet noteDataSet = new NoteDataSet();
        noteDataSet.setTittle("333333333333");
        noteDataSet.setTextArea("aaaaaaaaaaaaaaaaaa");
        NotesService service = new NotesService();
        //test save service
        System.out.println(service.getNotesList().size());
        service.saveNote(noteDataSet);
        System.out.println(service.getNotesList().size());
    }

    static void updateServiceTest() {
        NotesService service = new NotesService();
        NoteDataSet noteDataSet = service.getNotesList().get(service.getNotesList().size() - 1);
        //test update service
        System.out.println("old tittle - " + noteDataSet.getTittle());
        System.out.println("old textarea - " + noteDataSet.getTextArea());
        service.updateNote(noteDataSet, "2222222222", "bbbbbbbbbbbb");
        System.out.println("new tittle - " + noteDataSet.getTittle());
        System.out.println("new textarea - " + noteDataSet.getTittle());
    }

    static void removeServiceTest() {
        NotesService service = new NotesService();
        NoteDataSet noteDataSet = service.getNotesList().get(service.getNotesList().size() - 1);
        System.out.println(service.getNotesList().size());
        service.removeNote(noteDataSet);
        System.out.println(service.getNotesList().size());
    }


}
