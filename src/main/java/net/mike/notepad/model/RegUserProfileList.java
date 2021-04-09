package net.mike.notepad.model;

import net.mike.notepad.entyties.UserProfileDataSet;

import java.util.HashMap;

public class RegUserProfileList {
    private static HashMap<Long, UserProfileDataSet> instance;

    private RegUserProfileList() {
        instance =  new HashMap<Long, UserProfileDataSet>();
    }

    public static HashMap<Long, UserProfileDataSet> getInstance() {
        if (instance == null) {
            RegUserProfileList regUserProfileList = new RegUserProfileList();
        }
        return instance;
    }
}
