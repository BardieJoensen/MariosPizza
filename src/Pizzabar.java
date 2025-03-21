import java.util.Scanner;

public class Pizzabar {
    Scanner sc = new Scanner(System.in);
    MenuCard menuCard = new MenuCard();
    Orderlist orderlist = new Orderlist();

    public void mainMenu() {
        System.out.println(orderlist);

        System.out.println("""
                1. Show menu card
                2. Take Order
                """);

        System.out.println("Enter number:");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> System.out.println(menuCard);
            case 2 -> takeOrder();
            default -> {
                System.out.println("Invalid input...");
                mainMenu();
            }
        }
    }

    public void takeOrder(){
        boolean finished = false;

        Order order = new Order();

        System.out.println(menuCard);


        while(!finished){
            System.out.println("Pick Pizza (enter number)");
            int choice = sc.nextInt();
            sc.nextLine();
            Pizza pizza = menuCard.getPizzas().get(choice-1);

            System.out.println("Enter amount:");
            int amount = sc.nextInt();
            sc.nextLine();

            Orderline orderline = new Orderline(pizza,amount);
            order.addOrderline(orderline);

            System.out.println("add more? [y/n]");
            String strChoice = sc.nextLine();
            if (strChoice.equalsIgnoreCase("n")) finished=true;
        }

        System.out.println("Enter time of pick-up: [ttmm]");
        int time = sc.nextInt();
        sc.nextLine();
        order.setTimeOfPickup(time);

        orderlist.addOrder(order);
    }

    public void runProgram(){
        while(true){
            mainMenu();
        }
    }
}