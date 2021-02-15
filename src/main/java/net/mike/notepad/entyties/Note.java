package net.mike.notepad.entyties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "NOTESLIST", schema = "PUBLIC", catalog = "APPSTABLES")
public class Note implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;
    @Column(name = "tittle")
    private String tittle;
    @Column(name="textarea")
    private String textArea;
    @Column(name="date")
    private String date;

    public  Note() {
        this.tittle = " ";
        this.textArea = " ";

    }

    public Note(String tittle, String textArea) {
        this.tittle = tittle;
        this.textArea = textArea;
        //this.date = getDate();
    }

    public void setDate() {
        date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("d/MM/uu hh:mm:ss"));
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return this.id;
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

    @Override
    public Note clone() { //NOSONAR
        try {
            return (Note) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(
                    "The Note object could not be cloned.", e);
        }
    }
}
