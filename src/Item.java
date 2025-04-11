import java.util.*;


class Item {
    private int id;
    private String name;
    private double price;
    private int stock;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        genId();
    }
    public void genId() {
        id = ServerMain.shop.getItems().size();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}