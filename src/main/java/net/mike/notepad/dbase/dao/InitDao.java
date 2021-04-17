package net.mike.notepad.dbase.dao;

public interface InitDao<T> {
    T get(long id);
    long getId(String login);
    long insert(String login, String password);

}
