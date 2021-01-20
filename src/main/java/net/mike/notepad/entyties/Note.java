package net.mike.notepad.entyties;

import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Note implements Cloneable {

    @Id
    private Integer id;
    @Column
    private String tittle;
    @Column
    private String textArea;
    private String date;



    public  Note() {

    }

    public Note(Integer id) {
        this.id = id;
        this.tittle = " ";
        this.textArea = " ";
        this.date = getDate();
    }

    public Note(String textArea) {
        this.tittle = textArea.substring(0, 25);
        this.textArea = textArea;
        this.date = getDate();

    }

    public Note(String tittle, String textArea) {
        this.tittle = tittle;
        this.textArea = textArea;
        this.date = getDate();

    }

    public Note(Integer id, String tittle, String textArea) {
        this.id = id;
        this.tittle = tittle;
        this.textArea = textArea;
    }

    public String getDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("d/MM/uu hh:mm:ss"));
    }

    public Integer getId() {

        return this.id;
    }

    public void setId(Integer id) {
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
