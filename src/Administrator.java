import java.util.*;

class Administrator extends User {
    public Administrator(String name, String email, int identificationNumber, String username, String password) {
        super(name, email, identificationNumber, username, password);
        this.email = email;
        this.identificationNumber = identificationNumber;
    }

    @Override
    public void showMenu() {
        outer:
        while (true){
            int choice;
            System.out.println("What would you like to do?\n1.User List\n2.Product List\n3.View Sales\n4.Log out");
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
            if (choice == 1){
                outer2:
                while (true) {
                    for (User u : ServerMain.shop.getUsers()) {
                        System.out.println(ServerMain.shop.getUsers().indexOf(u) + 1 + ". " + u.getName() + " - " + u.getUsername() + ", " + u.getPassword());
                    }
                    System.out.println("What would you like to do?\n1.Remove User\n2.Review User\n3.Create User\n4.Back");
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
                    if (choice == 1){
                        while (true) {
                            System.out.println("Which User would you like to remove? (ID)");
                            try {
                                choice = ClientMain.input.nextInt();
                                if (choice - 1 > ServerMain.shop.getUsers().size() || choice < 1) {
                                    System.out.println("That is not an option");
                                    continue;
                                }
                            } catch (Exception e) {
                                System.out.println("That is not an option");
                                continue;
                            }
                            ServerMain.shop.removeUser(ServerMain.shop.getUsers().get(choice - 1));
                            System.out.println("User Succefully removed");
                            continue outer2;
                        }
                    } else if (choice == 2){

                    }
                }
            }
        }
    }
}