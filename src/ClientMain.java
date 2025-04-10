import java.util.*;

class ClientMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to TopShop");
        int choice;
        while(true) {
            System.out.println("1. Login\n2. Create Account");
            try{
                choice = input.nextInt();
                if(choice != 1 || choice != 2){
                    System.out.println("Not a choice");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Not a choice");
            }
        }
        if(choice == 1){
            while(true){
                System.out.println("Username:");
                input.nextLine();
                String username = input.nextLine();
                System.out.println("Password:");
                input.nextLine();
                String password = input.nextLine();

            }
        } else if(choice == 2){

        }
    }
}