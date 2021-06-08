package net.mike.notepad.dbase.dao;

import net.mike.notepad.dbase.entyties.NoteDataSet;

import java.io.Serializable;
import java.util.List;

public interface InitDao<T> {
    T get(long id);
    long getId(String param);
    long insert(String textArea, String tittle);
    List<T> getList();

}
