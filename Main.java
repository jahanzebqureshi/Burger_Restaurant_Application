package academy.learnprogramming;

import java.util.Scanner;

class Burger{
    private String roll;
    private String meat;
    private double basePrice;
    public static int additions=0;
    private static double price =0;
    private static String receipt ="";
    private static double toppingsPrice;
    private static int tempAdditions;

    public Burger(String roll, String meat, int quantity) {
        this.roll = roll;
        this.meat = meat;
        this.quantity = quantity;
        if (roll.toLowerCase().equals("whole wheat") && meat.toLowerCase().equals("chicken")){
            this.basePrice = 2.50*quantity;
        }
        else if (roll.toLowerCase().equals("whole wheat") && meat.toLowerCase().equals("beef")){
            this.basePrice = 2.75*quantit;
        }
        else {
            this.basePrice = 2.00*quantity;
        }
        price += basePrice;
    }

    public static int getAdditions() {
        return additions;
    }

    //Add toppings to burger
    public void addToppings (){

        while (additions <=4) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How many toppings would you like to add?");
            System.out.println("Additional Topping options are: Lettuce, Onion, Green Pepper, Mushroom, Tomato, Cheese");
            String toppings = scanner.nextLine();
            int temp = Integer.parseInt(toppings);
            if (temp <=4){

                for (int i = 1; i <= temp; i++) {
                    toppingsPrice = 0;
                    System.out.println("Topping #" + i + ": ");
                    String input = scanner.nextLine();
                    switch (input.toLowerCase()) {
                        case "lettuce":
                            price += 0.25;
                            toppingsPrice = 0.25;
                            break;
                        case "onion":
                            price += 0.20;
                            toppingsPrice = 0.20;
                            break;
                        case "tomato":
                            price += 0.30;
                            toppingsPrice = 0.30;
                            break;
                        case "cheese":
                            price += 1.00;
                            toppingsPrice = 1.00;
                            break;
                        default:
                            price += 0.50;
                            toppingsPrice = 0.50;
                            break;
                    }

                    receipt = receipt + input + " $" + String.format("%.2f", toppingsPrice) + "\n";
                }
                break;
            } else {
                System.out.println("You can't add anymore toppings.");
            }
        }
    }

    public void Receipt(){
        System.out.println("Total price of the burger\nBase Price: $" + basePrice);
        System.out.println(receipt);
        System.out.println("Final price is: $" + String.format("%.2f",price));
    }

}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("How many burgers would you like?");
        int quantity = scanner.nextInt();
        while (quantity != 0){
            System.out.println("Would you like whole wheat or white bread?");
            String roll = scanner.nextLine();
            while (!roll.hasNext || !roll.toLowerCase().equals("whole wheat") || !roll.toLowerCase().equals("white")){
                System.out.println("Invalid input. Please try again.");
                System.out.println("Would you like whole wheat or white bread?");
                roll = scanner.nextLine();
            }
            System.out.println("Would you like beef or chicken?");
            String meat = scanner.nextLine();
            while (!meat.toLowerCase().equals("beef") || !meat.toLowerCase().equals("chicken")){
                System.out.println("Invalid input. Please try again.");
                System.out.println("Would you like beef or chicken?");
                String meat = scanner.nextLine();
            }

        }
    }
}
