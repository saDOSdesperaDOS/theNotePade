package net.mike.notepad.model;

import java.util.ArrayList;
import java.util.List;

public class Model<T> {
    private static Model instance;
    private List<T> accountList;

    public Model() {
        accountList = new ArrayList<T>();
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public List<T> getList() {
        return accountList;
    }
}
