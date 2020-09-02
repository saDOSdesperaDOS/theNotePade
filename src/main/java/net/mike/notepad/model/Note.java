package net.mike.notepad.model;

public class Note {
    int id;
    String textArea;

    public Note() {
    id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextArea() {
        return textArea;
    }

    public void setTextArea(String textArea) {
        this.textArea = textArea;
    }

    public Note(String textArea) {
        id++;
        this.textArea = textArea;
    }
}
