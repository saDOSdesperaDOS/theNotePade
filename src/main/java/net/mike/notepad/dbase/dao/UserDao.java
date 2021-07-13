package net.mike.notepad.dbase.dao;

import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.entyties.UserDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserDao {
    private final Session session;

    public UserDao(Session session) {
        this.session = session;
    }


    public long insert(String login, String password, String role, String sessionId) throws HibernateException {
        return (long) session.save(new UserDataSet(login, password, role, sessionId));
    }

    public UserDataSet get(long id) throws HibernateException {
        return session.get(UserDataSet.class, id);
    }

    //вернет -1 если такого пользователя нет в базе
    public long getId(String email) throws NoResultException {
        try {
            TypedQuery<UserDataSet> query = session.createQuery("select i from UserDataSet i where i.email = :email").setParameter("email", email);
            return query.getSingleResult().getId();
        } catch (NullPointerException e) {
            return -1;
        }
    }

    public boolean insertNote(long userId, NoteDataSet noteDataSet) {
           UserDataSet userDataSet = this.get(userId);
           String dateStr = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss").format(LocalDateTime.now());
           noteDataSet.setDate(dateStr);
            return userDataSet.getNotes().add(noteDataSet);
    }

    public boolean removeNote(long userId, NoteDataSet noteDataSet) {
        UserDataSet userDataSet = this.get(userId);
        return userDataSet.getNotes().remove(noteDataSet);
    }

    public void updateNote(long userId, NoteDataSet note, String newTittle, String newTextArea) {
        UserDataSet userDataSet = this.get(userId);
        NoteDataSet noteDataSet = userDataSet.getNotes().get(userDataSet.getNotes().indexOf(note));
        noteDataSet.setTittle(newTittle);
        noteDataSet.setTextArea(newTextArea);
    }


    public List<UserDataSet> getList() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserDataSet> criteria = builder.createQuery(UserDataSet.class);
        criteria.from(UserDataSet.class);
        return session.createQuery(criteria).getResultList();
    }

    public List<NoteDataSet> getNotesList(long userId) {
        UserDataSet user = this.get(userId);
        return user.getNotes();
    }
}
