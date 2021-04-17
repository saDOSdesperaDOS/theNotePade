package net.mike.notepad.dbase.entyties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "notes", schema = "public")
public class NoteDataSet implements Serializable, Cloneable {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tittle")
    private String tittle;
    @Column(name="textarea")
    private String textArea;
    @Column(name="date")
    private LocalDateTime date;


    public NoteDataSet() {
        this.tittle = " ";
        this.textArea = " ";
        //this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("d/MM/uu hh:mm:ss"));
    }

    public NoteDataSet(String tittle) {
        this.setTittle(tittle);
        this.setTextArea(textArea);
    }

    public NoteDataSet(String tittle, String textArea) {
        this.tittle = tittle;
        this.textArea = textArea;
    }

    /*public void setDate() {
        date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("d/MM/uu hh:mm:ss"));
    }*/

    public LocalDateTime getDate() {
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

        NoteDataSet noteDataSet = (NoteDataSet) o;

        if (id != noteDataSet.id) return false;
        if (!tittle.equals(noteDataSet.tittle)) return false;
        return textArea.equals(noteDataSet.textArea);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + tittle.hashCode();
        result = 31 * result + textArea.hashCode();
        return result;
    }

    @Override
    public NoteDataSet clone() { //NOSONAR
        try {
            return (NoteDataSet) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(
                    "The Note object could not be cloned.", e);
        }
    }
}
