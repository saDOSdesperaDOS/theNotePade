package net.mike.notepad.dbase.services;

import net.mike.notepad.dbase.dao.UserDao;
import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.entyties.UserDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;

public class UserService {
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
//не работает!!!!!!!!!!
    public long getUserId(String login) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        UserDao userDao = new UserDao(session);
        long userId = userDao.getId(login);
        tx.commit();
        session.close();
        return userId;
    }

    public long addUser(String login, String password) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserDao dao = new UserDao(session);
        long id = dao.insert(login, password);
        transaction.commit();
        session.close();
        return id;
    }

    public boolean isRegistered(String login) throws HibernateException, ConstraintViolationException {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            UserDao dao = new UserDao(session);
            dao.getId(login);

        } catch (ConstraintViolationException e) {
            return false;
        } finally {
            transaction.commit();
            session.close();
        }
        return true;
    }

    public void addNote(long userId, String tittle, String textArea) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        NoteDataSet noteDataSet = new NoteDataSet(tittle, textArea);
        UserDao userDao = new UserDao(session);
        Transaction tx = session.beginTransaction();
        userDao.addNote(userId, noteDataSet);
        tx.commit();
        session.close();
    }
}
