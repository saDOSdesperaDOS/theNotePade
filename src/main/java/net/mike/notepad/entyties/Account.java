package net.mike.notepad.entyties;

import java.util.ArrayList;
import java.util.List;

public class Account {

   // private int id;//у каждого экземпляра id == 0
    private int id;
    private UserProfileDataSet userProfileDataSet;
    private List<NoteDataSet>  notesList;

    public Account(int id, UserProfileDataSet userProfileDataSet) {
        this.id = id;
        this.userProfileDataSet = userProfileDataSet;
        notesList = new ArrayList<>();
    }

    public Account(int id, UserProfileDataSet userProfileDataSet, List<NoteDataSet> notesList) {
        this.id = id;
        this.userProfileDataSet = userProfileDataSet;
        this.notesList = notesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserProfileDataSet getUserProfileDataSet() {
        return userProfileDataSet;
    }

    public void setUserProfileDataSet(UserProfileDataSet userProfileDataSet) {
        this.userProfileDataSet = userProfileDataSet;
    }

    public void setNotesList(List<NoteDataSet> notesList) {
        this.notesList = notesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (!userProfileDataSet.equals(account.userProfileDataSet)) return false;
        return notesList.equals(account.notesList);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userProfileDataSet.hashCode();
        result = 31 * result + notesList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userProfile=" + userProfileDataSet +
                ", notesList=" + notesList +
                '}';
    }
}
