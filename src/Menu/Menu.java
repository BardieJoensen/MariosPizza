package src.Menu;
import java.util.ArrayList;
import java.util.HashMap;


public class Menu {
    ArrayList<Pizza> menuItems;

    private void populateMenu(){
        double[] prices = {
        75.00,
        80.00,
        85.00,
        85.00,
        90.00,
        95.00,
        90.00,
        80.00,
        90.00,
        95.00,
        90.00,
        85.00,
        95.00,
        90.00,
        85.00,
        95.00,
        100.00,
        95.00,
        85.00,
        90.00,
        80.00,
        90.00,
        95.00,
        100.00,
        95.00,
        90.00,
        85.00,
        90.00,
        95.00,
        90.00,
        };

        String[] names = {
        "Margherita",
        "Pepperoni",
        "Hawaii",
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
        "Pastrami & Pickles",
        };

        for (int i = 0; i < prices.length; i++) {
            double price = prices[i];
            String name = names[i];
            Pizza pizza = new Pizza(name, price);
            this.menuItems.add(pizza);
        }

    }


    /// CONSTRUCTOR
    public Menu() {
        this.menuItems = new ArrayList<>();
        this.populateMenu();

    }

    public void displayMenuItems(){
        if(menuItems.isEmpty()){
            System.out.println("No menu items found");
            return;
        }
        System.out.println(this.menuItems);
    }
}
