import java.io.*;
import java.net.*;
import java.util.*;

class ServerMain {
    public static Shop shop = new Shop();
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(12222);
        User user;
        while (true) {
            Socket clientSocket = serverSocket.accept();
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("Socket is open and waiting");
            String input = (String) in.readObject();
            if(input.charAt(0) == '1'){
                String[] login = input.substring(1).split(",");
                user = shop.validateLogin(login[0], login[1]);
                System.out.println("user sent login successful (if not null)");
                out.writeObject(user);
            } else if (input.charAt(0) == '2'){
                String[] accountInfo = input.substring(1).split(",");
                shop.addUser(new Customer(accountInfo[0], accountInfo[1], Integer.parseInt(accountInfo[2]), accountInfo[3],accountInfo[4]));
                System.out.println("account created");
            }
        }
    }
}
