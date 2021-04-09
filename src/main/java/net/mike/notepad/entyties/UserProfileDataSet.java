package net.mike.notepad.entyties;

public class UserProfileDataSet {

    private int id;//у каждого экземпляра id == 0
    private String email;
    private String pass;

    public UserProfileDataSet(int id, String email, String pass) {
        this.id = id;
        this.email = email;
        this.pass = pass;
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

        UserProfileDataSet other = (UserProfileDataSet) o;

        if (id != other.id) return false;
        if (!email.equals(other.email)) return false;
        return pass.equals(other.pass);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + email.hashCode();
        result = 31 * result + pass.hashCode();
        return result;
    }
}
