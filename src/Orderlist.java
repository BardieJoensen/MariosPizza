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
        orders.remove(0); //fjerner sidste element
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public String printNextOrder(){
        System.out.println("NEXT ORDER:");
        return orders.get(0).toString();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        System.out.println("ACTIVE ORDERS:");

        String result = "";

        for (Order item : orders) {
            result = result + "Pickup: " + item.getTimeOfPickup() + ", Pizzas: " + item.getAmount() + "\n";
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
