package net.mike.notepad.model;

public class Account {

   // private int id;//у каждого экземпляра id == 0
    private String email;
    private String pass;
    private Account(UserProfil userProfil) {
        this.email = userProfil.getEmail();
        this.pass = userProfil.getPass();
    }
}
