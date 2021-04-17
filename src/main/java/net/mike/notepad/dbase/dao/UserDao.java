package net.mike.notepad.dbase.dao;

import net.mike.notepad.dbase.entyties.UserDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
            Criteria criteria = session.createCriteria(UserDataSet.class);
            return ((UserDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult()).getId();
        } catch (NullPointerException e) {
            return new UserDataSet(login).getId();
        }
    }
    @Override
    public long insert(String login, String password) throws HibernateException {
        return (long) session.save(new UserDataSet(login, password));
    }
}
