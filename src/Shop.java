import java.util.*;


class Shop {
    private ArrayList<Item> items;
    private ArrayList<User> users;

    public Shop() {
        items = new ArrayList<>();
        users = new ArrayList<>();

        items.add(new Item("Dammsugare", 10));

        items.add(new Item("Kaffekopp", 8));

        users.add(new Customer("Sigma", "Axelsjoh@gmail.com",123123,"1","1"));
        users.add(new Customer("Sigma", "Axelsjoh123@gmail.com",123123,"2","2"));
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public User validateLogin(String username, String password) {
        for (User u : users)
            if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password))
                return u;
        return null;
    }

    public void saveUsers() {}

    public void saveItems() {}

    public void deleteUser(int id) {}

    public void deleteProduct(int id) {}

    public void addProduct(Item item) {}

    public void createAccount() {}
}