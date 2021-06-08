package net.mike.notepad.dbase.services;

import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import net.mike.notepad.dbase.dao.UserDao;
import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.entyties.UserDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.util.List;

import java.util.List;

public class UserService {
<<<<<<< HEAD
    public List<UserDataSet> getUsersList() {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        UserDao userDao = new UserDao(session);
        Transaction tx = session.beginTransaction();
        List<UserDataSet> notesList = userDao.getList();
        tx.commit();
        session.close();
        return notesList;
=======

    public long addUser(String email, String password) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserDao dao = new UserDao(session);
        long id = dao.insert(email, password);
        transaction.commit();
        session.close();
        return id;
>>>>>>> emb
    }

    public UserDataSet getUser(long id) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        UserDataSet dataSet = null;
        try {
            UserDao dao = new UserDao(session);
            dataSet = dao.get(id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return dataSet;
    }
    public long getUserId(String email) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        UserDao userDao = new UserDao(session);
        long userId = userDao.getId(email);
        tx.commit();
        session.close();
        return userId;
    }

<<<<<<< HEAD
    public long getUserId(String email) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        return new UserDao(session).getId(email);
    }

    public long addUser(String email, String password) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserDao dao = new UserDao(session);
        long id = dao.insert(email, password);
        transaction.commit();
        session.close();
        return id;
    }

    public long addUser(UserDataSet userDataSet) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserDao dao = new UserDao(session);
        long id = dao.insert(userDataSet);
        transaction.commit();
=======
    public void addNote(long userId, String tittle, String textArea) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        NoteDataSet noteDataSet = new NoteDataSet(tittle, textArea);
        UserDao userDao = new UserDao(session);
        Transaction tx = session.beginTransaction();
        userDao.insertNote(userId, noteDataSet);
        tx.commit();
        session.close();
    }

    public void updateNote(long userId, NoteDataSet note, String newTittle, String newTextAre) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        UserDao userDao = new UserDao(session);
        Transaction tx = session.beginTransaction();
        userDao.updateNote(userId, note, newTittle, newTextAre);
        tx.commit();
>>>>>>> emb
        session.close();
    }

<<<<<<< HEAD
=======
    public void removeNote(long userId, NoteDataSet note) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        UserDao userDao = new UserDao(session);
        Transaction tx = session.beginTransaction();
        userDao.removeNote(userId, note);
        tx.commit();
        session.close();
    }

    public List<NoteDataSet> getNotesList(long userId) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        UserDao userDao = new UserDao(session);
        Transaction tx = session.beginTransaction();
        List<NoteDataSet> list = userDao.getNotesList(userId);
        tx.commit();
        session.close();
        return list;
    }

    public NoteDataSet getNote(long id, String tittle) {
        return  this.getNotesList(id).get(this.getNotesList(id).indexOf(new NoteDataSet(tittle)));
    }

>>>>>>> emb
    public boolean isRegistered(String email) throws HibernateException {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            UserDao dao = new UserDao(session);
<<<<<<< HEAD
            if(dao.getId(email) == -1) return false;
        } catch (ConstraintViolationException e) {
=======
            dao.getId(email);
        } catch (NoResultException e) {
>>>>>>> emb
            return false;
        } finally {
            transaction.commit();
            session.close();
        }
        return true;
    }

    public boolean isValid(String email, String password) {
        UserDataSet user = this.getUser(this.getUserId(email));
        if (password.equals(user.getPassword())) {
            return true;
        }
        return false;
    }
}
