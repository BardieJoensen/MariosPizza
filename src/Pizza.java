public class Pizza {
    private final int id;
    private final String name;
    private double price;

    public Pizza(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() { return "Id: " + id + "Pizza: " +  name  + "Price: " + price; }
}