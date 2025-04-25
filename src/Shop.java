import java.util.*;


class Shop {
    private ArrayList<Item> items;
    private ArrayList<User> users;
    private double profits = 0;

    public Shop() {
        items = new ArrayList<>();
        users = new ArrayList<>();

        items.add(new Item("Bissell CleanView Upright Vacuum", 129.99));
        items.add(new Item("Corelle Stoneware Coffee Mug (4-pack)", 14.99));
        items.add(new Item("Shark Navigator Lift-Away Vacuum", 199.99));
        items.add(new Item("Contigo Autoseal Travel Mug", 12.99));
        items.add(new Item("Dyson V7 Motorhead Vacuum", 249.99));
        items.add(new Item("Le Creuset Stoneware Mug", 17.99));
        items.add(new Item("Hoover WindTunnel Vacuum", 159.99));
        items.add(new Item("Yeti Rambler 14 oz Mug", 19.99));
        items.add(new Item("Eureka PowerSpeed Vacuum", 89.99));
        items.add(new Item("Ello Campy Insulated Mug", 9.99));
        items.add(new Item("Miele Classic C1 Vacuum", 279.99));
        items.add(new Item("Stanley Classic Vacuum Mug 12 oz", 14.99));
        items.add(new Item("Bissell Hard Floor Expert Vacuum", 119.99));
        items.add(new Item("Sweese Porcelain Coffee Cup", 8.99));
        items.add(new Item("BLACK+DECKER Bagless Vacuum", 79.99));
        items.add(new Item("Chinet Paper Coffee Cups (50-pack)", 11.99));
        items.add(new Item("Kenmore Elite Pet Vacuum", 229.99));
        items.add(new Item("S'well Stainless Steel Tumbler", 24.99));


        users.add(new Customer("Axel", "Axelsjoh@gmail.com",123123,"1","1"));
        users.add(new Customer("Ostis", "Anton@fear.se",123223,"2","2"));
        users.add(new Administrator("Empan", "EmilKjellin@gmail.com", 123123, "3", "3"));
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
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }


    public void saveUsers() {}

    public void saveItems() {}

    public void createUser() {}

    public double getProfits() {
        return profits;
    }

    public void addProfits(double d) {
        this.profits += d;
    }
}