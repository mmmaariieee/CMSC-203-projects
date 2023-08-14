/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: The "BevShopDriverApp" Java program facilitates interactive beverage ordering,
 * where customers provide their details, choose from various beverage options,
 * and receive order summaries based on age restrictions and beverage selections.
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

import java.util.Scanner;

/**
 * 
 * The "BevShopDriverApp" Java program facilitates interactive beverage ordering,
 * where customers provide their details, choose from various beverage options,
 * and receive order summaries based on age restrictions and beverage selections.
 */
public class BevShopDriverApp {
    public static void main(String[] args) {
        // Create an instance of BevShop class
        BevShop bevShop = new BevShop();
        Scanner scanner = new Scanner(System.in);
        
        // Flag to control whether the user wants to continue ordering
        boolean continueOrdering = true;
        
        while (continueOrdering) {
            // Display information about order limits and age requirement
            System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol() +
                               " alcoholic beverages.");
            System.out.println("The minimum age to order alcohol drink is " + bevShop.getMinAgeForAlcohol());
            
            // Collect customer information
            System.out.println("Start please a new order:");
            System.out.print("Enter your name: ");
            String customerName = scanner.nextLine();
            
            System.out.print("Enter your age: ");
            int customerAge = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            System.out.print("Enter the day of the week (MONDAY, TUESDAY, etc.): ");
            String dayString = scanner.nextLine();
            Day day = Day.valueOf(dayString.toUpperCase());

            // Start a new order
            bevShop.startNewOrder(10, day, customerName, customerAge);
            System.out.println("Your Total Order for now is " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));

            // Get customer information from the current order
            Customer customer = bevShop.getCurrentOrder().getCustomer();
            // Check if customer is eligible to order more
            if (bevShop.isEligibleForMore()) {
                if (bevShop.isValidAge(customer.getAge())) {
                    System.out.println("Your age is above " + (bevShop.getMinAgeForAlcohol() - 1) +
                                       " and you are eligible to order alcohol");
                } else {
                    System.out.println("You are not eligible to order alcohol.");
                }

                boolean orderMore = true;
                while (orderMore) {
                    // Offer beverage type choices
                    System.out.println("Choose the type of beverage:\n1. Alcohol\n2. Coffee\n3. Smoothie");
                    System.out.print("Enter your choice: ");
                    int beverageTypeChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (beverageTypeChoice == 1) {
                        // Collect information for alcohol order
                        System.out.print("Enter alcohol beverage name: ");
                        String bevName = scanner.nextLine();
                        System.out.print("Enter beverage size (SMALL, MEDIUM, LARGE): ");
                        Size size = Size.valueOf(scanner.nextLine().toUpperCase());
                        bevShop.processAlcoholOrder(bevName, size);
                    } else if (beverageTypeChoice == 2 || beverageTypeChoice == 3) {
                        // Collect information for coffee or smoothie order
                        System.out.print("Enter beverage name: ");
                        String bevName = scanner.nextLine();
                        System.out.print("Enter beverage size (SMALL, MEDIUM, LARGE): ");
                        Size size = Size.valueOf(scanner.nextLine().toUpperCase());

                        if (beverageTypeChoice == 2) { // Coffee
                            // Collect extra options for coffee
                            System.out.print("Add extra shot? (yes/no): ");
                            boolean extraShot = scanner.nextLine().equalsIgnoreCase("yes");

                            System.out.print("Add extra syrup? (yes/no): ");
                            boolean extraSyrup = scanner.nextLine().equalsIgnoreCase("yes");

                            bevShop.processCoffeeOrder(bevName, size, extraShot, extraSyrup);
                        } else if (beverageTypeChoice == 3) { // Smoothie
                            // Collect additional options for smoothie
                            int numOfFruits = 0;
                            boolean addProtein = false;
                            System.out.print("Enter number of fruits: ");
                            numOfFruits = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character

                            System.out.print("Add protein? (yes/no): ");
                            addProtein = scanner.nextLine().equalsIgnoreCase("yes");

                            bevShop.processSmoothieOrder(bevName, size, numOfFruits, addProtein);
                        }
                    } else {
                        System.out.println("Invalid choice.");
                    }

                    // Check if the customer wants to order more beverages
                    System.out.print("Do you want to order more beverages? (yes/no): ");
                    String orderMoreChoice = scanner.nextLine();
                    orderMore = orderMoreChoice.equalsIgnoreCase("yes");
                }

                // Display the current order details and total price
                System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
                System.out.println("The Total price on the Order is " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));
                
                // Rest of the order process ...

                // Display a separator
                System.out.println("#------------------------------------#");
                
                // Rest of the order process ...

                // Display total price for the second order and overall total
                System.out.println("\nTotal price on the second Order: " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));
                System.out.println("Total amount for all Orders: " + bevShop.totalMonthlySale());
                
                // Ask if the user wants to start a new order
                System.out.print("Would you like to start a new order? (yes/no): ");
                String userChoice = scanner.nextLine();
                continueOrdering = userChoice.equalsIgnoreCase("yes");
            } else {
                System.out.println("You have reached the maximum order limit.");
                
                // Ask if the user wants to start a new order
                System.out.print("Would you like to start a new order? (yes/no): ");
                String userChoice = scanner.nextLine();
                continueOrdering = userChoice.equalsIgnoreCase("yes");
            }
        }
        
        System.out.println("Thank you for using BevShopDriverApp!");
    }
}
