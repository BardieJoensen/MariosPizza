import java.util.ArrayList;

public class Order {
    //TODO: Opret ordre og afhentningstidspunkt
    private static int orderCount = 1;

    private final int orderId;
    private final ArrayList<OrderLine> orderLines;
    private int timeOfPickup; //Military time
    private double total;

    public Order() {
        this.orderLines = new ArrayList<>();
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
        for (OrderLine item : orderLines) {
            total += item.getTotal();
        }
        return total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void addOrderLine(OrderLine ol) {
        orderLines.add(ol);
    }

    public ArrayList<OrderLine> getOrderLines(){
        return orderLines;
    }

    public int getAmount(){
        int amount = 0;
        for (OrderLine orderline : orderLines){
            amount += orderline.getAmount();
        }
        return amount;
    }

    @Override
    public String toString() {
        String result = "";

        for (OrderLine item : orderLines) {
            result += item + "\n";
        }
        return result;
    }
}