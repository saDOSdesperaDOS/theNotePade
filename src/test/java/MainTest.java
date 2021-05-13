import net.mike.notepad.dbase.dao.NoteDao;
import net.mike.notepad.dbase.dao.UserDao;
import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.services.DBService;
import net.mike.notepad.dbase.services.UserService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String... args) {
        /*DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        UserDao userDao = new UserDao(session);
        userDao.insert("mike1", "qwerty");
       UserServiceTest userServiceTest = new UserServiceTest();
        DBService.setHibernate_hbm2ddl_auto("create");
        NoteDataSet note = new NoteDataSet("first tittle", "first textare");
        NoteDataSet note1 = new NoteDataSet("second tittle", "second textare");
        NoteDataSet note2 = new NoteDataSet("3 tittle", "3 textare");*/
        /*userDao.insertNote(1, note);
        userDao.insertNote(1, note1);
        userDao.insertNote(1, note2);*/
        /*userDao.updateNote(1, note2, "threetin tittle", "thritintextare");
        tx.commit();
        session.close();*/
        //userServiceTest.updateNoteTest();
        /*NoteDataSet noteDataSet = new NoteDataSet("t1", "text");
        NoteDataSet n4 = new NoteDataSet("t1");
        List<NoteDataSet> list = new ArrayList<>();
        list.add(note);
        list.add(note1);
        list.add(note2);
        list.add(noteDataSet);
        System.out.println(list.indexOf(n4));*/
        UserService userService = new UserService();
        //userService.addUser("mike@login.com", "pass1");
        System.out.println(userService.getUser(1).getEmail());
        //userService.addNote(1, "tittle", "textarea");
        System.out.println(userService.getNotesList(1).size());
        /*userService.getNotesList(1).add(new NoteDataSet("tittle", "textArea"));
        System.out.println(userService.getNotesList(1).size());*/

    }


}
