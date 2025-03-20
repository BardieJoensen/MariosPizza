import java.util.ArrayList;

public class Menucard {
    private static final ArrayList<String> pizzas = new PizzaList(
            new Pizza(1, "Margherita", 75),
            new Pizza(2, "Pepperoni", 80),
            new Pizza(3, "Hawaiian", 85),
            new Pizza(4, "Vegetariana", 85),
            new Pizza(5, "Capricciosa", 90),
            new Pizza(6, "Quattro Stagioni", 95),
            new Pizza(7, "Diavola", 90),
            new Pizza(8, "Funghi", 80),
            new Pizza(9, "Prosciutto e Funghi", 90),
            new Pizza(10, "BBQ Chicken", 95),
            new Pizza(11, "Calzone", 90),
            new Pizza(12, "Tonno", 85),
            new Pizza(13, "Carbonara", 95),
            new Pizza(14, "Bolognese", 90),
            new Pizza(15, "Siciliana", 85),
            new Pizza(16, "Gorgonzola e Pere", 95),
            new Pizza(17, "Frutti di Mare", 100),
            new Pizza(18, "Rucola e Parma", 95),
            new Pizza(19, "Bacon & Champignon", 85),
            new Pizza(20, "Pesto e Mozzarella", 90),
            new Pizza(21, "Fresca", 80),
            new Pizza(22, "Mexicana", 90),
            new Pizza(23, "Prawn & Garlic", 95),
            new Pizza(24, "Tartufo", 100),
            new Pizza(25, "Buffalo Chicken", 95),
            new Pizza(26, "Rustica", 90),
            new Pizza(27, "Vegetarisk Deluxe", 85),
            new Pizza(28, "Parmigiana", 90),
            new Pizza(29, "Cacciatore", 95),
            new Pizza(30, "Pastrami & Pickles", 90)
    );
    public static ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public static Pizza getPizzaById(int id) {
        for (Pizza pizza : pizzas) {
            if (pizza.getId() == id) {
                return pizza;
            }
        }
        return null;
    }
}
