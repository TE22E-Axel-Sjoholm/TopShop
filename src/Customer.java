import java.util.*;

class Customer extends User {
    public Customer(String name, String email, int identificationNumber, String username, String password) {
        super(name, email, identificationNumber, username, password);
        this.email = email;
        this.identificationNumber = identificationNumber;
    }

    @Override
    public void showMenu() {
        outer:
        while(true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Browse products");
            System.out.println("2. View Shopping cart");
            int choice;
            try {
                choice = ClientMain.input.nextInt();
                if (choice != 1 && choice != 2){
                    System.out.println("That is not an option");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("That is not an option");
                continue;
            }
            if (choice == 1){
                int page = 0;
                while(true) {
                    for (int i = 5 * page; i < 5 + page * 5; i++) {
                        if (ServerMain.shop.getItems().size() > i) {
                            Item I = ServerMain.shop.getItems().get(i);
                            System.out.println(i + 1 + ". " + I.getName() + " - $" + I.getPrice());
                        }
                    }
                    if(page == 0) {
                        System.out.print("1: Next page -->, 2: Add item to cart, 3: Back");
                        try {
                            choice = ClientMain.input.nextInt();
                            if (choice > 3 || choice < 1){
                                System.out.println("That is not an option");
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("That is not an option");
                            continue;
                        }
                        if (choice == 1){
                            page++;
                            continue;
                        } else if (choice == 2) {
                            System.out.println("ID of item:");
                            try {
                                choice = ClientMain.input.nextInt();
                                if (choice > 5 || choice < 1){
                                    System.out.println("That is not an option");
                                    continue;
                                }
                            } catch (Exception e) {
                                System.out.println("That is not an option");
                                continue;
                            }
                            // LÄGGER TILL ITEM MAN KÖPER I SHOPPING CART (ARRAYLIST PÅ CUSTOMER)
                        } else {
                            continue outer;
                        }
                    } else{
                        System.out.print("1. <-- Previous page, 2: Next page -->, 3: Add item to cart, 4: Back");
                        try {
                            choice = ClientMain.input.nextInt();
                            if (choice > 4 || choice < 1){
                                System.out.println("That is not an option");
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("That is not an option");
                            continue;
                        }
                        if (choice == 1){
                            page--;
                            continue;
                        } else if(choice == 2){
                            page++;
                            continue;
                        }else if (choice == 3) {
                            System.out.println("ID of item:");
                            try {
                                choice = ClientMain.input.nextInt();
                                if (choice > 5 || choice < 1){
                                    System.out.println("That is not an option");
                                    continue;
                                }
                            } catch (Exception e) {
                                System.out.println("That is not an option");
                                continue;
                            }
                            // LÄGGER TILL ITEM MAN KÖPER I SHOPPING CART (ARRAYLIST PÅ CUSTOMER)
                        } else {
                            continue outer;
                        }
                    }
                }

            } else if (choice == 2) {

            }
        }
    }
}