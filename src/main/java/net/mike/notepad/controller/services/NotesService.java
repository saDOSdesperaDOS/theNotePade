package net.mike.notepad.controller.services;

import net.mike.notepad.model.etyties.Account;
import net.mike.notepad.model.etyties.Note;

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
