import net.mike.notepad.dbase.dao.NoteDao;
import net.mike.notepad.dbase.dao.UserDao;
import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.services.DBService;
import net.mike.notepad.dbase.services.UserService;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainTest {
    public static void main(String... args) {
        DBService.setHibernate_hbm2ddl_auto("update");
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        UserDao userDao = new UserDao(session);
        //userDao.insert("mike1", "qwerty");
        NoteDataSet note = new NoteDataSet("first tittle", "first textare");
        NoteDataSet note1 = new NoteDataSet("second tittle", "second textare");
        NoteDataSet note2 = new NoteDataSet("3 tittle", "3 textare");
        /*userDao.insertNote(1, note);
        userDao.insertNote(1, note1);
        userDao.insertNote(1, note2);*/
        userDao.updateNote(1, note2, "threetin tittle", "thritintextare");
        tx.commit();
        session.close();
    }


}
