package net.mike.notepad.dbase.utils;

import net.mike.notepad.dbase.services.DBService;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Executor<T> {
    DBService dbService;
    public void getSession(T service) {

        Transaction tx = dbService.getSessionFactory().openSession().beginTransaction();
    }
}
