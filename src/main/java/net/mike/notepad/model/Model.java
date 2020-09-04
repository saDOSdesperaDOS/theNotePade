package net.mike.notepad.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Model<T> {
    private static Model instance;
    private Set<T> accountList;

    public Model() {
        accountList = new HashSet<>();
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public Set<T> getList() {
        return accountList;
    }
}
