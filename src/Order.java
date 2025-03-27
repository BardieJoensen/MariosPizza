import java.util.ArrayList;

public class Order {
    //TODO: Opret ordre og afhentningstidspunkt
    private static int orderCount = 1;

    private final int orderId;
    private final ArrayList<Orderline> orderlines;
    private int timeOfPickup; //Military time
    private double total;

    public Order() {
        this.orderlines = new ArrayList<>();
        this.timeOfPickup = 0;
        this.total = 0;
        this.orderId = orderCount;
        orderCount++;
    }

    public int getTimeOfPickup() {
        return timeOfPickup;
    }

    public void setTimeOfPickup(int updateTimeOfPickup) {
        timeOfPickup = updateTimeOfPickup;
    }

    public double getTotal() {
        total = 0; //resetter total så vi ikke lægger mere til totallet ved en fejl
        for (Orderline item : orderlines) {
            total += item.getTotal();
        }
        return total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void addOrderline(Orderline ol) {
        orderlines.add(ol);
    }

    public ArrayList<Orderline> getOrderlines(){
        return orderlines;
    }

    public int getAmount(){
        int amount = 0;
        for (Orderline orderline : orderlines){
            amount += orderline.getAmount();
        }
        return amount;
    }

    @Override
    public String toString() {
        String result = "";

        for (Orderline item : orderlines) {
            result += item + "\n";
        }
        return result;
    }
}