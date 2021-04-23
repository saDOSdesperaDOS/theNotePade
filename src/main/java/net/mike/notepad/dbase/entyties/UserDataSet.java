package net.mike.notepad.dbase.entyties;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name = "users", schema = "public")
public class UserDataSet implements Serializable { // Serializable Important to Hibernate!

    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", unique = true, updatable = false)
    private String userName;

    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message="{invalid.email}")
    @Column(name = "email", unique = true, updatable = false)
    private String email;

    @Column(name = "password", updatable = false)
    private String password;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public UserDataSet() {
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}