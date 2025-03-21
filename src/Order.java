import java.util.ArrayList;

public class Order {
    //TODO: Opret ordre og afhentningstidspunkt
    private ArrayList<Orderline> orderlines;
    private final int timeOfPickup; //Collections.sort(timeOfPickup) //Military time babyyyyyyyyyyyy <3
    private double total;
    private String status; //Igangværende //Klar //Betalt //afhentning -> arrayList
    private Customer customer;

    public Order(int timeOfPickup, String status) {
        this.orderlines = new ArrayList<>();
        this.timeOfPickup = timeOfPickup;
        this.status = status;
        this.total = 0;
    }

    //En nice2have constructer til senere
    public Order(int timeOfPickup, String status, Customer customer) {
        this.orderlines = new ArrayList<>();
        this.timeOfPickup = timeOfPickup;
        this.status = status;
        this.total = 0;
        this.customer = customer;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String updateStatus){
        status = updateStatus;
    }

    public int getTimeOfPickup(){
        return timeOfPickup;
    }

    public double getTotal(){
        return total;
    }

    public void calculateTotal(){
        total = 0; //resetter total så vi ikke lægger mere til totallet ved en fejl
        for (Orderline item : orderlines){
            total += item.getPrice();
        }
    }

    public void addOrderline(Orderline ol){
        orderlines.add(ol);
    }

    @Override
    public String toString() {
        String result = "";

        for(Orderline item : orderlines){
            result += item + "\n";
        }
        return result;
    }
}