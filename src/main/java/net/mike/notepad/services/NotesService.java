package net.mike.notepad.services;

import com.vaadin.flow.component.notification.Notification;
import net.mike.notepad.entyties.Account;
import net.mike.notepad.entyties.NoteDataSet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class NotesService {

    private Account account;
    private Integer noteId;
   // private List<Note>  notesList;


    public NotesService(Account account) {
        this.account = account;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<NoteDataSet> getNotesList() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<NoteDataSet> criteria = builder.createQuery(NoteDataSet.class);
        criteria.from(NoteDataSet.class);
        List<NoteDataSet> notesList = session.createQuery(criteria).getResultList();
        tx.commit();
        session.close();
        return notesList;
    }

    public Serializable saveNote(NoteDataSet noteDataSet) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(noteDataSet);
        tx.commit();
        session.close();
        return true;
    }

    public NoteDataSet find(Integer id) {
        return this.getNotesList()
                .stream()
                .filter(entity -> entity.getId() == id)
                .findFirst().get();
    }

    public void removeNote(NoteDataSet a) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(a);
        tx.commit();
        session.close();
        Notification.show("note deleted");
    }

    public void updateNote(NoteDataSet a, String tittle, String textArrea) {
        a.setTittle(tittle);
        a.setTextArea(textArrea);
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(a);
        tx.commit();
        session.close();
    }
}
