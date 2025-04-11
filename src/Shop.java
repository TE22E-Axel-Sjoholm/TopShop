import java.util.*;


class Shop {
    private ArrayList<Item> items;
    private ArrayList<User> users;

    public Shop() {
        items = new ArrayList<>();
        users = new ArrayList<>();

        items.add(new Item("Dammsu123gare", 130));
        items.add(new Item("Kaff123ekopp", 8));
        items.add(new Item("Damm12sugare", 140));
        items.add(new Item("Kaff24124ekopp", 48));
        items.add(new Item("Dam14msugare", 140));
        items.add(new Item("Ka141ffekopp", 38));
        items.add(new Item("Damms325ugare", 10));
        items.add(new Item("Kaf14fekopp", 8));
        items.add(new Item("Damm12s3ugare", 10));
        items.add(new Item("Kaf234fekopp", 8));
        items.add(new Item("Da3mmsugare", 10));
        items.add(new Item("Ka32ffek23opp", 82));
        items.add(new Item("Dammsug3are", 1220));
        items.add(new Item("Ka1ffekopp", 83));
        items.add(new Item("Damm234sugare", 160));
        items.add(new Item("Kaf34fekopp", 87));
        items.add(new Item("Damm243sugare", 1370));
        items.add(new Item("Kaff43ekopp", 89));


        users.add(new Customer("Axel", "Axelsjoh@gmail.com",123123,"1","1"));
        users.add(new Customer("Ostis", "Anton@fear.se",123123,"2","2"));
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

    public void createAccount() {}
}