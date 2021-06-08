package net.mike.notepad.dbase.entyties;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")
public class UserDataSet implements Serializable { // Serializable Important to Hibernate!

    @ElementCollection(fetch =  FetchType.EAGER)
    @CollectionTable(name = "note")
    protected List<NoteDataSet> notes = new ArrayList<>();
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

<<<<<<< HEAD
    @Column(name = "username", unique = true, updatable = false)
    private String userName;

    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message="{invalid.email}")
=======
>>>>>>> emb
    @Column(name = "email", unique = true, updatable = false)
    private String email;

    @Column(name = "password", updatable = false)
    private String password;

    @Column(name = "role")
    private String role;

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

<<<<<<< HEAD
    public UserDataSet(String userName, String email, String password) {
        this.setUserName(userName);
        this.setEmail(email);
        this.setPassword(password);
    }

=======
>>>>>>> emb
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

<<<<<<< HEAD
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

=======
>>>>>>> emb
    public String getEmail() {
        return email;
    }

<<<<<<< HEAD
    public void setEmail(String email) {
        this.email = email;
=======
    public void setEmail(String login) {
        this.email = login;
>>>>>>> emb
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

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
<<<<<<< HEAD
                ", email='" + email + '\'' +
=======
                ", login='" + email + '\'' +
>>>>>>> emb
                '}';
    }
}