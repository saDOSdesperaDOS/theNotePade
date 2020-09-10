package net.mike.notepad.model;

import java.util.HashMap;

public class ModelsAccounts<T> {
    private static HashMap<Long, Account> instance;

    private ModelsAccounts() {
        instance =  new HashMap<>();
    }

    public static HashMap<Long, Account> getInstance() {
        if (instance == null) {
            ModelsAccounts modelsAccounts = new ModelsAccounts();
        }
        return instance;
    }
}
