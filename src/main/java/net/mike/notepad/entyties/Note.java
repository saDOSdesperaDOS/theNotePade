package net.mike.notepad.entyties;

import java.time.LocalDate;

public class Note {

    int id;
    private String tittle;
    private String textArea;
    private LocalDate date;

    public Note(int id, String tittle, String textArea) {
        this.id = id;
        this.tittle = tittle;
        this.textArea = textArea;
        this.date = LocalDate.now();

    }

    public LocalDate getDate() {
        return LocalDate.now();
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
