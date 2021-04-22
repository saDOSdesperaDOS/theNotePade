package net.mike.notepad.dbase.services;

import net.mike.notepad.dbase.dao.NoteDao;
import net.mike.notepad.dbase.entyties.NoteDataSet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class NotesService {

    private long noteId;
   // private List<Note>  notesList;


    public long getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public List<NoteDataSet> getNotesList() {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        NoteDao noteDao = new NoteDao(session);
        Transaction tx = session.beginTransaction();
        List<NoteDataSet> notesList = noteDao.getList();
        tx.commit();
        session.close();
        return notesList;
    }

    public Serializable saveNote(NoteDataSet noteDataSet) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        NoteDao noteDao = new NoteDao(session);
        Transaction tx = session.beginTransaction();
        noteDao.insert(noteDataSet);
        tx.commit();
        session.close();
        return true;
    }

    public NoteDataSet find(long id) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        NoteDao noteDao = new NoteDao(session);
        Transaction tx = session.beginTransaction();
        NoteDataSet noteDataSet = noteDao.find(id);
        tx.commit();
        session.close();
        return noteDataSet;
    }

    public void removeNote(NoteDataSet a) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        NoteDao noteDao = new NoteDao(session);
        Transaction tx = session.beginTransaction();
        noteDao.remove(a);
        tx.commit();
        session.close();
    }

    public void updateNote(NoteDataSet a, String tittle, String textArrea) {
        DBService dbService = new DBService();
        Session session = dbService.getSessionFactory().openSession();
        NoteDao noteDao = new NoteDao(session);
        Transaction tx = session.beginTransaction();
        noteDao.updateNote(a, tittle, textArrea);
        tx.commit();
        session.close();
    }
}
