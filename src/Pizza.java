public class Pizza {
    private final String name;
    private double price;
    private int popularity;

    public Pizza(String name, double price) {
        this.name = name;
        this.price = price;
        this.popularity = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPopularity(){
        return popularity;
    }

    public void increasePopularity(int amount){
        popularity += amount;
    }

    @Override
    public String toString() {
        return name + ", " + price + " kr.";
    }
}