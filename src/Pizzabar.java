import java.util.Scanner;

public class Pizzabar {
    Scanner sc = new Scanner(System.in);
    MenuCard menuCard = new MenuCard();

    public void mainMenu() {
        System.out.println("""
                1. Show menu card
                """);

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> System.out.println(menuCard);
            default -> {
                System.out.println("Invalid input...");
                mainMenu();
            }
        }
    }
}