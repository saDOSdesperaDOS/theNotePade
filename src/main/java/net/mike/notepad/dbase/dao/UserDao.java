package net.mike.notepad.dbase.dao;

import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.entyties.UserDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserDao implements InitDao {
    private Session session;

    public UserDao(Session session) {
        this.session = session;
    }

    @Override
    public long insert(String login, String password) throws HibernateException {
        return (long) session.save(new UserDataSet(login, password));
    }
    @Override
    public UserDataSet get(long id) throws HibernateException {
        return session.get(UserDataSet.class, id);
    }
   @Override
    //вернет -1 если такого пользователя нет в базе
    public long getId(String login) throws NoResultException {
        try {
            TypedQuery<UserDataSet> query = session.createQuery("select i from UserDataSet i where i.login = :login").setParameter("login", login);
            return query.getSingleResult().getId();
        } catch (NullPointerException e) {
            return -1;
        }
    }

    public boolean insertNote(long userId, NoteDataSet noteDataSet) {
           UserDataSet userDataSet = this.get(userId);;
          return userDataSet.getNotes().add(noteDataSet);
    }

    public boolean removeNote(long userId, NoteDataSet noteDataSet) {
        UserDataSet userDataSet = this.get(userId);
        return userDataSet.getNotes().remove(noteDataSet);
    }

    public void updateNote(long userId, NoteDataSet note, String newTittle, String newTextArea) {
        UserDataSet userDataSet = this.get(userId);
        int indexNote = userDataSet.getNotes().indexOf(note);
        NoteDataSet noteDataSet = userDataSet.getNotes().get(indexNote);
        noteDataSet.setTittle(newTittle);
        noteDataSet.setTextArea(newTextArea);
    }

    @Override
    public List<UserDataSet> getList() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserDataSet> criteria = builder.createQuery(UserDataSet.class);
        criteria.from(UserDataSet.class);
        return session.createQuery(criteria).getResultList();

    }
}
