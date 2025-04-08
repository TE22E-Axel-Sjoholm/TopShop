import java.util.*;

class Person {
    protected String name;
    protected String email;
    protected int identificationNumber;

    public Person(String name, String email, int identificationNumber) {
        this.name = name;
        this.email = email;
        this.identificationNumber = identificationNumber;
    }

    public String getName() {
        return name;
    }
}