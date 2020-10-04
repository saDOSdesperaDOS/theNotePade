package net.mike.notepad;

import net.mike.notepad.controller.services.NotesService;
import net.mike.notepad.model.etyties.Account;
import net.mike.notepad.model.etyties.Note;
import net.mike.notepad.model.etyties.UserProfile;

public class Main {
    public static void main(String... args) {
        System.out.println("Start");
        UserProfile userProfile = new UserProfile(1, "aaa", "bbb");
        Account account = new Account(userProfile.getId(), userProfile);
        Note note = new Note(1,"first note", "this is textarea first note");
        Note note1 = new Note(2,"first note", "this is textarea first note");
        Note note2 = new Note(3,"first note", "this is textarea first note");
        Note note3 = new Note(4,"first note", "this is textarea first note");
        NotesService notesService = new NotesService(account);
        notesService.saveNote(note);
        notesService.saveNote(note1);
        notesService.saveNote(note2);
        notesService.saveNote(note3);
        System.out.println(notesService.getAccount().getNotesList().size());
        System.out.println(account.getNotesList().size());

    }
}
