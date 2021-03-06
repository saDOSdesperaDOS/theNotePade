package net.mike.notepad.dbase.entyties;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class NoteDataSet implements Serializable, Cloneable {
    @Column
    protected String tittle;
    @Column(length = 10000)
    protected String textArea;
    @Column
    protected String date;

    public NoteDataSet() {

    }

    public NoteDataSet(String tittle) {
        this.setTittle(tittle);
        this.setTextArea(textArea);
    }

    public NoteDataSet(String tittle, String textArea) {
        this.tittle = tittle;
        this.textArea = textArea;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        return tittle.equals(noteDataSet.tittle);
    }

    @Override
    public int hashCode() {
        int result = 1;
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
