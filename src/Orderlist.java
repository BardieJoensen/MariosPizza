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
        return orders.get(0).toString();
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
            result = result + i + ". " + String.format("#%03d",item.getOrderId()) + " Pick-up: " + item.getTimeOfPickup() + ", Pizzas: " + item.getAmount() + "\n";
            i++;
        }
        return result;
    }

    public void statistic(MenuCard menuCard){
        ArrayList<Pizza> pizzas = menuCard.getPizzas();
        int amount = 0;

        for(int i = 0; i<pizzas.size(); i++){
            Pizza pizza = pizzas.get(i);
            for(int j= 0; i<orders.size(); j++){
                Order order = orders.get(j);
                for(int k = 0; k<order.getOrderlines().size(); k++) {
                    if()
                    amount = order.getOrderlines().get(k).getAmount();
                    pizza.setPopularity(amount);
                }
            }
        }
    }


}



