import java.util.*;

class Customer extends User {
    public Customer(String name, String email, int identificationNumber, String username, String password) {
        super(name, email, identificationNumber, username, password);
        this.email = email;
        this.identificationNumber = identificationNumber;
    }

    @Override
    public void showMenu() {
        while(true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Browse products");
            System.out.println("2. View Shopping cart");
            int choice = ClientMain.input.nextInt();
            if (choice == 1){
                for (Item i: ServerMain.shop.getItems()){
                    System.out.println(i.getId() + ". " + i.getName() + " - $" + i.getPrice());
                }
            } else if (choice == 2) {

            }
        }
    }
}