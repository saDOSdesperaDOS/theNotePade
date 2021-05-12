package net.mike.notepad.dbase.entyties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "email", unique = true, updatable = false)
    private String email;

    @Column(name = "password", updatable = false)
    private String password;

    //Important to Hibernate!
    public UserDataSet() {}

    public UserDataSet(long id, String email) {
        this.setId(id);
        this.setEmail(email);
    }

    public UserDataSet(String email) {
        this.setId(-1);
        this.setEmail(email);
    }

    public UserDataSet(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserDataSet(long id, String email, String password) {
        this.setId(id);
        this.setEmail(email);
        this.setPassword(password);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String login) {
        this.email = login;
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
                ", login='" + email + '\'' +
                '}';
    }
}