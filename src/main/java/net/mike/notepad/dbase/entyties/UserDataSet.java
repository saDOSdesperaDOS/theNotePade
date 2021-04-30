package net.mike.notepad.dbase.entyties;

import org.junit.jupiter.api.Test;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public")
public class UserDataSet implements Serializable { // Serializable Important to Hibernate!

    @ElementCollection
    @CollectionTable(name = "note")
    protected List<NoteDataSet> notes = new ArrayList<>();
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", unique = true, updatable = false)
    private String login;

    @Column(name = "password", updatable = false)
    private String password;



    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public UserDataSet() {
    }

    public UserDataSet(long id, String login) {
        this.setId(id);
        this.setLogin(login);
    }

    public UserDataSet(String login) {
        this.setId(-1);
        this.setLogin(login);
    }

    public UserDataSet(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserDataSet(long id, String login, String password) {
        this.setId(id);
        this.setLogin(login);
        this.setPassword(password);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<NoteDataSet> getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}