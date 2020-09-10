package net.mike.notepad.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ModelsAccounts<K, T> {
    private static ModelsAccounts instance;
    private HashMap<K, T> accountList;

    private ModelsAccounts() {
        accountList =  new HashMap<>();
    }

    public static ModelsAccounts getInstance() {
        if (instance == null) {
            instance = new ModelsAccounts();
        }
        return instance;
    }

    public HashMap<K, T> getList() {
        return accountList;
    }
}
