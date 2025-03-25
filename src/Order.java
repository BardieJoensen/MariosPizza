import java.util.ArrayList;

public class Order {
    //TODO: Opret ordre og afhentningstidspunkt
    private static int orderCount = 1;

    private int orderId;
    private ArrayList<Orderline> orderlines;
    private int timeOfPickup; //Collections.sort(timeOfPickup) //Military time babyyyyyyyyyyyy <3
    private double total;
    private String status; //Igangværende //Klar //Betalt //afhentet -> arrayList
    private Customer customer;


    public Order() {
        this.orderlines = new ArrayList<>();
        this.timeOfPickup = 0;
        this.total = 0;
        this.orderId = orderCount;
        orderCount++;
    }

    public Order(String status) {
        this.orderlines = new ArrayList<>();
        this.timeOfPickup = 0;
        this.status = status;
        this.total = 0;
    }

    //En nice2have constructer til senere
    public Order(String status, Customer customer) {
        this.orderlines = new ArrayList<>();
        this.timeOfPickup = 0;
        this.status = status;
        this.total = 0;
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String updateStatus) {
        status = updateStatus;
    }

    public int getTimeOfPickup() {
        return timeOfPickup;
    }

    public void setTimeOfPickup(int updateTimeOfPickup) {
        timeOfPickup = updateTimeOfPickup;
    }


    public double getTotal() {
        return total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void calculateTotal() {
        total = 0; //resetter total så vi ikke lægger mere til totallet ved en fejl
        for (Orderline item : orderlines) {
            total += item.getPrice();
        }
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