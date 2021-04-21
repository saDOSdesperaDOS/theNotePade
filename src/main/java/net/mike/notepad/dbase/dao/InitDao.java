package net.mike.notepad.dbase.dao;

import java.io.Serializable;

public interface InitDao<T> {
    T get(long id);
    long getId(String login);
    long insert(String login, String password);

}
