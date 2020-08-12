package net.mike.notepad.entyties;

import java.util.List;

public class Account {

    private User user;
    private List<Note> noteList;

    public Account(User user) {
        this.user = user;
    }
}
