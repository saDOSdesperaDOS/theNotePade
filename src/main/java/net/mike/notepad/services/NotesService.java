package net.mike.notepad.services;

import net.mike.notepad.entyties.Account;
import net.mike.notepad.entyties.Note;

import java.util.List;
import java.util.Optional;

public class NotesService {

    private Account account;
    private Integer noteId;


    public NotesService(Account account) {
        this.account = account;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean saveNote(Note a) {
        this.account.getNotesList().add(a);
        return true;
    }

    public Note find(Integer id) {
        return account.getNotesList()
                .stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst().get();
    }

    public boolean removeNote(Note a) {
        this.account.getNotesList().remove(a);
        return true;
    }

    public boolean updateNote(Note a, String tittle, String textArrea) {
        a.setTextArea(textArrea);
        a.setTittle(tittle);
        return true;
    }
}
