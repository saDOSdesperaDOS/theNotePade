package net.mike.notepad.services;

import net.mike.notepad.entyties.Account;
import net.mike.notepad.entyties.Note;

public class NotesService {

    Account account;

    public NotesService(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }



    public boolean saveNote(Note a) {
        account.getNotesList().add(a);
        return true;
    }

    public boolean removeNote(Note a) {
        account.getNotesList().remove(a);
        return true;
    }

    public boolean updateNote(Note a) {
        return false;
    }

    public boolean crudNote(Note a) {
        return false;
    }
}
