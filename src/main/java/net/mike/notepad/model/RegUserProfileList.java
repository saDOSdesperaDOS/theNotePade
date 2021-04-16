package net.mike.notepad.model;

import net.mike.notepad.dbase.entyties.UserDataSet;

import java.util.HashMap;

public class RegUserProfileList {
    private static HashMap<Long, UserDataSet> instance;

    private RegUserProfileList() {
        instance =  new HashMap<Long, UserDataSet>();
    }

    public static HashMap<Long, UserDataSet> getInstance() {
        if (instance == null) {
            RegUserProfileList regUserProfileList = new RegUserProfileList();
        }
        return instance;
    }
}
