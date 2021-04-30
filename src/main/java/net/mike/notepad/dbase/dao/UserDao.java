package net.mike.notepad.dbase.dao;

import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.entyties.UserDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.List;

public class UserDao implements InitDao {
    private Session session;

    public UserDao(Session session) {
        this.session = session;
    }
    @Override
    public UserDataSet get(long id) throws HibernateException {
        return session.get(UserDataSet.class, id);
    }
   @Override
    //вернет -1 если такого пользователя нет в базе
    public long getId(String login) {
        try {
            TypedQuery<UserDataSet> query = session.createQuery("select i from UserDataSet i where i.login = :login").setParameter("login", login);
            return query.getSingleResult().getId();
        } catch (NullPointerException e) {
            return -1;
        }
    }

    @Override
    public long insert(String login, String password) throws HibernateException {
        return (long) session.save(new UserDataSet(login, password));
    }

    public void addNote(long userId, NoteDataSet noteDataSet) {
           UserDataSet userDataSet = this.get(userId);;
           session.save(userDataSet.getLogin(), noteDataSet);
    }

    @Override
    public List<UserDataSet> getList() {
        return null;
    }
}
