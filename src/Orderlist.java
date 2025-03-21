import java.util.ArrayList;
import java.util.Comparator;

public class Orderlist {
    private ArrayList<Order> orders;

    public Orderlist() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
        sortPizza();
    }

    public void sortPizza() {
        orders.sort(Comparator.comparing(Order::getTimeOfPickup));
    }

    public void removeOrder() {
        orders.remove(orders.size() - 1); //fjerner sidste element
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }


    @Override
    public String toString() {
        String result = "";
        for (Order item : orders) {
            result = result + item.getTimeOfPickup() + "\n";
        }
        return result;
    }
}


//    public void assOrder(Order order){
//        for(int i = orders.size()-1; i>0; i--){ //iterate back starting at last index of arr
//            if(orders.get(i).getTimeOfPickup() > order.getTimeOfPickup()){ // if ToP at index is later than ToP of new order
//                orders.add(i+1, order); // place new order at index to the right of order at index
//                break;
//            }
//        }
//    }
