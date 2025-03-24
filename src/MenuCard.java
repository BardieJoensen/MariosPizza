import java.util.ArrayList;

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

    public Pizza getPizzaByIndx(int index) {
        return pizzas.get(index - 1);
    }

    public String toString() {
        int id = 1;
        String str = "";

        for (Pizza i : pizzas) {
            str = str + id + ". " + i + "\n";
            id++;
        }

        return str;
    }
}
