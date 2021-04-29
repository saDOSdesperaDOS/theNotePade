package net.mike.notepad.dbase.services;

import net.mike.notepad.dbase.dao.UserDao;
import net.mike.notepad.dbase.entyties.UserDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

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

    public long getUserId(String login) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        return new UserDao(session).getId(login);
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

    public long addNote(String tittle, String textArea) {
        return new NotesService().saveNote(tittle, textArea);
    }
}
