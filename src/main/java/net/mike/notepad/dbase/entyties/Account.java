package net.mike.notepad.dbase.entyties;

import java.util.ArrayList;
import java.util.List;

public class Account {

   // private int id;//у каждого экземпляра id == 0
    private int id;
    private UserDataSet userDataSet;
    private List<NoteDataSet>  notesList;

    public Account(int id, UserDataSet userDataSet) {
        this.id = id;
        this.userDataSet = userDataSet;
        notesList = new ArrayList<>();
    }

    public Account(int id, UserDataSet userDataSet, List<NoteDataSet> notesList) {
        this.id = id;
        this.userDataSet = userDataSet;
        this.notesList = notesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDataSet getUserDataSet() {
        return userDataSet;
    }

    public void setUserDataSet(UserDataSet userDataSet) {
        this.userDataSet = userDataSet;
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
        if (!userDataSet.equals(account.userDataSet)) return false;
        return notesList.equals(account.notesList);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userDataSet.hashCode();
        result = 31 * result + notesList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userProfile=" + userDataSet +
                ", notesList=" + notesList +
                '}';
    }
}
