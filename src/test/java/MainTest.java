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
        System.out.println(userDao.getId("mike1"));
        NoteDataSet note = new NoteDataSet("first tittle", "first textare");
        NoteDataSet note1 = new NoteDataSet("second tittle", "second textare");
        NoteDataSet note2 = new NoteDataSet("3 tittle", "3 textare");
        userDao.insertNote(6, note);
        userDao.insertNote(6, note1);
        userDao.insertNote(6, note2);
        userDao.updateNote(6, note2, "threetin tittle", "thritintextare");
        tx.commit();
        session.close();*/
        UserService service = new UserService();
        System.out.println(service.getNotesList(6).size());
    }


}
