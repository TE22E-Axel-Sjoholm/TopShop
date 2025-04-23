import java.util.*;

class Customer extends User {
    private ArrayList<Item> shoppingCart = new ArrayList<>();

    public Customer(String name, String email, int identificationNumber, String username, String password) {
        super(name, email, identificationNumber, username, password);
        this.email = email;
        this.identificationNumber = identificationNumber;
    }

    @Override
    public void showMenu() {
        outer:
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Browse products");
            System.out.println("2. View Shopping cart");
            int choice;
            try {
                choice = ClientMain.input.nextInt();
                if (choice != 1 && choice != 2) {
                    System.out.println("That is not an option");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("That is not an option");
                continue;
            }
            if (choice == 1) {
                int page = 0;
                while (true) {
                    for (int i = 5 * page; i < 5 + page * 5; i++) {
                        if (ServerMain.shop.getItems().size() > i) {
                            Item I = ServerMain.shop.getItems().get(i);
                            System.out.println(i + 1 + ". " + I.getName() + " - $" + I.getPrice());
                        }
                    }
                    System.out.print("1: <-- Previous page, 2: Next page -->, 3: Add item to cart, 4: Back");
                    try {
                        choice = ClientMain.input.nextInt();
                        if (choice > 4 || choice < 1) {
                            System.out.println("That is not an option");
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("That is not an option");
                        continue;
                    }
                    if (choice == 1 && page > 0) {
                        page--;
                        continue;
                    } else if (choice == 1 && page == 0) {
                        System.out.println("That is not an option");
                        continue;
                    } else if (choice == 2) {
                        if (5 + page * 5 < ServerMain.shop.getItems().size()) {
                            page++;
                        } else {
                            System.out.println("No more items.");
                        }
                        continue;
                    } else if (choice == 3) {
                        System.out.println("ID of item:");
                        try {
                            choice = ClientMain.input.nextInt();
                            if (choice - 1 >= 0 && choice - 1 < ServerMain.shop.getItems().size()) {
                                shoppingCart.add(ServerMain.shop.getItems().get(choice - 1));
                                System.out.println("Item added to cart.");
                            } else {
                                System.out.println("That is not an option");
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("That is not an option");
                            continue;
                        }
                    } else {
                        continue outer;
                    }
                }
            } else if (choice == 2) {
                while(true) {
                    double total = 0;
                    for (Item i: shoppingCart){
                        System.out.println(shoppingCart.indexOf(i)+1 + ". " + i.getName() + " - " + i.getPrice());
                        total += i.getPrice();
                    }
                    System.out.println("Total price is $" + total);
                    System.out.println("1: Purchase all, 2: Remove product, 3: Back ");
                    try {
                        choice = ClientMain.input.nextInt();
                        if (choice < 1 || choice > 3) {
                            System.out.println("That is not an option");
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("That is not an option");
                        continue;
                    }
                    if(choice == 1){
                        System.out.println("$" + total + " has been withdrawn from you account");
                        if(shoppingCart.isEmpty()){
                            System.out.println("Your shopping cart is empty");
                        } else {
                            for (Item i : shoppingCart) {
                                ServerMain.shop.removeItem(i);
                            }
                            shoppingCart.clear();
                        }
                    } else if (choice == 2) {
                        while (true){
                            System.out.println("Which item do you want to remove?");
                            try {
                                choice = ClientMain.input.nextInt();
                                if (choice+1 > shoppingCart.size() ||choice < 1) {
                                    System.out.println("That is not an option");
                                    continue;
                                }
                            } catch (Exception e) {
                                System.out.println("That is not an option");
                                continue;
                            }
                            shoppingCart.remove(choice-1);
                            break;
                        }
                    } else {
                        continue outer;
                    }
                }
                
            } else{
                System.out.println("123");
            }
        }
    }
}
