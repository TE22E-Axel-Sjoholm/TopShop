import java.io.*;
import java.net.*;
import java.util.*;

class ServerMain {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12222);
        Shop shop = new Shop();
        User user;
        while (true) {
            Socket clientSocket = serverSocket.accept();
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            String input = (String) in.readObject();
            if(input.charAt(0) == '1'){
                String[] login = input.substring(1).split(",");
                user = shop.validateLogin(login[0], login[1]);
                out.writeObject(user);
            } else if (input.charAt(0) == '2'){
                String[] accountInfo = input.substring(1).split(",");
                shop.addUser(new Customer(accountInfo[0], accountInfo[1], Integer.parseInt(accountInfo[2]), accountInfo[3],accountInfo[4]));
            }
        }
    }
}
