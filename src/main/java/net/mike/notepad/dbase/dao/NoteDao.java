package net.mike.notepad.dbase.dao;

import net.mike.notepad.dbase.entyties.NoteDataSet;
import org.hibernate.Session;

import javax.persistence.TypedQuery;

public class NoteDao implements InitDao {
    private Session session;
    public NoteDao(Session session) {this.session = session;}
    @Override
    public NoteDataSet get(long id) {
        return session.get(NoteDataSet.class, id);
    }

    @Override
    public long getId(String tittle) {
        try {
            TypedQuery<NoteDataSet> query = session.createQuery("select i from NoteDataSet i where i.tittle = :tittle").setParameter("tittle", tittle);
            return query.getSingleResult().getId();
        } catch (NullPointerException e) {
            return -1;
        }
    }

    @Override
    public long insert(String login, String password) {
        return 0;
    }
}
