import java.util.ArrayList;

public class Menucard {
    ArrayList<Pizza> pizzas;

    public Menucard() {
        this.pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Margherita", 75));
        pizzas.add(new Pizza("Pepperoni", 80));
        pizzas.add(new Pizza("Hawaiian", 85));
        pizzas.add(new Pizza("Vegetariana", 85));
        pizzas.add(new Pizza("Capricciosa", 90));
        pizzas.add(new Pizza("Quattro Stagioni", 95));
        pizzas.add(new Pizza("Diavola", 90));
        pizzas.add(new Pizza("Funghi", 80));
        pizzas.add(new Pizza("Prosciutto e Funghi", 90));
        pizzas.add(new Pizza("BBQ Chicken", 95));
        pizzas.add(new Pizza("Calzone", 90));
        pizzas.add(new Pizza("Tonno", 85));
        pizzas.add(new Pizza("Carbonara", 95));
        pizzas.add(new Pizza("Bolognese", 90));
        pizzas.add(new Pizza("Siciliana", 85));
        pizzas.add(new Pizza("Gorgonzola e Pere", 95));
        pizzas.add(new Pizza("Frutti di Mare", 100));
        pizzas.add(new Pizza("Rucola e Parma", 95));
        pizzas.add(new Pizza("Bacon & Champignon", 85));
        pizzas.add(new Pizza("Pesto e Mozzarella", 90));
        pizzas.add(new Pizza("Fresca", 80));
        pizzas.add(new Pizza("Mexicana", 90));
        pizzas.add(new Pizza("Prawn & Garlic", 95));
        pizzas.add(new Pizza("Tartufo", 100));
        pizzas.add(new Pizza("Buffalo Chicken", 95));
        pizzas.add(new Pizza("Rustica", 90));
        pizzas.add(new Pizza("Vegetarisk Deluxe", 85));
        pizzas.add(new Pizza("Parmigiana", 90));
        pizzas.add(new Pizza("Cacciatore", 95));
        pizzas.add(new Pizza("Pastrami & Pickles", 90));
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
