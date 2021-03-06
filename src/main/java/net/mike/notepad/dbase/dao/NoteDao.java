package net.mike.notepad.dbase.dao;

import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.entyties.UserDataSet;
import net.mike.notepad.dbase.services.UserService;
import org.h2.engine.User;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class NoteDao {
    /*@Override
    //вернет -1 если такого пользователя нет в базе
    public long getId(String tittle) {
        try {
            TypedQuery<NoteDataSet> query = session.createQuery("select i from NoteDataSet i where i.tittle = :tittle").setParameter("tittle", tittle);
            return query.getSingleResult().getId();
        } catch (NullPointerException e) {
            return -1;
        }
    }*/

    /* public NoteDataSet find(long id) {
       return this.getList()
               .stream()
               .filter(entity -> entity.getId() == id)
               .findFirst().get();
   }*/
    private Session session;

    public NoteDao(Session session) {this.session = session;}

    public long getId(String param) {
        return 0;
    }

    public NoteDataSet get(long id) {
        return session.get(NoteDataSet.class, id);
    }

    public long insert(String tittle, String textArea) {
        NoteDataSet noteDataSet = new NoteDataSet(tittle, textArea);
        return (long) session.save(noteDataSet);
    }

    public List<NoteDataSet> getList() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<NoteDataSet> criteria = builder.createQuery(NoteDataSet.class);
        criteria.from(NoteDataSet.class);
        return session.createQuery(criteria).getResultList();
    }

    public void remove(NoteDataSet noteDataSet) {
        session.remove(noteDataSet);
    }

    public void updateNote(NoteDataSet a, String tittle, String textArrea) {
        a.setTittle(tittle);
        a.setTextArea(textArrea);
        session.update(a);
    }
}
