package net.mike.notepad.model;

import java.util.Objects;

public class UserProfil {

    private int id;//у каждого экземпляра id == 0
    private String email;
    private String pass;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfil that = (UserProfil) o;
        return id == that.id &&
                Objects.equals(email, that.email) &&
                Objects.equals(pass, that.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
