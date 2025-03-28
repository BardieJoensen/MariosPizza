import java.util.ArrayList;
import java.util.Comparator;

public class OrderList {
    private final ArrayList<Order> orders;

    public OrderList() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        if(order!=null){
            orders.add(order);
            sortPizza();
        }
    }

    public void sortPizza() {
        orders.sort(Comparator.comparing(Order::getTimeOfPickup));
    }

    public Order removeOrder() {
        return orders.removeFirst(); //removes first element
    }

    public Order removeOrder(int index) {
        return orders.remove(index-1);
    }


    public String printNextOrder(){
        System.out.println("NEXT ORDER:");
        return orders.getFirst().toString();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public double getTurnover(){
        double sum = 0;
        for (Order order : orders){
            sum += order.getTotal();
        }
        return  sum;
    }

    @Override
    public String toString() {
        String result = "";
        int i = 1;
        for (Order item : orders) {
            result = result + i + ". " + String.format("#%03d",item.getOrderId()) +
                    " Pick-up: " + String.format("%04d",item.getTimeOfPickup()) + ", Pizzas: " + item.getAmount() + "\n";
            i++;
        }
        return result;
    }

//    public void statistic(MenuCard menuCard){
//        ArrayList<Pizza> pizzas = menuCard.getPizzas();
//        int amount;
//        Pizza pizza;
//        Order order;
//        OrderLine orderLine;
//
//        for(int i = 0; i<pizzas.size(); i++){ //iterate through pizzas in menu card
//            pizza = pizzas.get(i);
//            for(int j= 0; j<orders.size(); j++){ //iterate through orders in orderList
//                order = orders.get(j);
//                for(int k = 0; k<order.getOrderLines().size(); k++) { //iterate through orderLines in order
//                    orderLine = order.getOrderLines().get(k);
//                    if(orderLine.getPizza() == pizza){
//                        amount = orderLine.getAmount();
//                        pizza.increasePopularity(amount);
//                    }
//                }
//            }
//        }
//    }
}
