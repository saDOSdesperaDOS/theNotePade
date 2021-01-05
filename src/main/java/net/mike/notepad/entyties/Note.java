package net.mike.notepad.entyties;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Note {

    static int id;
    private String tittle;
    private String textArea;
    private String date;

    public Note() {
        this.id++;
        this.tittle = " ";
        this.textArea = " ";
        this.date = getDate();
    }

    public Note(String textArea) {
        this.id++;
        this.tittle = textArea.substring(0, 25);
        this.textArea = textArea;
        this.date = getDate();

    }

    public Note(String tittle, String textArea) {
        this.id++;
        this.tittle = tittle;
        this.textArea = textArea;
        this.date = getDate();

    }

    public String getDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("d/MM/uu hh:mm:ss"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getTextArea() {
        return textArea;
    }

    public void setTextArea(String textArea) {
        this.textArea = textArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (id != note.id) return false;
        if (!tittle.equals(note.tittle)) return false;
        return textArea.equals(note.textArea);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + tittle.hashCode();
        result = 31 * result + textArea.hashCode();
        return result;
    }
}
