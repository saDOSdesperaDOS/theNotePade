package net.mike.notepad.dbase.dao;

import java.util.List;

public interface InitDao<T> {
    T get(long id);
    long getId(String param);
    long insert(String param1, String param2);
    List<T> getList();

}
