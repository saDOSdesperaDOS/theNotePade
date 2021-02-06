package net.mike.notepad.services;

import net.mike.notepad.entyties.Account;
import net.mike.notepad.entyties.Note;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class NotesService {

    private Account account;
    private Integer noteId;
    private List<Note>  notesList;


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

    public List<Note> getNotesList() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Note> criteria = builder.createQuery(Note.class);
        criteria.from(Note.class);
        notesList = session.createQuery(criteria).getResultList();
        tx1.commit();
        session.close();
        return notesList;
    }

    public boolean saveNote(Note note) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(note);
        tx1.commit();
        session.close();
        return true;
    }

    public Note find(Integer id) {
        return this.getNotesList()
                .stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst().get();
    }

    public boolean removeNote(Note a) {
        this.getNotesList().remove(a);
        return true;
    }

    public boolean updateNote(Note a, String tittle, String textArrea) {
        a.setTextArea(textArrea);
        a.setTittle(tittle);
        return true;
    }
}
