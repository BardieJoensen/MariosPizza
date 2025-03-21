public class Orderline {
    //TODO: Vis aktive ordre og afhentningstidpunkts
    private int amount;
    private Pizza pizza;
    private double total;

    public Orderline(Pizza pizza, int amount) {
        this.pizza = pizza;
        this.amount = amount;
        this.total = pizza.getPrice() * this.amount;
    }

    public double getPrice() {
        return total;
    }

    @Override
    public String toString() {
        return pizza.getName() + ", x" + amount + " " + total + " kr";
    }
}