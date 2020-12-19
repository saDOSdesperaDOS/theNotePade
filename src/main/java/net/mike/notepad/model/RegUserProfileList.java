package net.mike.notepad.model;

import net.mike.notepad.entyties.UserProfile;

import java.util.HashMap;

public class RegUserProfileList {
    private static HashMap<Long, UserProfile> instance;

    private RegUserProfileList() {
        instance =  new HashMap<Long, UserProfile>();
    }

    public static HashMap<Long, UserProfile> getInstance() {
        if (instance == null) {
            RegUserProfileList regUserProfileList = new RegUserProfileList();
        }
        return instance;
    }
}
