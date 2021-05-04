package net.mike.notepad.dbase.services;

import net.mike.notepad.dbase.dao.UserDao;
import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.entyties.UserDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;

public class UserService {

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

    public boolean isRegistered(String login) throws HibernateException {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            UserDao dao = new UserDao(session);
            dao.getId(login);
        } catch (NoResultException e) {
            return false;
        } finally {
            transaction.commit();
            session.close();
        }
        return true;
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
        session.close();
    }

    public void removeNote(long userId, NoteDataSet note) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        UserDao userDao = new UserDao(session);
        Transaction tx = session.beginTransaction();
        userDao.removeNote(userId, note);
        tx.commit();
        session.close();
    }


}
