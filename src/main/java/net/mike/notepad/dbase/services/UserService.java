package net.mike.notepad.dbase.services;

import net.mike.notepad.dbase.dao.NoteDao;
import net.mike.notepad.dbase.dao.UserDao;
import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.entyties.UserDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

public class UserService {
    public List<UserDataSet> getUsersList() {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        UserDao userDao = new UserDao(session);
        Transaction tx = session.beginTransaction();
        List<UserDataSet> notesList = userDao.getList();
        tx.commit();
        session.close();
        return notesList;
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

    public boolean isRegistered(String email) throws HibernateException {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            UserDao dao = new UserDao(session);
            dao.getId(email);
        } catch (ConstraintViolationException e) {
            return false;
        } finally {
            transaction.commit();
            session.close();
        }
        return true;
    }
}
