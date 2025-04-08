import java.util.*;

class Customer extends User {
    public Customer(String name, String email, int identificationNumber, String username, String password) {
        super(name, email, identificationNumber, username, password);
        this.email = email;
        this.identificationNumber = identificationNumber;
    }

    @Override
    public void showMenu() {
        System.out.println("kund meny fixar sen svär på gud!");
    }
}