package net.mike.notepad.model.etyties;

import java.util.ArrayList;
import java.util.List;

public class Account {

   // private int id;//у каждого экземпляра id == 0
    private int id;
    private UserProfile userProfile;
    private List<Note>  notesList;

    public Account(int id, UserProfile userProfile) {
        this.id = id;
        this.userProfile = userProfile;
        notesList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public List<Note> getNotesList() {
        return notesList;
    }

    public void setNotesList(List<Note> notesList) {
        this.notesList = notesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (!userProfile.equals(account.userProfile)) return false;
        return notesList.equals(account.notesList);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userProfile.hashCode();
        result = 31 * result + notesList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userProfile=" + userProfile +
                ", notesList=" + notesList +
                '}';
    }
}
