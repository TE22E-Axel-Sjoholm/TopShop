import java.util.*;

class Administrator extends User {
    public Administrator(String name, String email, int identificationNumber, String username, String password) {
        super(name, email, identificationNumber, username, password);
        this.email = email;
        this.identificationNumber = identificationNumber;
    }

    @Override
    public void showMenu() {
        System.out.println("Admin meny fixar sen ong");
    }
}