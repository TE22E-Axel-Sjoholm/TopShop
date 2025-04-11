import java.util.*;

abstract class User extends Person {
    protected String username;
    protected String password;
    protected int userID;

    public User(String name, String email, int identificationNumber, String username, String password) {
        super(name, email, identificationNumber);
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public abstract void showMenu();
}