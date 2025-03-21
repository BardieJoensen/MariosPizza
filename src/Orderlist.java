import java.util.ArrayList;
import java.util.Comparator;

public class Orderlist {
    private ArrayList<Order> orders;

    public Orderlist(){
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public void sortPizza() {
        //Order.sort(Comparator.comparing(Order::getStatus));

    }

    public void removeOrder(){
        orders.remove(orders.size()-1); //fjerner sidste element
    }

    public void removeOrder(Order order){
        orders.remove(order);
    }

    public void assOrder(Order order){
        for(int i = orders.size()-1; i>0; i--){
            //if(
        }
    }
}