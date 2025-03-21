import java.util.ArrayList;

public class Order {
    //TODO: Opret ordre og afhentningstidspunkt
    private ArrayList<Orderline> orderlines;
    private final int timeOfPickup; //Collections.sort(timeOfPickup) //Military time babyyyyyyyyyyyy <3
    private double total;
    private String status; //Igangværende //Klar //Betalt //afhentning -> arrayList

    public Order(int timeOfPickup, String status) {
        this.orderlines = new ArrayList<>();
        this.timeOfPickup = timeOfPickup;
        this.status = status;
        this.total = 0;
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

    public void setTotal(){
        for (Orderline item : orderlines){
            total = item.getPrice();
        }
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