import java.util.ArrayList;
import java.util.Comparator;

public class MenuCard {
    ArrayList<Pizza> pizzas;

    public MenuCard() {
        this.pizzas = new ArrayList<>();
        // this function populates ´this.pizzas´ arrayList
        populateMenuCard();

    }
    /// Helper function that separates concerns of constructor and reduces code repetition (DRY.)
    /// To achieve "DRY" code, we only type code that is unique.
    private void populateMenuCard() {
        String[] names = {
                "Margherita",
                "Pepperoni",
                "Hawaiian",
                "Vegetariana",
                "Capricciosa",
                "Quattro Stagioni",
                "Diavola",
                "Funghi",
                "Prosciutto e Funghi",
                "BBQ Chicken",
                "Calzone",
                "Tonno",
                "Carbonara",
                "Bolognese",
                "Siciliana",
                "Gorgonzola e Pere",
                "Frutti di Mare",
                "Rucola e Parma",
                "Bacon & Champignon",
                "Pesto e Mozzarella",
                "Fresca",
                "Mexicana",
                "Prawn & Garlic",
                "Tartufo",
                "Buffalo Chicken",
                "Rustica",
                "Vegetarisk Deluxe",
                "Parmigiana",
                "Cacciatore",
                "Pastrami & Pickles"
        };
        int[] prices = {75, 80, 85, 85, 90,
                        95, 90, 80, 90, 95,
                        90, 85, 95, 90, 85,
                        95, 100, 95, 85, 90,
                        80, 90, 95, 100, 95,
                        90, 85, 90, 95, 90};

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            int price = prices[i];
            // Reduction of 30x repetition of class definition
            Pizza p = new Pizza(name, price);
            // added to class arrayList property
            pizzas.add(p);
        }
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    @Override
    public String toString() {
        System.out.println("MENU CARD:");

        int id = 1;
        String str = "";

        for (Pizza pizza : pizzas) {
            str = str + id + ". " + pizza + "\n";
            id++;
        }

        return str;
    }

    public void printPopularity(){
        System.out.println("POPULARITY OF PIZZAS:");

        ArrayList<Pizza> popularPizzas = new ArrayList<>();

        for (Pizza pizza : pizzas) {
            if (pizza.getPopularity() > 0) {
                popularPizzas.add(pizza);
            }
        }

        popularPizzas.sort(Comparator.comparing(Pizza::getPopularity));

        Pizza pizza;
        for (int i = popularPizzas.size()-1; i >= 0; i--){
            pizza = popularPizzas.get(i);
            System.out.println(pizza.getName() + " has sold " + pizza.getPopularity());

        }
        System.out.println();
    }

    public void statistic(Order order){
        if(order==null) return;
        int amount;
        Pizza pizza;
        Orderline orderline;

        for(int i = 0; i<pizzas.size(); i++){ //iterate through pizzas in menucard
            pizza = pizzas.get(i);
            for(int j = 0; j < order.getOrderlines().size(); j++) { //iterate through orderlines in order
                orderline = order.getOrderlines().get(j);
                if(orderline.getPizza() == pizza){
                    amount = orderline.getAmount();
                    pizza.increasePopularity(amount);
                }
            }
        }
    }
}
