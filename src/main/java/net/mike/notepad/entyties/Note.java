package net.mike.notepad.entyties;

public class Note {
    int id;
    String textArea;

    public Note() {
    id++;
    }

    public Note(String textArea) {
        this.textArea = textArea;
        id++;
    }
}
