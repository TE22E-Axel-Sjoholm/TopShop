import java.io.*;
import java.net.*;
import java.util.*;

class ClientMain {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user;
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
                input.nextLine();
                while(true){
                    System.out.println("Username:");
                    String username = input.nextLine();
                    System.out.println("Password:");
                    String password = input.nextLine();
                    Socket socket = new Socket("localhost", 12222);
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                    out.writeObject("1" + username + "," + password);
                    user = (User) in.readObject();
                    if (user == null){
                        System.out.println("Wrong password or username");
                        continue outer;
                    } else {
                        user.showMenu();
                        break outer;
                    }
                }
            } else if(choice == 2){
                input.nextLine();
                while(true){
                    System.out.println("Name:");
                    String name = input.nextLine();
                    System.out.println("Email:");
                    String email = input.nextLine();
                    String idnr;
                    while (true) {
                        System.out.println("IDnr:");
                        idnr = input.nextLine();
                        try {
                            int i = Integer.parseInt(idnr);
                        } catch (Exception e) {
                            System.out.println("IDnr has to be a number");
                            continue;
                        }
                        break;
                    }
                    System.out.println("Username:");
                    String username = input.nextLine();
                    System.out.println("Password:");
                    String password = input.nextLine();
                    Socket socket = new Socket("localhost", 12222);
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    out.writeObject("2" + name + "," + email + "," + idnr + "," + username + "," + password);
                    System.out.println("Account created.\nReturning to main menu...");
                    continue outer;
                }
            } else {
                System.out.println("Not a choice");
            }
            break;
        }
    }
}