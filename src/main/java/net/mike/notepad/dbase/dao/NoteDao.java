package net.mike.notepad.dbase.dao;

import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.entyties.UserDataSet;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
            Criteria criteria = session.createCriteria(NoteDataSet.class);
            return ((NoteDataSet) criteria.add(Restrictions.eq("tittle", tittle)).uniqueResult()).getId();
        } catch (NullPointerException e) {
            return new NoteDataSet(tittle).getId();
        }
    }

    @Override
    public long insert(String login, String password) {
        return 0;
    }
}
