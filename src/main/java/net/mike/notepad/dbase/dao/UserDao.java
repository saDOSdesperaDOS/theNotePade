package net.mike.notepad.dbase.dao;

import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.entyties.UserDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
    public long getId(String email) {
        try {
            TypedQuery<NoteDataSet> query = session.createQuery("select i from UserDataSet i where i.email = :email").setParameter("email", email);
            return query.getSingleResult().getId();
        } catch (NullPointerException e) {
            return -1;
        }
    }
    @Override
    public long insert(String email, String password) throws HibernateException {
        return (long) session.save(new UserDataSet(email, password));
    }
    @Override
    public List<UserDataSet> getList() {
        return null;
    }
}
