import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Pizzabar {
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    MenuCard menuCard = new MenuCard();
    OrderList orderList = new OrderList();
    OrderList orderHistory = new OrderList();

    public void runProgram() {
        addTestOrders(orderList, 10); // populate order list with random orders
        mainMenu();
    }

    public void mainMenu() {

        while (true) {
            if (!orderList.getOrders().isEmpty()) System.out.println(orderList.printNextOrder());
            System.out.println("ACTIVE ORDERs: \n" + orderList);

            System.out.println("""
                1. Show menu/edit prices
                2. Take Order
                3. Remove Order
                4. Show order history
                5. Exit program
                """);

            System.out.println("Enter number:");

            try {
                int menuActionInputToken =  sc.nextInt();
                sc.nextLine();
                switch (menuActionInputToken) {
                    case 1 -> menuCardOptions();
                    case 2 -> takeOrder();
                    case 3 -> removeOrders();
                    case 4 -> showHistory();
                    case 5 -> {
                        System.out.println("Exiting program - Good Bye!");
                        return;
                    }
                    default -> System.out.println("Invalid input...");
                }
            } catch (InputMismatchException error) {
                System.out.println("Something went very wrong");
                System.out.println();
                sc.nextLine();
            }
        }
    }

    public void menuCardOptions(){
        while(true){
            System.out.println(menuCard);

            System.out.println("""
                    1. Edit price of pizza
                    2. Back to main menu
                    """);

            int choice = getIntInRange(1,2);

            switch (choice) {
                case 1 -> editPrice();
                case 2 -> {return;}
                default -> System.out.println("Invalid input...");
            }
        }
    }

    public void editPrice() {
        System.out.println("Which pizza would you like to edit (enter number: 1-30)");
        int choice = getIntInRange(1, 30);

        Pizza pizza = menuCard.getPizzas().get(choice - 1);
        System.out.println("Editing: " + pizza);
        System.out.println("Enter new price:");

        double newPrice = 0;
        boolean validInput = false;
        while (!validInput){
            try {
                newPrice = sc.nextDouble();
                sc.nextLine();
                validInput = true;
            } catch (InputMismatchException error) {
                System.out.println("Invalid input!... Input valid price:");
                sc.nextLine();
            }
        }
        pizza.setPrice(newPrice);
        System.out.println("New price: " + pizza);
        System.out.println();
    }

    public void takeOrder() {
        System.out.println(menuCard);

        Order order = new Order();

        // Handles order logging
        ArrayList<Pizza> pizzasOnMenu = menuCard.getPizzas();
        int pizzasMenuItemCount = pizzasOnMenu.size();

        boolean finished = false;
        while (!finished) {
            System.out.println("Pick Pizza (enter number)");
            int choice = getIntInRange(1, pizzasMenuItemCount);

            Pizza pizza = pizzasOnMenu.get(choice - 1);

            System.out.println("Enter amount:");
            int amount = getPositiveInt();

            OrderLine orderline = new OrderLine(pizza, amount);
            order.addOrderLine(orderline);

            System.out.println("add more? [y/n]");
            String strChoice = sc.nextLine();
            if (strChoice.equalsIgnoreCase("n")) finished = true;
        }

        System.out.println("Enter time of pick-up: [ttmm]");
        int time = getValidTime();

        order.setTimeOfPickup(time);

        orderList.addOrder(order);
    }

    public void removeOrders(){
        System.out.println("""
                What would you like to remove?
                1. First order in line.
                2. Specific order.
                """);

        try{
            Order order = null;
            int token = sc.nextInt();
            sc.nextLine();
            switch (token){
                case 1 -> order = orderList.removeOrder();
                case 2 -> {
                    System.out.println("Which order number would you like to remove? Use integers.");
                    int index = getIntInRange(1, orderList.getOrders().size());
                    order = orderList.removeOrder(index);
                }
                default ->{
                    System.out.println("Invalid input, redo removal selection.");
                    removeOrders();
                }
            }
            orderHistory.addOrder(order);

            menuCard.statistic(order);

        }catch (InputMismatchException error){
            System.out.println("Invalid input redo removal selection.");
            sc.nextLine();
            removeOrders();
        }
    }

    public void showHistory() {
        while (true) {
            System.out.println("""
                1. Show turnover
                2. Show popularity of pizza
                3. Show order history
                4. Back to main menu
                """);
            int choice = getIntInRange(1, 4);
            switch (choice) {
                case 1 -> System.out.println(orderHistory.getTurnover() + " kr");
                case 2 -> menuCard.printPopularity();
                case 3 -> System.out.println("ORDER HISTORY: \n" + orderHistory);
                case 4 -> {
                    System.out.println("Going back to main menu");
                    return;
                }
                default -> System.out.println("Not a valid input");
            }
        }
    }

    public void addTestOrders(OrderList list, int orderAmount){
        for(int i = 0; i<orderAmount; i++) {
            Order order = new Order();

            int lines = random.nextInt(3)+1;

            for(int j = 0; j<lines; j++) {
                int pizzaType = random.nextInt(30);
                int amount = random.nextInt(10)+1;
                OrderLine orderline = new OrderLine(menuCard.getPizzas().get(pizzaType), amount);
                order.addOrderLine(orderline);
            }

            int time = random.nextInt(2359);

            while(!isValidTime(time)){
                time = random.nextInt(2359);
            }

            order.setTimeOfPickup(time);
            list.addOrder(order);
        }
    }

    /// Helper-method: get int
    public int getPositiveInt() {
        int result;

        while (true) {
            if (sc.hasNextInt()) { // Checks if user entered a valid int
                result = sc.nextInt(); // Reads the int
                if (result > 0) break;
            }

            System.out.println("Invalid input. Press number");
            sc.nextLine(); // Consume invalid input
        }
        sc.nextLine(); // Consume newline

        return result;
    }

    //Helper-method: get int within specified range
    public int getIntInRange(int min, int max) {
        int result;

        while (true) {
            if (sc.hasNextInt()) { // Checks if user entered an int
                result = sc.nextInt(); // Reads the int
                if (result >= min && result <= max) break; // Validates whether int is in range
            }

            System.out.println("Invalid input. Press number between " + min + " and " + max + ".");
            sc.nextLine(); // Consume invalid input
        }
        sc.nextLine(); // Consume newline

        return result;
    }

    public boolean isValidTime(int time) {
        String pickupTime = String.format("%04d",time);
        if (pickupTime.length() != 4) {
            return false;
        } else if (time < 0 || time > 2359) { //
            return false;
        } else if (pickupTime.charAt(2) > '5') {// checks if the 10-minute mark is valid being
            return false;
        }
        return true;
    }

    public int getValidTime() {
        int result;

        while (true) {
            if (sc.hasNextInt()) { // Checks if user entered a valid int
                result = sc.nextInt(); // Reads the int
                if (isValidTime(result)) break;
            }
            System.out.println("Invalid input. Enter time in format [ttmm]");
            sc.nextLine(); // Consume invalid input
        }
        sc.nextLine(); // Consume newline

        return result;
    }
}