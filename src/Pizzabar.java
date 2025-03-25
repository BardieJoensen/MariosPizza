import java.util.Random;
import java.util.Scanner;

public class Pizzabar {
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    MenuCard menuCard = new MenuCard();
    Orderlist orderlist = new Orderlist();

    public void runProgram() {
        addTestOrders(orderlist, 10);
            mainMenu();
    }

    public void mainMenu() {

        if(!orderlist.getOrders().isEmpty()) System.out.println(orderlist.printNextOrder());
        System.out.println(orderlist);

        System.out.println("""
                1. Show menu card/edit prices
                2. Take Order
                """);

        System.out.println("Enter number:");
        int choice = getIntInRange(1, 2);

        switch (choice) {
            case 1 -> System.out.println(menuCard);
            case 2 -> takeOrder();
            default -> {
                System.out.println("Invalid input...");
                mainMenu();
            }
        }
    }

    public void takeOrder() {
        boolean finished = false;

        Order order = new Order();

        System.out.println(menuCard);


        while (!finished) {
            System.out.println("Pick Pizza (enter number)");
            int choice = getIntInRange(1, menuCard.getPizzas().size());

            Pizza pizza = menuCard.getPizzas().get(choice - 1);

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

    ///Helper-method: get int
    public int getPositiveInt() {
        int result;

        while (true) {
            if (sc.hasNextInt()) { // Checks if user entered a valid int
                result = sc.nextInt(); // Reads the int
                if(result>0) break;
            }

            System.out.println("Invalid input. Press number");
            sc.nextLine(); // Consume invalid input
        }
        //sc.nextLine(); // Consume newline

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
                if(isValidTime(result)) break;
            }
            System.out.println("Invalid input. Enter time in format [ttmm]");
            sc.nextLine(); // Consume invalid input
        }
        sc.nextLine(); // Consume newline

        return result;
    }

    public void addTestOrders(Orderlist list, int orderAmount){
        for(int i = 0; i<orderAmount; i++) {
            Order order = new Order();
            int lines = random.nextInt(3)+1;
            for(int j = 0; j<lines; j++) {
                int choice = random.nextInt(30)+1;
                int amount = random.nextInt(10)+1;
                order.addOrderline(new Orderline(menuCard.getPizzas().get(choice - 1), amount));
            }
            int time = random.nextInt(2359);
            while(!isValidTime(time)){
                time = random.nextInt(2359);
            }
            order.setTimeOfPickup(time);
            list.addOrder(order);
        }
    }
}