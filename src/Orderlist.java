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
                    " Pick-up: " + item.getTimeOfPickup() + ", Pizzas: " + item.getAmount() + "\n";
            i++;
        }
        return result;
    }

    public void statistic(MenuCard menuCard){
        ArrayList<Pizza> pizzas = menuCard.getPizzas();
        int amount;
        Pizza pizza;
        Order order;
        Orderline orderline;

        for(int i = 0; i<pizzas.size(); i++){ //iterate through pizzas in menucard
            pizza = pizzas.get(i);
            for(int j= 0; j<orders.size(); j++){ //iterate through orders in orderlist
                order = orders.get(j);
                for(int k = 0; k<order.getOrderlines().size(); k++) { //iterate through orderlines in order
                    orderline = order.getOrderlines().get(k);
                    if(orderline.getPizza() == pizza){
                        amount = orderline.getAmount();
                        pizza.setPopularity(amount);
                    }
                }
            }
        }
    }
}
