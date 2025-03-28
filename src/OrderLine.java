public class OrderLine {
    private final int amount;
    private final Pizza pizza;
    private final double total;

    public OrderLine(Pizza pizza, int amount) {
        this.pizza = pizza;
        this.amount = amount;
        this.total = pizza.getPrice() * this.amount;
    }

    public double getTotal() {
        return total;
    }

    public Pizza getPizza(){
        return pizza;
    }

    public int getAmount(){
        return amount;
    }

    @Override
    public String toString() {
        return amount + "x " + pizza.getName() + ", " + total + " kr";
    }
}