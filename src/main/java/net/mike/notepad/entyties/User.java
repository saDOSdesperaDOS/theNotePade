package net.mike.notepad.entyties;

public class User {
    private int id;
    private String email;
    private String pass;

    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
        id++;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }
}
