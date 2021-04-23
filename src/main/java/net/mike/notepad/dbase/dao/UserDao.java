package net.mike.notepad.dbase.dao;

import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.entyties.UserDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.logging.Logger;

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
            TypedQuery<UserDataSet> query = session.createQuery("select i from UserDataSet i where i.email = :email").setParameter("email", email);
            return query.getSingleResult().getId();
        } catch (NullPointerException e) {
            return -1;
        } catch (NoResultException e) {
            Logger.getGlobal().info("there is no such user");
            return  -1;
        }
    }
    @Override
    public long insert(String email, String password) throws HibernateException {
        return (long) session.save(new UserDataSet(email, password));
    }

    public long insert(UserDataSet userDataSet) throws HibernateException {
        return (long) session.save(userDataSet);
    }
    @Override
    public List<UserDataSet> getList() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserDataSet> criteria = builder.createQuery(UserDataSet.class);
        criteria.from(UserDataSet.class);
        return session.createQuery(criteria).getResultList();
    }
}
