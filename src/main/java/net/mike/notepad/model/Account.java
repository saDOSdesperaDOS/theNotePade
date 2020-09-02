package net.mike.notepad.model;

import java.util.List;

public class Account {

    private List<Note> noteList;
    private int id;
    private String email;
    private String pass;

    public Account(String email, String pass) {
        this.email = email;
        this.pass = pass;
        id++;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    
}
