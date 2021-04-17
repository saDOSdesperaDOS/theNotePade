package net.mike.notepad.dbase.services;

import com.vaadin.flow.component.notification.Notification;
import net.mike.notepad.dbase.entyties.Account;
import net.mike.notepad.dbase.entyties.NoteDataSet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class NotesService {

    private Integer noteId;
   // private List<Note>  notesList;


    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public List<NoteDataSet> getNotesList() {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
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
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
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
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(a);
        tx.commit();
        session.close();
    }

    public void updateNote(NoteDataSet a, String tittle, String textArrea) {
        a.setTittle(tittle);
        a.setTextArea(textArrea);
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(a);
        tx.commit();
        session.close();
    }
}
