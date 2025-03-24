import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/// Main software handling logic class. Deals with user input, executes menu actions, displays and stores relevant vars.
public class Pizzabar {
    Scanner sc = new Scanner(System.in);
    MenuCard menuCard = new MenuCard();
    Orderlist orderlist = new Orderlist();

    /// This function displays and handles the main menu as well as the input actions taken by the user.
    public void mainMenu() {
        while (true) {
            // TODO: *VIGTIG* Mangler relevant kontekst, hvordan ser output ud og hvordan hænger det sammen med andre commandline outputs.
            System.out.println(orderlist);

            // Supported Main menu actions to be taken by user
            System.out.println("""
                    Press 1 - Show Menu
                    Press 2 - Add Order
                    
                    Press 5 - Exit Program
                    """);

            System.out.println("Enter number below:");

            // Valideringsfunktion virker unødig
            // int choice = getIntInRange(1, 2);

            // Ensures input is integer, handling error otherwise
            try {
                int menuActionInputToken = sc.nextInt();
                sc.nextLine();
                // Handling user input
                switch (menuActionInputToken) {
                    // Show menu items
                    case 1 -> System.out.println(menuCard);
                    // Handle "takeOrder" action
                    case 2 -> takeOrder();
                    // Exits program
                    case 5 -> {
                        System.out.println("\nExiting Program. Good Bye!");
                        // Breaks outer while loop by returning
                        return;
                    }
                    default -> {
                        System.out.println("Action not supported - valid options are 1 or 2");
                    }

                }
            }
            // Error handling, if input is not integer
            catch (InputMismatchException e) {
                System.out.println("Invalid input - must be number...");
                sc.next();
            }
        }

    }

    /// Handles order logging
    public void takeOrder() {
        boolean finished = false;

        Order order = new Order();

        System.out.println(menuCard);

        // ´getPizzas´ only needs to be called once on ´takeOrder´ call, as the value does not change in the while loop
        ArrayList<Pizza> pizzasOnMenu = menuCard.getPizzas();
        // ´size´ only needs to be called once on ´takeOrder´ call, as the value does not change in the while loop
        int pizzasMenuItemCount = pizzasOnMenu.size();

        while (!finished) {
            System.out.println("Pick Pizza (enter number)");
            int choice = getIntInRange(1, pizzasMenuItemCount);

            Pizza pizza = pizzasOnMenu.get(choice - 1);

            System.out.println("Enter amount:");
            int amount = getPositiveInt();
            sc.nextLine();

            Orderline orderline = new Orderline(pizza, amount);
            order.addOrderline(orderline);

            System.out.println("add more? [y/n]");
            String strChoice = sc.nextLine();
            if (strChoice.equalsIgnoreCase("n")) finished = true;
        }


        System.out.println("Enter time of pick-up: [ttmm]");

        int time = getValidTime();
        order.setTimeOfPickup(time);


        orderlist.addOrder(order);
    }
    /// Namesake - main class method
    public void runProgram() {

        // BREAKING CHANGES
//        while (true) {
        mainMenu();
//        }
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
        String pickupTime = Integer.toString(time);
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