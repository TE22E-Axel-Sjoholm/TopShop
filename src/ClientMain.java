import java.io.*;
import java.net.*;
import java.util.*;

class ClientMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        Socket socket = new Socket("localhost", 12222);
        User user;
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        System.out.println("Welcome to TopShop");
        int choice = 0;
        outer:
        while(true) {
            System.out.println("1. Login\n2. Create Account");
            try{
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("Not a choice");
                continue;
            }
            if(choice == 1){
                while(true){
                    input.nextLine();
                    System.out.println("Username:");
                    String username = input.nextLine();
                    System.out.println("Password:");
                    String password = input.nextLine();
                    out.writeObject("1" + username + "," + password);
                    user = (User) in.readObject();
                    if (user == null){
                        System.out.println("Wrong password or username");
                    } else {
                        user.showMenu();
                    }
                }
            } else if(choice == 2){
                while(true){
                    System.out.println("Name:");
                    String name = input.nextLine();
                    System.out.println("Email:");
                    String email = input.nextLine();
                    System.out.println("IDnr:");
                    String idnr = input.nextLine();
                    System.out.println("Username:");
                    String username = input.nextLine();
                    System.out.println("Password:");
                    String password = input.nextLine();
                    out.writeObject("2" + name + "," + email + "," + idnr + "," + username + "," + password);
                    System.out.println("Account created.\nReturning to main menu...");
                    break;
                }
            } else{
                System.out.println("Not a choice");
            }
        }
    }
}